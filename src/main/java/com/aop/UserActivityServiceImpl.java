package com.aop;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BaseServiceImpl;
import com.entity.UserActivity;

 
@Service
public class UserActivityServiceImpl  extends BaseServiceImpl<UserActivity, IUserActivityDao> implements IUserActivityService, Serializable {

//	public UserActivityServiceImpl(IUserActivityDao entityDAO) {
//		super(entityDAO);
//	}
//	
//	public UserActivityServiceImpl() {
//		super();
//	}

	private static final long serialVersionUID = 1L;
	
    @Override
    @Transactional
    public Integer addUserActivity(UserActivity userActivity) {
        return this.getEntityDAO().addUserActivity(userActivity);
    }
 
}
