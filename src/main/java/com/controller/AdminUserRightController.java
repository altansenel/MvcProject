

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminUserRightService;
import com.entity.AdminUserRight;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminUserRightController")
public class AdminUserRightController extends BaseController<AdminUserRight>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminUserRightController.class);
	@ManagedProperty(value = "#{adminUserRightService}")
	private IAdminUserRightService adminUserRightService;

	@Override
	public void createEntity() {
		AdminUserRight adminUserRight = new AdminUserRight();
		setEntity(adminUserRight);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminUserRight>());
	}

	@Override
	public void clean() {
		setEntity(new AdminUserRight());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminUserRightService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminUserRightService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminUserRightService.update(getEntity());
				setMessage("AdminUserRight is successfully updated");
				clean();
			} else {
				this.adminUserRightService.add(getEntity());
				setMessage("AdminUserRight is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminUserRightService.remove(getEntityList().get(row).getId());
			setMessage("AdminUserRight with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminUserRightService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminUserRight?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminUserRight());
		return "AdminUserRight?faces-redirect=true";
	}

	public IAdminUserRightService getAdminUserRightService() {
		return adminUserRightService;
	}

	public void setAdminUserRightService(IAdminUserRightService adminUserRightService) {
		this.adminUserRightService = adminUserRightService;
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
		childDataBean.setFrom("AdminUserRoleList");
		childDataBean.setName("org.demo.bean.yeni.AdminUserRole");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "AdminUserRoleList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}