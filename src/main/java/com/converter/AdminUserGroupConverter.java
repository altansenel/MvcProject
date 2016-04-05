
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminUserGroupService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminUserGroupConverter")
@RequestScoped
public class AdminUserGroupConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminUserGroupConverter.class);

	@ManagedProperty(value = "#{adminUserGroupService}")
	private IAdminUserGroupService adminUserGroupService;

	public void setAdminUserGroupService(IAdminUserGroupService adminUserGroupService) {
		this.adminUserGroupService = adminUserGroupService;
		setEntityService(adminUserGroupService);
	}

	public IAdminUserGroupService getAdminUserGroupService() {
		return adminUserGroupService;
	}
}
