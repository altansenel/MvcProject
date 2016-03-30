

    
        
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserGivenRoleService;
import com.entity.AdminUserGivenRole;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserGivenRoleController")
public class AdminUserGivenRoleController extends BaseController<AdminUserGivenRole>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserGivenRoleController.class);
	@ManagedProperty(value = "#{adminUserGivenRoleService}")
	private IAdminUserGivenRoleService adminUserGivenRoleService;

	@Override
	public void createEntity() {
		AdminUserGivenRole adminUserGivenRole = new AdminUserGivenRole();
		setEntity(adminUserGivenRole);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUserGivenRole>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUserGivenRole());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserGivenRoleService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserGivenRoleService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserGivenRoleService.update(getEntity());
				setMessage("AdminUserGivenRole is successfully updated");
				clean();
			} else {
				this.adminUserGivenRoleService.add(getEntity());
				setMessage("AdminUserGivenRole is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserGivenRoleService.remove(getEntityList().get(row).getId());
			setMessage("AdminUserGivenRole with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserGivenRoleService.getEntityById(getEntityList()
				.get(row).getId()));
		return "adminUserGivenRole?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUserGivenRole());
		return "AdminUserGivenRole?faces-redirect=true";
	}

	public IAdminUserGivenRoleService getAdminUserGivenRoleService() {
		return adminUserGivenRoleService;
	}

	public void setAdminUserGivenRoleService(IAdminUserGivenRoleService adminUserGivenRoleService) {
		this.adminUserGivenRoleService = adminUserGivenRoleService;
	}




	public String addAdminUserGroup(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("adminUserGroupList");
		childDataBean.setName("org.demo.bean.yeni.AdminUserGroup");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "adminUserGroupList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addAdminUserRole(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("adminUserRoleList");
		childDataBean.setName("org.demo.bean.yeni.AdminUserRole");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "adminUserRoleList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addAdminWorkspace(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("adminWorkspaceList");
		childDataBean.setName("org.demo.bean.yeni.AdminWorkspace");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "adminWorkspaceList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}