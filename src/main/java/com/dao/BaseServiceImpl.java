package com.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class BaseServiceImpl<E,IDao extends IBaseDao<E>> implements IBaseService<E> , Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private IDao entityDAO;
   
    public IDao getEntityDAO() {
		return entityDAO;
	}

	public void setEntityDAO(IDao entityDAO) {
        this.entityDAO = entityDAO;
    }
 
    @Override
    @Transactional
    public Long add(E entity) {
        return this.entityDAO.add(entity);
    }
 
    @Override
    @Transactional
    public void update(E entity) {
        this.entityDAO.update(entity);
    }
 
    @Override
    @Transactional
    public List<E> list() {
        return this.entityDAO.list();
    }
    
    @Override
    @Transactional
    public List<E> list(E entity) {
        return this.entityDAO.list(entity);
    }
 
    @Override
    @Transactional
    public E getEntityById(Long id) {
        return this.entityDAO.getEntityById(id);
    }
    
    @Override
    @Transactional
    public void remove(Long id) {
        this.entityDAO.remove(id);
    }


}

