package com.hck.yanghua.server;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Friend;
import com.hck.yanghua.dao.FriendDao;

public class FriendServer extends HibernateDaoSupport implements FriendDao {

	public boolean addFriends(Friend friend) {
		try {
			getHibernateTemplate().save(friend);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Friend> getFriends(long uid) {
		String sql = "from Friend f where f.uid="+uid;
		return getHibernateTemplate().find(sql);
	}

	public boolean deleteFriend(String msgId) {
		try {

			getHibernateTemplate().delete(msgId, Friend.class);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
