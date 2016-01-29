package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Guanzhu;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.GuanZhuDao;
import com.hck.yanghua.dao.UserDao;
import com.hck.yanghua.vo.GuanZhuUidData;

public class GuanZhuAction extends BaseAction {
	private GuanZhuDao guanZhuDao;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public GuanZhuDao getGuanZhuDao() {
		return guanZhuDao;
	}

	public void setGuanZhuDao(GuanZhuDao guanZhuDao) {
		this.guanZhuDao = guanZhuDao;
	}

	public void addGuanZhu() {
		init();
		long uid = getLongData("uid");
		long buid = getLongData("buid");
		User user = new User();
		user.setUid(uid);
		User user2 = new User();
		user2.setUid(buid);

		Guanzhu guanzhu = new Guanzhu();
		guanzhu.setUserByUid(user);
		guanzhu.setUserByBuid(user2);
		guanzhu.setTime(new Timestamp(System.currentTimeMillis()).toString());
		long gid = guanZhuDao.addGuanZhu(guanzhu);
		if (gid > 0) {
			json.put("code", Contans.GET_DATA_SUCCESS);
			updateBUser(buid, 1);
			updateUser(uid, 1);
			json.put("gid", gid);
		} else {
			json.put("code", Contans.GET_DATA_ERROR);
		}
		write();
	}

	private void updateBUser(long uid,int size) {
       User user=userDao.getUser(uid);
       if (user!=null) {
    	   user.setFensi(user.getFensi()+size);
           userDao.updateUser(user);
	}
      
	}

	private void updateUser(long uid,int size) {
       User user=userDao.getUser(uid);
       if (user!=null) {
    	   user.setFensi(user.getFensi()+size);
           userDao.updateUser(user);
	}
      
	}

	public void deleteGuanZhu() {
		init();
		long gid = getLongData("gid");
		long buid=getLongData("buid");
		long uid=getLongData("uid");
		boolean b = guanZhuDao.deleteGuanZhu(gid);
		if (b) {
			json.put("code", Contans.GET_DATA_SUCCESS);
			updateBUser(buid, 1);
			updateUser(uid, 1);
		} else {
			json.put("code", Contans.GET_DATA_ERROR);
		}
		write();
	}

	public void getGuanZhuIds() {
		init();
		long uid = getLongData("uid");
		List<Guanzhu> guanzhuIds = guanZhuDao.getGuanzhusUid(uid);
		json.put("code", 0);
		json.put("data", changeGuanZhuIds(guanzhuIds));
		write();
	}

	private List<GuanZhuUidData> changeGuanZhuIds(List<Guanzhu> guanzhus) {
		List<GuanZhuUidData> guanZhuUidDatas = new ArrayList<GuanZhuUidData>();
		for (int i = 0; i < guanzhus.size(); i++) {
			GuanZhuUidData data = new GuanZhuUidData();
			data.setGid(guanzhus.get(i).getId());
			data.setBuid(guanzhus.get(i).getUserByBuid().getUid());
			data.setUid(guanzhus.get(i).getUserByUid().getUid());
			guanZhuUidDatas.add(data);
		}
		return guanZhuUidDatas;

	}

}
