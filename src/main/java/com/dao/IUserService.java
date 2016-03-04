package com.dao;

import com.entity.Person;
import com.entity.User;

public interface IUserService extends IBaseService<User> {

	public User getUserByUsername(String username);
	
	public Person getPerson(String username) throws Exception;
	

}
