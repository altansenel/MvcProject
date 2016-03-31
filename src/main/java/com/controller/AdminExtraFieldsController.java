



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminExtraFieldsService;
import com.entity.AdminExtraFields;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminExtraFieldsController")
public class AdminExtraFieldsController extends BaseController<AdminExtraFields>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminExtraFieldsController.class);
	@ManagedProperty(value = "#{adminExtraFieldsService}")
	private IAdminExtraFieldsService adminExtraFieldsService;

	@Override
	public void createEntity() {
		AdminExtraFields adminExtraFields = new AdminExtraFields();
		setEntity(adminExtraFields);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminExtraFields>());
	}

	@Override
	public void clean() {
		setEntity(new AdminExtraFields());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminExtraFieldsService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminExtraFieldsService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminExtraFieldsService.update(getEntity());
				setMessage("AdminExtraFields is successfully updated");
				clean();
			} else {
				this.adminExtraFieldsService.add(getEntity());
				setMessage("AdminExtraFields is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminExtraFieldsService.remove(getEntityList().get(row).getId());
			setMessage("AdminExtraFields with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminExtraFieldsService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminExtraFields?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminExtraFields());
		return "AdminExtraFields?faces-redirect=true";
	}

	public IAdminExtraFieldsService getAdminExtraFieldsService() {
		return adminExtraFieldsService;
	}

	public void setAdminExtraFieldsService(IAdminExtraFieldsService adminExtraFieldsService) {
		this.adminExtraFieldsService = adminExtraFieldsService;
	}




}