package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.GeneratedEntity;


@Repository
public class GeneratedEntityDaoImpl extends BaseDaoImpl<GeneratedEntity> implements IGeneratedEntityDao {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public GeneratedEntity getEntityByEntityName(String entity) {
		Session session = this.getSessionFactory().getCurrentSession();
		List<GeneratedEntity> entityList = session
				.createQuery(
						"from "
								+ getEntityClass().getName().split(DOT)[getEntityClass().getName().split(DOT).length-1]
								+ " where entity=:entity").setParameter("entity", entity)
				.list();
		getLogger().info("Entity loaded successfully, details=" + entityList.get(0));
		return entityList.get(0);
	}

}