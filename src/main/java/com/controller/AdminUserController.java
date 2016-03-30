

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserService;
import com.entity.AdminUser;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserController")
public class AdminUserController extends BaseController<AdminUser>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserController.class);
	@ManagedProperty(value = "#{adminUserService}")
	private IAdminUserService adminUserService;

	@Override
	public void createEntity() {
		AdminUser adminUser = new AdminUser();
		setEntity(adminUser);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUser>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUser());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserService.update(getEntity());
				setMessage("AdminUser is successfully updated");
				clean();
			} else {
				this.adminUserService.add(getEntity());
				setMessage("AdminUser is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserService.remove(getEntityList().get(row).getId());
			setMessage("AdminUser with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserService.getEntityById(getEntityList()
				.get(row).getId()));
		return "adminUser?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUser());
		return "AdminUser?faces-redirect=true";
	}

	public IAdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
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



}