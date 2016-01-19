package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.TieZiDao;
import com.hck.yanghua.util.UploadImageUtil;
import com.hck.yanghua.util.UploadImageUtil.UpLoadImageCallBack;
import com.hck.yanghua.vo.TieZiData;

public class TieZiAction extends BaseAction implements UpLoadImageCallBack {
	private static final int MAX_CONTENT_SIZE = 600;
	private static final int HAS_IMAGE = 1;
	private TieZiDao tieZiDao;

	public TieZiDao getTieZiDao() {
		return tieZiDao;
	}

	public void setTieZiDao(TieZiDao tieZiDao) {
		this.tieZiDao = tieZiDao;
	}

	// 增加帖子，初始化帖子数据
	public void addTieZi() {
		Tiezi tiezi = null;
		tiezi = new Tiezi();
		init();
		long uid = getLongData("uid");
		String content = getStringData("content");
		String address = getStringData("address");
		int type = getIntData("type");
		if (uid <= 0 || content == null || content.length() > MAX_CONTENT_SIZE) {
			return;
		}
		User user = new User();
		user.setUid(uid);
		tiezi.setUser(user);
		tiezi.setContent(content);
		tiezi.setAddress(address);
		tiezi.setType(type); // type 1一般分享帖子,2出售帖子
		tiezi.setUser(user);
		int hasImage = getIntData("hasImage");
		if (hasImage == HAS_IMAGE) { // 有图片，先上传图片
			UploadImageUtil.uploadImage(request, response, this, tiezi, true);
		} else {
			addTieZiToServer(tiezi); // 没有图片直接增加帖子信息到数据库
		}

	}

	private void addTieZiToServer(Tiezi tiezi) {
		if (tiezi == null) {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			long id = 0l;
			tiezi.setDingsize(0);
			tiezi.setDingsize(0);
			tiezi.setIsjinghua(0);
			tiezi.setIstuijian(0);
			tiezi.setIszhiding(0);
			tiezi.setPinglunsize(0);
			String addTieZiTime = new Timestamp(System.currentTimeMillis())
					.toString();
			tiezi.setTime(addTieZiTime);
			tiezi.setHuiFuTime(addTieZiTime);
			id = tieZiDao.addTieZi(tiezi);
			if (id < 0) {
				json.put(Contans.CODE, Contans.GET_DATA_ERROR);
			} else {
				json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
				json.put("tid", id);
			}
		}
		write();
	}

	/**
	 * 增加图片成功，把返回的图片地址加入帖子里面，然后增加帖子信息 datuList 原图 xiaotuList 缩略图地址
	 */
	public void onSuccess(Object tiezi, List<String> datuList,
			List<String> xiaotu) {
		Tiezi tiezi2 = (Tiezi) tiezi;
		for (int i = 0; i < datuList.size(); i++) {
			switch (i) {
			case 0:
				tiezi2.setTupian1(datuList.get(0));
				break;
			case 1:
				tiezi2.setTupian2(datuList.get(1));
				break;
			case 2:
				tiezi2.setTupian3(datuList.get(2));
				break;
			case 3:
				tiezi2.setTupian4(datuList.get(3));
				break;
			case 4:
				tiezi2.setTupian5(datuList.get(4));
				break;

			default:
				break;
			}
		}
		for (int i = 0; i < xiaotu.size(); i++) {
			switch (i) {
			case 0:
				tiezi2.setTupian6(xiaotu.get(0));
				break;
			case 1:
				tiezi2.setTupian7(xiaotu.get(1));
				break;
			default:
				break;
			}
		}
		addTieZiToServer(tiezi2);
	}

	public void onError(int type) {
		init();
		json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		json.put("errorType", type);
		write();
	}

	// 获取帖子信息,一般帖子,从最新的取
	public void getTieZi() {
		init();
		int maxSize = getIntData("maxSize");
		int page = getIntData("page");
		int type = getIntData("type");
		List<Tiezi> tiezis = tieZiDao.getTiezis(type, page, maxSize);
		if (tiezis == null) {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changeData(tiezis));
		}
		write();
	}

	// 帖子按照从评论由多到少排序
	public void getHotTieZi() {
		init();
		int maxSize = getIntData("maxSize");
		int page = getIntData("page");
		List<Tiezi> tiezis = tieZiDao.getHotTiezis(page, maxSize);
		if (tiezis == null) {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changeData(tiezis));
		}
		write();
	}

	private List<TieZiData> changeData(List<Tiezi> tiezis) {
		List<TieZiData> tieZiDatas = new ArrayList<TieZiData>();
		TieZiData tieZiData = null;
		if (tiezis == null) {
			return null;
		}
		for (int i = 0; i < tiezis.size(); i++) {
			Tiezi tiezi = tiezis.get(i);
			tieZiData = new TieZiData();
			tieZiData.setContent(tiezi.getContent());
			tieZiData.setDingsize(tiezi.getDingsize());
			tieZiData.setIsjinghua(tiezi.getIsjinghua());
			tieZiData.setIstuijian(tiezi.getIstuijian());
			tieZiData.setIszhiding(tiezi.getIszhiding());
			tieZiData.setPinglunsize(tiezi.getPinglunsize());
			tieZiData.setTid(tiezi.getTid());
			tieZiData.setTime(tiezi.getTime());
			tieZiData.setTupian1(tiezi.getTupian1());
			tieZiData.setTupian2(tiezi.getTupian2());
			tieZiData.setTupian3(tiezi.getTupian3());
			tieZiData.setTupian4(tiezi.getTupian4());
			tieZiData.setTupian5(tiezi.getTupian5());
			tieZiData.setTupian6(tiezi.getTupian6());
			tieZiData.setTupian7(tiezi.getTupian7());
			tieZiData.setType(tiezi.getType());
			User user = tiezi.getUser();
			tieZiData.setUid(user.getUid());
			tieZiData.setTouxiang(user.getTouxiang());
			tieZiData.setName(user.getName());
			tieZiData.setJifeng(user.getJifeng());
			tieZiData.setFensi(user.getFensi());
			tieZiData.setHuiFuTime(tiezi.getHuiFuTime());
			String address = tiezi.getAddress();
			if (address == null || "".equals(address)) {
				tieZiData.setAddress(user.getAddress());
			} else {
				tieZiData.setAddress(address);
			}

			int isNan = user.getXingbie();
			if (isNan == 1) {// 1男
				tieZiData.setNan(true);
			} else {
				tieZiData.setNan(false);
			}
			tieZiDatas.add(tieZiData);

		}
		return tieZiDatas;
	}

}
