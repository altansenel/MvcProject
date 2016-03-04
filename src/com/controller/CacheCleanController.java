package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dao.ICacheCleanService;
import com.entity.EntityCache;

@ViewScoped
@ManagedBean(name = "cacheCleanController")
public class CacheCleanController extends BaseController<EntityCache> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(CacheCleanController.class);

	private ICacheCleanService cacheCleanService;

	@Autowired(required = true)
	@Qualifier(value = "cacheCleanService")
	public void setCacheCleanService(ICacheCleanService cacheCleanService) {
		this.cacheCleanService = cacheCleanService;
	}

	public void clearCache() {
		try {
			cacheCleanService.cacheClean(Class.forName(getEntity()
					.getEntityName()));
			setMessage("Sehir is successfully updated");
			clean();
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	@Override
	public void createEntity() {
		setEntity(new EntityCache());
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<EntityCache>());
	}

	@Override
	public void clean() {
		setEntity(new EntityCache());
		getEntityList().clear();
	}

}
