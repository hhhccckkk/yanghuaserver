package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Huitie;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.bean.Xinxi;
import com.hck.yanghua.dao.HuiTieDao;
import com.hck.yanghua.dao.MsgDao;
import com.hck.yanghua.dao.TieZiDao;
import com.hck.yanghua.util.UploadImageUtil;
import com.hck.yanghua.util.UploadImageUtil.UpLoadImageCallBack;
import com.hck.yanghua.vo.HuiTieData;

public class HuiTieAction extends BaseAction implements UpLoadImageCallBack {
	private HuiTieDao hDao;
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

	public HuiTieDao gethDao() {
		return hDao;
	}

	public void sethDao(HuiTieDao hDao) {
		this.hDao = hDao;
	}

	public void addHuiTie() {
		init();
		long uid = getLongData("uid"); //回复信息的用户id
		long tId = getLongData("tid");
		String content = getStringData("content");
		String address = getStringData("address");
		String yuantie = getStringData("yunatie");
		String userName = getStringData("userName");
		int type = getIntData("type");  //1,回帖,2回复用户
        long b_uid=getLongData("buid"); //被回复的用户id
		int hasImg = getIntData("hasImg");
		Huitie huitie = null;
		huitie = new Huitie();
		huitie.setTid(tId);
		huitie.setAddress(address);
		huitie.setContent(content);
		huitie.setHuifuname(userName);
	    huitie.setYuanTie(yuantie);
		User user = new User();
		user.setUid(uid);
		huitie.setType(type);
		huitie.setUser(user);
		huitie.setBuid(b_uid);
		huitie.setTime(new Timestamp(System.currentTimeMillis()).toString());
		if (hasImg == 1) {
			UploadImageUtil.uploadImage(request, response, this, huitie, false);
		} else {
			if (uid!=b_uid) {
				addHuiFuMsg(huitie,hasImg);
			}
			addHuiFu(huitie);
			
		}
	}

	private void addHuiFuMsg(Huitie huitie,int hasImg) {
		Xinxi xinxi = new Xinxi();
		if (hasImg==1) {
			xinxi.setContent(huitie.getContent()+" [图片]");
		}
		xinxi.setContent(huitie.getContent());
		Tiezi tiezi=new Tiezi();
		tiezi.setTid(huitie.getTid());
		xinxi.setTiezi(tiezi);
		xinxi.setTime(new Timestamp(System.currentTimeMillis()).toString());
		xinxi.setType(huitie.getType());
		xinxi.setYuantie(huitie.getYuanTie());
		User user = new User();
		user.setUid(huitie.getUser().getUid());
		xinxi.setUser(user);
		xinxi.setBuid(huitie.getBuid());
		xinxi.setSaleOrNorm(huitie.getType());
		msgDao.addHuiFuMsg(xinxi);
	}

	public void onSuccess(Object data, List<String> datueList,
			List<String> xiaotuList) {
		if (data == null || datueList == null) {
			onError(-1);
			return;
		}
		Huitie huitie = (Huitie) data;
		for (int i = 0; i < datueList.size(); i++) {
			switch (i) {
			case 0:
				huitie.setImage1(datueList.get(0));
				break;
			case 1:
				huitie.setIamge2(datueList.get(1));
				break;
			case 2:
				huitie.setIamge3(datueList.get(2));
				break;

			default:
				break;
			}
		}
		addHuiFu(huitie);
		addHuiFuMsg(huitie,1);
	}

	public void onError(int type) {
		json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		write();
	}

	private void addHuiFu(Huitie huitie) {
		if (huitie.getType()==1) {
			huitie.setYuanTie(null);
		}
		long id = hDao.addHuiTie(huitie);
		if (id > 0) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			Tiezi tiezi = tieZiDao.getTiezi(huitie.getTid());
			tiezi.setPinglunsize(tiezi.getPinglunsize() + 1);
			tiezi.setHuiFuTime(new Timestamp(System.currentTimeMillis())
					.toString());
			tieZiDao.updateTiezi(tiezi);

		} else {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		}
		write();
	}

	public void getHuiTie() {
		init();
		long tid = getLongData("tid");
		int page = getIntData("page");
		int maxSize = getIntData("maxSize");
		if (maxSize <= 0) {
			maxSize = 15;
		}
		List<Huitie> huities = hDao.getHuiTie(tid, page, maxSize);
		if (huities != null && !huities.isEmpty()) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changedata(huities));
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", "");
		}
		write();

	}

	private List<HuiTieData> changedata(List<Huitie> huities) {
		List<HuiTieData> huiTieDaos = new ArrayList<HuiTieData>();
		HuiTieData huiTieData = null;
		for (int i = 0; i < huities.size(); i++) {
			huiTieData = new HuiTieData();
			Huitie huitie = huities.get(i);
			huiTieData.setAddress(huitie.getAddress());
			huiTieData.setContent(huitie.getContent());
			huiTieData.setTime(huitie.getTime());
			huiTieData.setImage1(huitie.getImage1());
			huiTieData.setIamge2(huitie.getIamge2());
			huiTieData.setIamge3(huitie.getIamge3());
			huiTieData.setTid(huitie.getTid());
			huiTieData.setYuanTie(huitie.getYuanTie());
			huiTieData.setName(huitie.getUser().getName());
			huiTieData.setUid(huitie.getUser().getUid());
			huiTieData.setTouxiang(huitie.getUser().getTouxiang());
			if (huitie.getUser().getXingbie() == 1) { // 1男
				huiTieData.setNan(true);
			} else {
				huiTieData.setNan(false);
			}
			huiTieData.setFensi(huitie.getUser().getFensi());
			huiTieData.setType(huitie.getType());
			huiTieData.setHuifuUserName(huitie.getHuifuname());

			huiTieDaos.add(huiTieData);
		}
		return huiTieDaos;
	}

}
