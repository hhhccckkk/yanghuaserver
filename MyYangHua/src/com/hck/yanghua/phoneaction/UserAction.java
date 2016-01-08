package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.UserDao;
import com.hck.yanghua.vo.UserData;

public class UserAction extends BaseAction {
	private static final String MALE = "m";
	private static final int MAN = 1;
	private static final int WOMAN = 2;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void loginUser() {
		User user = null;
		init();
		String userId = getStringData("userId");
		String xingbie = getStringData("xingbie");
		String touxiang = getStringData("touxiang");
		String userName = getStringData("userName");
		double jingdu = getDoubleData("jingdu");
		double weidu = getDoubleData("weidu");
		String address = getStringData("address");
		String imei=getStringData("imei");
		String city=getStringData("city");
		User user2 = userDao.isExit(userId);
		if (user2 == null) {
			user = new User();
			user.setAddress(address);
			user.setAihao("нч");
			user.setDongtai(0);
			user.setFensi(0);
			user.setGuanzhu(0);
			user.setJifeng(0l);
			user.setJinbi(0);
			user.setJingdu(jingdu);
			user.setWeidu(weidu);
			user.setName(userName);
			user.setTouxiang(touxiang);
			user.setCity(city);
			user.setImei(imei);
			user.setPassword("123456");
			user.setType(Contans.USER_TYPE_NORM);
			user.setLogintime(new Timestamp(System.currentTimeMillis()));
			user.setTime(new Timestamp(System.currentTimeMillis()).toString());
			user.setUserId(userId);
			if (MALE.equals(xingbie)) {
				user.setXingbie(MAN);
			} else {
				user.setXingbie(WOMAN);
			}
			user = userDao.login(user);
			if (user == null) {
				json.put(Contans.CODE, Contans.GET_DATA_ERROR);
			} else {
				json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
				json.put("data", changeUserData(user));

			}
		} else {
			if (jingdu > 0 && weidu > 0 && jingdu != user2.getJingdu()) {
				user2.setJingdu(jingdu);
				user2.setWeidu(weidu);
				userDao.updateUser(user2);
			}
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changeUserData(user2));
		}
		write();

	}

	private UserData changeUserData(User user) {
		UserData userData = new UserData();
		if (user != null) {
			userData.setAddress(user.getAddress());
			userData.setAihao(user.getAihao());
			userData.setDongtai(user.getDongtai());
			userData.setFensi(user.getFensi());
			userData.setGuanzhu(user.getGuanzhu());
			userData.setJifeng(user.getJifeng());
			userData.setJinbi(user.getJinbi());
			userData.setJingdu(user.getJingdu());
			userData.setWeidu(user.getWeidu());
			userData.setLogintime(user.getLogintime().toString());
			userData.setTouxiang(user.getTouxiang());
			userData.setType(user.getType());
			userData.setUid(user.getUid());
			userData.setUserId(user.getUserId());
			userData.setImei(user.getImei());
		}
		return userData;
	}

}
