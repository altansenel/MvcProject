package com.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IMenuService;
import com.dao.IUserService;
import com.entity.Menu;
import com.entity.RolePermission;
import com.entity.RoleUser;
import com.entity.User;

@SessionScoped
@ManagedBean(name = "homeController")
public class HomeController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HomeController.class);
	private static final String SPLITTER = "_";

	private String menuHtml;

	@ManagedProperty(value = "#{userService}")
	private IUserService userService;

	@ManagedProperty(value = "#{menuService}")
	private IMenuService menuService;

	public Principal getRemoteUser() {
		// return FacesContext.getCurrentInstance().getExternalContext()
		// .getRemoteUser();
		return FacesContext.getCurrentInstance().getExternalContext()
				.getUserPrincipal();
	}

	public Boolean loggedIn() {
		if (getRemoteUser() == null) {
			return false;
		} else {
			return true;
		}
	}

	public String getMenuHtml() {
		if (getRemoteUser()==null) {
			return null;
		}
		if (menuHtml == null) {
			StringBuilder sb = new StringBuilder();

			Set<Menu> menuSet = new HashSet<Menu>();
			Set<Menu> parentMenuSet = new HashSet<Menu>();
			User user = userService
					.getUserByUsername(getRemoteUser().getName());
			for (RoleUser roleUser : user.getRoleUserList()) {
				if (roleUser.getRole().getName().equals("Admin")) {
					List<Menu> parentMenuList = menuService.listParentMenu();
					Collections.sort(parentMenuList);
					for (Menu menu : parentMenuList) {
						parentMenuSet.add(menu);
					}
					sb.append(getHtml(null, parentMenuSet));
					setMenuHtml(sb.toString());
					return menuHtml;
				} else {
					for (RolePermission rolePermission : roleUser.getRole()
							.getRolePermissionList()) {
						for (Menu menu : rolePermission.getPermission()
								.getMenuList()) {
							menuSet.add(menu);
						}
					}
				}
			}

			sb.append(getHtml(menuSet, null));
			setMenuHtml(sb.toString());
		}

		return menuHtml;
	}

	public String getHtml(Set<Menu> menuSet, Set<Menu> parentMenuSet) {

		StringBuilder sb = new StringBuilder();
		if (parentMenuSet != null) {
			for (Menu menu : sortMenu(parentMenuSet)) {
				sb.append("<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" "
						+ "data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" "
						+ "aria-expanded=\"false\">"
						+ menu.getName()
						+ "<span class=\"caret\"></span></a>"
						+ "<ul class=\"dropdown-menu\">");
				for (Menu innerMenu : menu.getMenuList()) {
					sb.append("<li><a href=\"" + innerMenu.getLink() + "\">"
							+ innerMenu.getName() + "</a></li>");
				}
				sb.append("	</ul></li>");
			}
			return sb.toString();
		} else {
			parentMenuSet = new HashSet<Menu>();
			for (Menu menu : sortMenu(menuSet)) {
				if (menu.getMenu() != null) {
					parentMenuSet.add(menu.getMenu());
				}
			}

			for (Menu menu : sortMenu(parentMenuSet)) {
				sb.append("<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" "
						+ "data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" "
						+ "aria-expanded=\"false\">"
						+ menu.getName()
						+ "<span class=\"caret\"></span></a>"
						+ "<ul class=\"dropdown-menu\">");
				for (Menu innerMenu : menu.getMenuList()) {
					sb.append("<li><a href=\"" + innerMenu.getLink() + "\">"
							+ innerMenu.getName() + "</a></li>");
				}
				sb.append("	</ul></li>");
			}
			return sb.toString();
		}
	}

	public List<Menu> sortMenu(Set<Menu> menuSet){
		List<Menu> menuList = new ArrayList<Menu>();
		for (Menu menu : menuSet) {
			menuList.add(menu);
		}
		Collections.sort(menuList);
		return menuList;	
	}
	
	public void setMenuHtml(String menuHtml) {
		this.menuHtml = menuHtml;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

}