

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserGroupService;
import com.entity.AdminUserGroup;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserGroupController")
public class AdminUserGroupController extends BaseController<AdminUserGroup>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserGroupController.class);
	@ManagedProperty(value = "#{adminUserGroupService}")
	private IAdminUserGroupService adminUserGroupService;

	@Override
	public void createEntity() {
		AdminUserGroup adminUserGroup = new AdminUserGroup();
		setEntity(adminUserGroup);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUserGroup>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUserGroup());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserGroupService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserGroupService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserGroupService.update(getEntity());
				setMessage("AdminUserGroup is successfully updated");
				clean();
			} else {
				this.adminUserGroupService.add(getEntity());
				setMessage("AdminUserGroup is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserGroupService.remove(getEntityList().get(row).getId());
			setMessage("AdminUserGroup with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserGroupService.getEntityById(getEntityList()
				.get(row).getId()));
		return "adminUserGroup?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUserGroup());
		return "AdminUserGroup?faces-redirect=true";
	}

	public IAdminUserGroupService getAdminUserGroupService() {
		return adminUserGroupService;
	}

	public void setAdminUserGroupService(IAdminUserGroupService adminUserGroupService) {
		this.adminUserGroupService = adminUserGroupService;
	}




}