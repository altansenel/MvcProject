
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminUserGivenRoleConverter")
@RequestScoped
public class AdminUserGivenRoleConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminUserGivenRoleConverter.class);

//	@ManagedProperty(value = "#{adminUserGivenRoleService}")
//	private IAdminUserGivenRoleService adminUserGivenRoleService;

//	public void setAdminUserGivenRoleService(IAdminUserGivenRoleService adminUserGivenRoleService) {
//		this.adminUserGivenRoleService = adminUserGivenRoleService;
//	}

//	public IAdminUserGivenRoleService getAdminUserGivenRoleService() {
//		return adminUserGivenRoleService;
//	}
}
