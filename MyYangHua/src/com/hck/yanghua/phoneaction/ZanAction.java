package com.hck.yanghua.phoneaction;

import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.Zan;
import com.hck.yanghua.dao.TieZiDao;
import com.hck.yanghua.dao.ZanDao;

public class ZanAction extends BaseAction {
	private ZanDao zanDao;
	private TieZiDao tieZiDao;

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
		write();
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
