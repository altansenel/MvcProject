



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminSettingService;
import com.entity.AdminSetting;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminSettingController")
public class AdminSettingController extends BaseController<AdminSetting>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminSettingController.class);
	@ManagedProperty(value = "#{adminSettingService}")
	private IAdminSettingService adminSettingService;

	@Override
	public void createEntity() {
		AdminSetting adminSetting = new AdminSetting();
		setEntity(adminSetting);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminSetting>());
	}

	@Override
	public void clean() {
		setEntity(new AdminSetting());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminSettingService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminSettingService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminSettingService.update(getEntity());
				setMessage("AdminSetting is successfully updated");
				clean();
			} else {
				this.adminSettingService.add(getEntity());
				setMessage("AdminSetting is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminSettingService.remove(getEntityList().get(row).getId());
			setMessage("AdminSetting with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminSettingService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminSetting?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminSetting());
		return "AdminSetting?faces-redirect=true";
	}

	public IAdminSettingService getAdminSettingService() {
		return adminSettingService;
	}

	public void setAdminSettingService(IAdminSettingService adminSettingService) {
		this.adminSettingService = adminSettingService;
	}




}