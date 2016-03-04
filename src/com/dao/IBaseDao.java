package com.dao;

import java.util.List;


public abstract interface IBaseDao<E> {
	
	public Long add(E entity);

	public void update(E entity);

	public List<E> list();
	
	public List<E> list(E entity);
	
	public E getEntityById(Long id);

	public void remove(Long id);

}
