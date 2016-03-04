package com.dao;

import com.entity.GeneratedEntity;


public interface IGeneratedEntityService extends IBaseService<GeneratedEntity> {
	
	public GeneratedEntity getEntityByEntityName(String entity);

}