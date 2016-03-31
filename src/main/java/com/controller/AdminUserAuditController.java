



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserAuditService;
import com.entity.AdminUserAudit;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserAuditController")
public class AdminUserAuditController extends BaseController<AdminUserAudit>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserAuditController.class);
	@ManagedProperty(value = "#{adminUserAuditService}")
	private IAdminUserAuditService adminUserAuditService;

	@Override
	public void createEntity() {
		AdminUserAudit adminUserAudit = new AdminUserAudit();
		setEntity(adminUserAudit);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUserAudit>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUserAudit());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserAuditService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserAuditService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserAuditService.update(getEntity());
				setMessage("AdminUserAudit is successfully updated");
				clean();
			} else {
				this.adminUserAuditService.add(getEntity());
				setMessage("AdminUserAudit is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserAuditService.remove(getEntityList().get(row).getId());
			setMessage("AdminUserAudit with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserAuditService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminUserAudit?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUserAudit());
		return "AdminUserAudit?faces-redirect=true";
	}

	public IAdminUserAuditService getAdminUserAuditService() {
		return adminUserAuditService;
	}

	public void setAdminUserAuditService(IAdminUserAuditService adminUserAuditService) {
		this.adminUserAuditService = adminUserAuditService;
	}




}