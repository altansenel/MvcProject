package com.dao;

import com.entity.User;

public interface IUserDao extends IBaseDao<User>{
	
	public User getUserByUsername(String username);
}
