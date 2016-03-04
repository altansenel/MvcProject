package com.aop;

import com.dao.IBaseService;
import com.entity.UserActivity;

public interface IUserActivityService extends IBaseService<UserActivity> {
	
	public Long addUserActivity(UserActivity userActivity);
	
}
