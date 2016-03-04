package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Person;
import com.entity.User;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, IUserDao> implements IUserService {

	private static final long serialVersionUID = 1L;
	
//	private IPersonDao personDao;
//	//birden fazla dao yu aynı service e eklemek iin yöntem ama her dao için bence xml de yer ayrılmalı
//	@Autowired(required=true)
//    @Qualifier(value="personDAO")
//	public void setPersonDao(IPersonDao personDao) {
//		this.personDao = personDao;
//	}
	
	
	//Yukarıdaki doğru ama bu şekilde de kullanılabilir
	//dao ları buraya ekledikten sonra serviste transactional bir yapı olur
	@Autowired(required=true)
    @Qualifier(value="personDAO")
	private IPersonDao personDao;


	//base dışında method yaılırsa BaseServiceImpl'e IUserDao ile extend ol
	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return this.getEntityDAO().getUserByUsername(username);
	}
	
	
	//bu da transaction management için
	@Override
	@Transactional
	public Person getPerson(String username) throws Exception{
		//return this.getEntityDAO().getUserByUsername(username);
		User user = this.getEntityDAO().getEntityById(Long.valueOf(username));
		User user2 = this.getEntityDAO().getEntityById(Long.valueOf("20"));
		user2.setEnabled(false);
		this.getEntityDAO().update(user2);
		if (user ==null) {
			throw new Exception("hata aldı!"); // burada specific de olur sonuçta herhangi bir exception da rollback alır
		}
		return this.personDao.list().get(0);
	}
   
}
