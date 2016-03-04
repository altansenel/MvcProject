package com.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

public class HerHangiBirServiceImpl implements IHerHangiBirService, Serializable{


	private static final long serialVersionUID = 1L;

	@Autowired
    @Qualifier(value="personDAO")
	private IPersonDao personDao;
	
	@Autowired
    @Qualifier(value="userDAO")
	private IUserDao userDao;


	//bu da transactional olarak birden fazla dao nun aynı serviste kullanılması
	@Override
	@Transactional
	public void HerHangiBirIslem() {
		User user2 = userDao.getEntityById(Integer.valueOf("20"));
		personDao.getEntityById(user2.getId());
		return;
	}
}
