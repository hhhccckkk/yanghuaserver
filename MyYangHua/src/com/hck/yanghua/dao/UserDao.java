package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.User;

public interface UserDao {
	//ÊÖ»ú
	public User login(User user);
	public User isExit(String userId);
	public User getUser(Long userId);
	public User getUser(String userId);
	public boolean updateUser(User user);
	public List<User> getAllUsers();

}
