

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserRoleService;
import com.entity.AdminUserRole;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserRoleController")
public class AdminUserRoleController extends BaseController<AdminUserRole>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserRoleController.class);
	@ManagedProperty(value = "#{adminUserRoleService}")
	private IAdminUserRoleService adminUserRoleService;

	@Override
	public void createEntity() {
		AdminUserRole adminUserRole = new AdminUserRole();
		setEntity(adminUserRole);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUserRole>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUserRole());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserRoleService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserRoleService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserRoleService.update(getEntity());
				setMessage("AdminUserRole is successfully updated");
				clean();
			} else {
				this.adminUserRoleService.add(getEntity());
				setMessage("AdminUserRole is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserRoleService.remove(getEntityList().get(row).getId());
			setMessage("AdminUserRole with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserRoleService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminUserRole?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUserRole());
		return "AdminUserRole?faces-redirect=true";
	}

	public IAdminUserRoleService getAdminUserRoleService() {
		return adminUserRoleService;
	}

	public void setAdminUserRoleService(IAdminUserRoleService adminUserRoleService) {
		this.adminUserRoleService = adminUserRoleService;
	}




}