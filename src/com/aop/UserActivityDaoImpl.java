package com.aop;


import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dao.BaseDaoImpl;
import com.entity.UserActivity;


@Repository
public class UserActivityDaoImpl extends BaseDaoImpl<UserActivity> implements IUserActivityDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Long addUserActivity(UserActivity p) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.persist(p);
		getLogger().info("Entity saved successfully, Details=" + p);
		return p.getId();
	}
}



