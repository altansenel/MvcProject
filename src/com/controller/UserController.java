package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dao.IUserService;
import com.entity.Person;
import com.entity.User;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "userController")
public class UserController extends BaseController<User> implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserController.class);
	@ManagedProperty(value = "#{userService}")
	private IUserService userService;

	@Override
	public void createEntity() {
		User user = new User();
		setEntity(user);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<User>());
	}

	@Override
	public void clean() {
		setEntity(new User());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(userService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		Person person;  //buraası trasaction management içindi
		try {
			person = userService.getPerson("20");
			person.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMessage(null);
		setEntityList(this.userService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			// String password = "123456";
			// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			// String hashedPassword = passwordEncoder.encode(password);
			// passwordEncoder.matches(password, hashedPassword);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			getEntity().setPassword(passwordEncoder.encode(getEntity().getPassword()));
			if (id != null) {
				this.userService.update(getEntity());
				setMessage("User is successfully updated");
				clean();
			} else {
				this.userService.add(getEntity());
				setMessage("User is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.userService.remove(getEntityList().get(row).getId());
			setMessage("User with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}
	
	public void removeRoleUser(int row) {
		getEntity().getRoleUserList().remove(row);
	}
	
	public String edit(int row) {
		setEntity(this.userService.getEntityById(getEntityList().get(row)
				.getId()));
		return "user?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new User());
		return "user?faces-redirect=true";
	}

	public IUserService getPersonService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String roleUserEkle(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToMany_2);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("roleList");
		childDataBean.setName("com.entity.Role");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "roleList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}

}