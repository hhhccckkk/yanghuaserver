package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.UserDao;
import com.hck.yanghua.vo.UserData;

public class UserAction extends BaseAction {
	private static final int MALE = 1;
	private static final int MAN = 1;
	private static final int WOMAN = 2;
	private UserDao userDao;
	private int MAX_JULI = 1000 * 10;

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
		int xingbie = getIntData("xingbie");
		String touxiang = getStringData("touxiang");
		String userName = getStringData("userName");
		double jingdu = getDoubleData("jingdu");
		double weidu = getDoubleData("weidu");
		String address = getStringData("address");
		String imei = getStringData("imei");
		String city = getStringData("city");
		User user2 = userDao.isExit(userId);
		if (user2 == null) {
			user = new User();
			user.setAddress(address);
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
			user.setUserid(userId);
			user.setXingbie(xingbie);
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
			userData.setUserId(user.getUserid());
			userData.setImei(user.getImei());
			userData.setName(user.getName());
			userData.setXingbie(user.getXingbie());
		}
		return userData;
	}

	public void addUserPushId() {
		init();
		String pushid = getStringData("pushid");
		long uid = getLongData("uid");
		if (pushid == null || uid <= 0) {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			User user = userDao.getUser(uid);
			if (user != null) {
				user.setPushid(pushid);
				boolean b = userDao.updateUser(user);
				if (b) {
					json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
				} else {
					json.put(Contans.CODE, Contans.GET_DATA_ERROR);
				}
			} else {
				json.put(Contans.CODE, Contans.GET_DATA_ERROR);
			}
		}
		write();
	}

	public void getUser() {
		init();
		long uid = getLongData("uid");
		User user = userDao.getUser(uid);
		double jingdu = getDoubleData("jingdu");
		double weidu = getDoubleData("weidu");
		if (jingdu > 0 && user != null) {
			if (user.getJingdu() != jingdu) {
				user.setJingdu(jingdu);
				user.setWeidu(weidu);
				userDao.updateUser(user);
			}
		}
		if (user == null) {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changeUserData(user));
		}
		write();
	}

	public void getUserByStringId() {
		init();
		String userId = getStringData("uid");
		User user = userDao.getUser(userId);
		if (user != null) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", changeUserData(user));
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		}

		write();
	}

	public void getNearUsers() {
		init();
		double jindu = getDoubleData("jindu");
		double weidu = getDoubleData("weidu");
		List<User> users = userDao.getAllUsers();
		List<UserData> users2 = new ArrayList<UserData>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			double juli = 0;
			juli = getDistance(jindu, weidu, user.getWeidu(), user.getJingdu());
			if (juli < MAX_JULI) {
				UserData userData = changeUserData(user);
				userData.setJuli((int) juli);
				users2.add(userData);
			}
		}
		Collections.sort(users2);
		json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
		json.put("data", users2);
		write();
	}

	public static double getDistance(double lat1, double longt1, double lat2,
			double longt2) {
		double PI = 3.14159265358979323; // 圆周率
		double R = 6371229; // 地球的半径
		double x, y, distance;
		x = (longt2 - longt1) * PI * R
				* Math.cos(((lat1 + lat2) / 2) * PI / 180) / 180;
		y = (lat2 - lat1) * PI * R / 180;
		distance = Math.hypot(x, y);
		return distance;
	}

}
