
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminUserRightService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminUserRightConverter")
@RequestScoped
public class AdminUserRightConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminUserRightConverter.class);

	@ManagedProperty(value = "#{adminUserRightService}")
	private IAdminUserRightService adminUserRightService;

	public void setAdminUserRightService(IAdminUserRightService adminUserRightService) {
		this.adminUserRightService = adminUserRightService;
		setEntityService(adminUserRightService);
	}

	public IAdminUserRightService getAdminUserRightService() {
		return adminUserRightService;
	}
}
