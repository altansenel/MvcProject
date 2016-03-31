



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalProfileService;
import com.entity.GlobalProfile;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalProfileController")
public class GlobalProfileController extends BaseController<GlobalProfile>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalProfileController.class);
	@ManagedProperty(value = "#{globalProfileService}")
	private IGlobalProfileService globalProfileService;

	@Override
	public void createEntity() {
		GlobalProfile globalProfile = new GlobalProfile();
		setEntity(globalProfile);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalProfile>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalProfile());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalProfileService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalProfileService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalProfileService.update(getEntity());
				setMessage("GlobalProfile is successfully updated");
				clean();
			} else {
				this.globalProfileService.add(getEntity());
				setMessage("GlobalProfile is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalProfileService.remove(getEntityList().get(row).getId());
			setMessage("GlobalProfile with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalProfileService.getEntityById(getEntityList()
				.get(row).getId()));
		return "GlobalProfile?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalProfile());
		return "GlobalProfile?faces-redirect=true";
	}

	public IGlobalProfileService getGlobalProfileService() {
		return globalProfileService;
	}

	public void setGlobalProfileService(IGlobalProfileService globalProfileService) {
		this.globalProfileService = globalProfileService;
	}




}