package com.dao;

import java.util.List;

import com.entity.Menu;

public interface IMenuService extends IBaseService<Menu> {
	public Menu getMenuByLink(String link);
	public List<Menu> listParentMenu();

}

