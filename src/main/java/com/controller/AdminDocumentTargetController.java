



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminDocumentTargetService;
import com.entity.AdminDocumentTarget;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminDocumentTargetController")
public class AdminDocumentTargetController extends BaseController<AdminDocumentTarget>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminDocumentTargetController.class);
	@ManagedProperty(value = "#{adminDocumentTargetService}")
	private IAdminDocumentTargetService adminDocumentTargetService;

	@Override
	public void createEntity() {
		AdminDocumentTarget adminDocumentTarget = new AdminDocumentTarget();
		setEntity(adminDocumentTarget);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminDocumentTarget>());
	}

	@Override
	public void clean() {
		setEntity(new AdminDocumentTarget());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminDocumentTargetService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminDocumentTargetService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminDocumentTargetService.update(getEntity());
				setMessage("AdminDocumentTarget is successfully updated");
				clean();
			} else {
				this.adminDocumentTargetService.add(getEntity());
				setMessage("AdminDocumentTarget is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminDocumentTargetService.remove(getEntityList().get(row).getId());
			setMessage("AdminDocumentTarget with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminDocumentTargetService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminDocumentTarget?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminDocumentTarget());
		return "AdminDocumentTarget?faces-redirect=true";
	}

	public IAdminDocumentTargetService getAdminDocumentTargetService() {
		return adminDocumentTargetService;
	}

	public void setAdminDocumentTargetService(IAdminDocumentTargetService adminDocumentTargetService) {
		this.adminDocumentTargetService = adminDocumentTargetService;
	}




}