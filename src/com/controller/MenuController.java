package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IMenuService;
import com.entity.Menu;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "menuController")
public class MenuController extends BaseController<Menu> implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MenuController.class);
	@ManagedProperty(value = "#{menuService}")
	private IMenuService menuService;

	@Override
	public void createEntity() {
		Menu permission = new Menu();
		setEntity(permission);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Menu>());
	}

	@Override
	public void clean() {
		setEntity(new Menu());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(menuService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.menuService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.menuService.update(getEntity());
				setMessage("menu is successfully updated");
				clean();
			} else {
				this.menuService.add(getEntity());
				setMessage("menu is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.menuService.remove(getEntityList().get(row).getId());
			setMessage("permission with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.menuService.getEntityById(getEntityList().get(row)
				.getId()));
		return "menu?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Menu());
		return "menu?faces-redirect=true";
	}
	
	public IMenuService getmenuService() {
		return menuService;
	}

	public void setmenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public String permissionEkle(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName("menu");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "permissionList?faces-redirect=true&from=" + pageName
				+ "&relationType=" + RelationType.manyToOne.ordinal();
	}
	
	
	public String addMenuManyToOne(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName("menu");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "menuList?faces-redirect=true&from=" + pageName
				+ "&relationType=" + RelationType.manyToOne.ordinal();
	}
	
	//burada iki tane var biri manytoone biri onetomany
	public String menuEkleOneToMenu(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName("menu");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "menuList?faces-redirect=true&from=" + pageName
				+ "&relationType=" + RelationType.oneToMany.ordinal();
	}

}