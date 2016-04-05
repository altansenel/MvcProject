
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminUserService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminUserConverter")
@RequestScoped
public class AdminUserConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminUserConverter.class);

	@ManagedProperty(value = "#{adminUserService}")
	private IAdminUserService adminUserService;

	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
		setEntityService(adminUserService);
	}

	public IAdminUserService getAdminUserService() {
		return adminUserService;
	}
}
