package com.aop;

import com.dao.IBaseDao;
import com.entity.UserActivity;

public interface IUserActivityDao extends IBaseDao<UserActivity>{
	
	public Integer addUserActivity(UserActivity userActivity);
	
}
