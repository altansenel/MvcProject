package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IPermissionService;
import com.entity.Permission;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "permissionController")
public class PermissionController extends BaseController<Permission> implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(PermissionController.class);
	@ManagedProperty(value = "#{permissionService}")
	private IPermissionService permissionService;

	@Override
	public void createEntity() {
		Permission permission = new Permission();
		setEntity(permission);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Permission>());
	}

	@Override
	public void clean() {
		setEntity(new Permission());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(permissionService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.permissionService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.permissionService.update(getEntity());
				setMessage("Permission is successfully updated");
				clean();
			} else {
				this.permissionService.add(getEntity());
				setMessage("Permission is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.permissionService.remove(getEntityList().get(row).getId());
			setMessage("Permission with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.permissionService.getEntityById(getEntityList().get(row)
				.getId()));
		return "permission?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Permission());
		return "permission?faces-redirect=true";
	}

	public IPermissionService getPersonService() {
		return permissionService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public String rolePermissionEkleOneToMany(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName("permission");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "roleList?faces-redirect=true&from=" + pageName
				+ "&relationType=" + RelationType.manyToMany_2.ordinal();
	}

	public void removeRolePermission(int row) {
		getEntity().getRolePermissionList().remove(row);
	}

	public String menuEkleOneToMany(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.oneToMany);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("menuList");
		childDataBean.setName("com.entity.Menu");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "menuList?faces-redirect=true&addSelect="
				+ AddSelect.ADD.ordinal();
	}

	public void removeMenu(int row) {
		getEntity().getMenuList().remove(row);
	}

}