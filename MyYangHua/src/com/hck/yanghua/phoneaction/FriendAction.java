package com.hck.yanghua.phoneaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.classfile.Constant;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Friend;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.FriendDao;
import com.hck.yanghua.dao.UserDao;
import com.hck.yanghua.vo.FriendData;
import com.mysql.jdbc.log.Log;

public class FriendAction extends BaseAction {
	private FriendDao friendDao;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public void addFriend() {
		init();
		String userMsgId = getStringData("userMsgId"); // 好友用户的id
		System.out.print("userMsgId: " + userMsgId);
		User user = userDao.getUser(userMsgId);
		long userId = getLongData("uid"); // 哪个用户的id
		if (user == null) {
			System.out.print("null ");
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		} else {
			Friend friend = new Friend();
			friend.setIsok(1);
			friend.setTime(new Timestamp(System.currentTimeMillis()).toString());
			friend.setUser(user);
			friend.setUid(userId);
			boolean b = friendDao.addFriends(friend);
			if (b) {
				json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			} else {
				json.put(Contans.CODE, Contans.GET_DATA_ERROR);
			}
		}

		write();
	}

	public void getFriends() {
		init();
		long uid = getLongData("uid");

		List<Friend> friends = friendDao.getFriends(uid);
		json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
		json.put("data", changeDatas(friends));
		write();
	}

	private List<FriendData> changeDatas(List<Friend> friends) {
		List<FriendData> friendDatas = new ArrayList<FriendData>();
		FriendData friendData;
		for (int i = 0; i < friends.size(); i++) {
			Friend friend = friends.get(i);
			friendData = new FriendData();
			friendData.setId(friend.getId());
			friendData.setTime(friend.getTime());
			friendData.setUid(friend.getUser().getUid());
			friendData.setUserImg(friend.getUser().getTouxiang());
			friendData.setUserMsgId(friend.getUser().getUserid());
			friendData.setUserName(friend.getUser().getName());
			friendDatas.add(friendData);
		}
		return friendDatas;
	}

}
