package com.hck.yanghua.dao;

import com.hck.yanghua.bean.User;

public interface UserDao {
	public User login(User user);
	public User isExit(String userId);
	public User getUser(String userId);
	public boolean updateUser(User user);

}
