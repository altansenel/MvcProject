package com.dao;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.GeneratedEntity;


@Service
public class GeneratedEntityServiceImpl extends BaseServiceImpl<GeneratedEntity, IGeneratedEntityDao> implements IGeneratedEntityService,Serializable {
	
	private static final long serialVersionUID = 1L;

    @Override
    @Transactional
    public GeneratedEntity getEntityByEntityName(String entity) {
        return this.getEntityDAO().getEntityByEntityName(entity);
    }
}

