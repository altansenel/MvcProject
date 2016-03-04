package com.dao;

import org.springframework.transaction.annotation.Transactional;

public class CacheCleanService implements ICacheCleanService{
	
    private ICacheClean cacheClean;
    
    public void setCacheClean(ICacheClean cacheClean) {
        this.cacheClean = cacheClean;
    }
 
    @Override
    @Transactional
    public <T> void cacheClean(Class<T> cls) {
        this.cacheClean.cacheClean(cls);
    }

}
