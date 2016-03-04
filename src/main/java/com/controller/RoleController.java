package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IRoleService;
import com.dao.IRoleUserService;
import com.entity.Role;
import com.entity.RoleUser;
import com.entity.User;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

//@SessionScoped
////@RequestScoped
@ViewScoped
//@ConversationScoped
@ManagedBean(name = "roleController")
public class RoleController extends BaseController<Role> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RoleController.class);

	

	// burada managed property kaldırılıp direct inversion da yapılabilirdi
	@ManagedProperty(value = "#{roleService}")
	private IRoleService roleService;

	@ManagedProperty(value = "#{roleUserService}")
	private IRoleUserService roleUserService;


	@Override
	public void createEntity() {
		Role role = new Role();
		role.setRoleUserList(new ArrayList<RoleUser>());
		setEntity(role);	
	}
	
	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Role>());	
	}
	
	@Override
	public void setEid(Long eid) {
		setEntity(roleService.getEntityById(eid));
		this.eid = eid; 
	}


	@PostConstruct
	public void init() {
		initBase();
	}
	
	public String userEkle(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToMany_1);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("userList");
		childDataBean.setName("com.entity.User");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "userList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}
	
	public String addRole() {
		setMessage(null);
		return "role?faces-redirect=true";
	}

	public void searchRole() {
		setMessage(null);
		setEntityList(this.roleService.list(getEntity()));
	}
	
	public String selectRole(int row) {
		User user = (User)getDataBean().getObj();
		RoleUser roleUser = new RoleUser();
		roleUser.setRole(getEntityList().get(row));
		roleUser.setUser(user);
		//roleUser.getRole().getRoleUserList().add(roleUser);
		user.getRoleUserList().add(roleUser);
		getDataBean().setObj(user);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", getDataBean());
		return getFrom() + "?faces-redirect=true&" + STORED_OBJECT_NAME +"=" + user.getClass().getName();
	}
	
	

	public void saveRole(Long id) {
		try {
			if (id != null) {
				this.roleService.update(getEntity());
				setMessage("User is successfully updated");
				clean();
			} else {
				this.roleService.add(getEntity());
				setMessage("User is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void removeRoleUserList(Long id) {
		this.roleUserService.remove(id);
	}

	public void addRoleUserList(RoleUser roleUser) {
		roleUser.setRole(getEntity());
		this.roleUserService.add(roleUser);
	}

	public void removeRole(int row) {
		try {
			this.roleService.remove(getEntityList().get(row).getId());
			setMessage("User with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String editRole(int id) {
		return "role?faces-redirect=true&entityId=" + getEntityList().get(id).getId();
	}

	public String newRole() {
		setMessage(null);
		setEntity(new Role());
		return "role?faces-redirect=true";
	}

	public void clean() {
		setEntity(new Role());
		getEntityList().clear();
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public IRoleUserService getRoleUserService() {
		return roleUserService;
	}

	public void setRoleUserService(IRoleUserService roleUserService) {
		this.roleUserService = roleUserService;
	}



}