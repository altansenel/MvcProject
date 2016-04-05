
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminSettingService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminSettingConverter")
@RequestScoped
public class AdminSettingConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminSettingConverter.class);

	@ManagedProperty(value = "#{adminSettingService}")
	private IAdminSettingService adminSettingService;

	public void setAdminSettingService(IAdminSettingService adminSettingService) {
		this.adminSettingService = adminSettingService;
		setEntityService(adminSettingService);
	}

	public IAdminSettingService getAdminSettingService() {
		return adminSettingService;
	}
}
