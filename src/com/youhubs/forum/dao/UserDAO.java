package com.youhubs.forum.dao;

import java.util.List;

import com.youhubs.forum.bean.User;

public interface UserDAO {
	public int addUser(User user);

	public int updateUser(User user);

	public User getUser(Integer id);

	public int deleteUser(Integer id);

	public List<User> listUser();
}
