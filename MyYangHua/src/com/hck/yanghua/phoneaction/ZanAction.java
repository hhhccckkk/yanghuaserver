package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Huitie;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.bean.Xinxi;
import com.hck.yanghua.bean.Zan;
import com.hck.yanghua.dao.MsgDao;
import com.hck.yanghua.dao.TieZiDao;
import com.hck.yanghua.dao.ZanDao;

public class ZanAction extends BaseAction {
	private ZanDao zanDao;
	private TieZiDao tieZiDao;
	private MsgDao msgDao;

	public MsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}

	public TieZiDao getTieZiDao() {
		return tieZiDao;
	}

	public void setTieZiDao(TieZiDao tieZiDao) {
		this.tieZiDao = tieZiDao;
	}

	public ZanDao getZanDao() {
		return zanDao;
	}

	public void setZanDao(ZanDao zanDao) {
		this.zanDao = zanDao;
	}

	// 增加赞
	public void addZan() {
		init();
		long zId = getLongData("id");
		long userId = getLongData("uid");
		String userImg = getStringData("img");

		String yuantie = getStringData("yuantie");
		long beiZanUserId = getLongData("buid");
		int type = getIntData("type");
		System.out.println("data: " + yuantie + ": " + beiZanUserId + ": "
				+ type);

		Zan zan = new Zan();
		zan.setImage(userImg);
		zan.setTid(zId);
		zan.setUid(userId);
		boolean b = zanDao.addZan(zan);
		if (b) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			Tiezi tiezi = tieZiDao.getTiezi(zId);
			if (tiezi != null) {
				tiezi.setDingsize(tiezi.getDingsize() + 1);
				tieZiDao.updateTiezi(tiezi);
			}
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		}
		if (userId != beiZanUserId) {
			Huitie huitie = new Huitie();
			huitie.setBuid(beiZanUserId);
			huitie.setContent("赞了你的帖子");
			huitie.setTid(zId);
			huitie.setType(type);
			huitie.setYuanTie(yuantie);
			addHuiFuMsg(huitie, userId);
		}

		write();
	}

	private void addHuiFuMsg(Huitie huitie, long uid) {
		Xinxi xinxi = new Xinxi();
		xinxi.setContent(huitie.getContent());
		Tiezi tiezi = new Tiezi();
		tiezi.setTid(huitie.getTid());
		xinxi.setTiezi(tiezi);
		xinxi.setTime(new Timestamp(System.currentTimeMillis()).toString());
		xinxi.setType(huitie.getType());
		xinxi.setYuantie(huitie.getYuanTie());
		xinxi.setIsred(0);
		User user = new User();
		user.setUid(uid);
		xinxi.setUser(user);
		xinxi.setBuid(huitie.getBuid());
		xinxi.setSaleOrNorm(huitie.getType());
		msgDao.addHuiFuMsg(xinxi);
	}

	// 获取赞
	public void getZan() {
		init();
		long tid = getLongData("tid");
		if (tid < 0) {
			return;
		}
		List<Zan> zans = zanDao.getZans(tid);
		json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
		json.put("data", zans);
		write();
	}
}
