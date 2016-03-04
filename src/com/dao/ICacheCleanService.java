package com.dao;


public interface ICacheCleanService {

	public <T> void cacheClean(Class<T> cls);
	
}
