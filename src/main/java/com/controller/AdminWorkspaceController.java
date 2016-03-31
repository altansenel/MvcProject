

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminWorkspaceService;
import com.entity.AdminWorkspace;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminWorkspaceController")
public class AdminWorkspaceController extends BaseController<AdminWorkspace>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminWorkspaceController.class);
	@ManagedProperty(value = "#{adminWorkspaceService}")
	private IAdminWorkspaceService adminWorkspaceService;

	@Override
	public void createEntity() {
		AdminWorkspace adminWorkspace = new AdminWorkspace();
		setEntity(adminWorkspace);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminWorkspace>());
	}

	@Override
	public void clean() {
		setEntity(new AdminWorkspace());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminWorkspaceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminWorkspaceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminWorkspaceService.update(getEntity());
				setMessage("AdminWorkspace is successfully updated");
				clean();
			} else {
				this.adminWorkspaceService.add(getEntity());
				setMessage("AdminWorkspace is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminWorkspaceService.remove(getEntityList().get(row).getId());
			setMessage("AdminWorkspace with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminWorkspaceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminWorkspace?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminWorkspace());
		return "AdminWorkspace?faces-redirect=true";
	}

	public IAdminWorkspaceService getAdminWorkspaceService() {
		return adminWorkspaceService;
	}

	public void setAdminWorkspaceService(IAdminWorkspaceService adminWorkspaceService) {
		this.adminWorkspaceService = adminWorkspaceService;
	}




}