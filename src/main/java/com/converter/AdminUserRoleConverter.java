
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminUserRoleConverter")
@RequestScoped
public class AdminUserRoleConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminUserRoleConverter.class);

//	@ManagedProperty(value = "#{adminUserRoleService}")
//	private IAdminUserRoleService adminUserRoleService;

//	public void setAdminUserRoleService(IAdminUserRoleService adminUserRoleService) {
//		this.adminUserRoleService = adminUserRoleService;
//	}

//	public IAdminUserRoleService getAdminUserRoleService() {
//		return adminUserRoleService;
//	}
}
