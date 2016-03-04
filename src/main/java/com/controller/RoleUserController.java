package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IRoleUserService;
import com.entity.RoleUser;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "roleUserController")
public class RoleUserController extends BaseController<RoleUser> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RoleUserController.class);
	@ManagedProperty(value = "#{roleUserService}")
	private IRoleUserService roleUserService;

	@Override
	public void createEntity() {
		RoleUser roleUser = new RoleUser();
		setEntity(roleUser);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<RoleUser>());
	}

	@Override
	public void clean() {
		setEntity(new RoleUser());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(roleUserService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.roleUserService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.roleUserService.update(getEntity());
				setMessage("RoleUser is successfully updated");
				clean();
			} else {
				this.roleUserService.add(getEntity());
				setMessage("RoleUser is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.roleUserService.remove(getEntityList().get(row).getId());
			setMessage("RoleUser with id: " + getEntityList().get(row).getId() + " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.roleUserService.getEntityById(getEntityList().get(row).getId()));
		return "roleUser?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new RoleUser());
		return "roleUser?faces-redirect=true";
	}

	public IRoleUserService getPersonService() {
		return roleUserService;
	}

	public void setRoleUserService(IRoleUserService roleUserService) {
		this.roleUserService = roleUserService;
	}

	public String addRole(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", dataBean);
		return "roleList?faces-redirect=true&from=" + pageName + "&relationType=" + RelationType.manyToOne.ordinal();
	}

	public String addUser(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", dataBean);
		return "userList?faces-redirect=true&from=" + pageName + "&relationType=" + RelationType.manyToOne.ordinal();
	}

}