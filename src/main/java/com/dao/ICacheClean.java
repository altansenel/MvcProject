package com.dao;


public interface ICacheClean {

	public <T> void cacheClean(Class<T> cls);
}
