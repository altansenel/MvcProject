
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminWorkspaceService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminWorkspaceConverter")
@RequestScoped
public class AdminWorkspaceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminWorkspaceConverter.class);

	@ManagedProperty(value = "#{adminWorkspaceService}")
	private IAdminWorkspaceService adminWorkspaceService;

	public void setAdminWorkspaceService(IAdminWorkspaceService adminWorkspaceService) {
		this.adminWorkspaceService = adminWorkspaceService;
		setEntityService(adminWorkspaceService);
	}

	public IAdminWorkspaceService getAdminWorkspaceService() {
		return adminWorkspaceService;
	}
}
