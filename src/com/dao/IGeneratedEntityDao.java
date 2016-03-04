package com.dao;

import com.entity.GeneratedEntity;




public interface IGeneratedEntityDao extends IBaseDao<GeneratedEntity>{
	
	public GeneratedEntity getEntityByEntityName(String entity);

}
