package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheCleanImpl implements ICacheClean{

    private static final Logger logger = LoggerFactory.getLogger(CacheCleanImpl.class);
    
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public <T> void cacheClean(Class<T> cls) {
        Session session = this.sessionFactory.getCurrentSession();     
        session.getSessionFactory().getCache().evictEntityRegion(cls);
        logger.info("Entity is cleaned , Entity Details="+ cls);
    }

}
