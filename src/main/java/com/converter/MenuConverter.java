package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import com.dao.IMenuService;
import com.entity.Menu;

@ManagedBean(name = "menuConverter")
@RequestScoped
public class MenuConverter extends BaseConverter<Menu> implements Converter,
		Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{menuService}")
	private IMenuService menuService;

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
		setEntityService(menuService);
	}

	public IMenuService getMenuService() {
		return menuService;
	}
}