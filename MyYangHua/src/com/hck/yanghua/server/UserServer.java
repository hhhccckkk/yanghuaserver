package com.hck.yanghua.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.UserDao;

public class UserServer extends HibernateDaoSupport implements UserDao {

	public User login(User user) {
		long uid=(Long) getHibernateTemplate().save(user);
		getHibernateTemplate().flush();
		return (User) getHibernateTemplate().get(User.class, uid);
	}

	public User isExit(String userId) {
		User user = null;
		user = getUser(userId);
		if (user == null) {
			return null;
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public User getUser(String userID) {
		String sqlString = "from User u where u.userId='" + userID + "'";
		List<User> users = new ArrayList<User>();
		users = getHibernateTemplate().find(sqlString);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public boolean updateUser(User user) {
		try {
			getHibernateTemplate().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public User getUser(Long userId) {
		return (User) getHibernateTemplate().get(User.class, userId);
	}

}
