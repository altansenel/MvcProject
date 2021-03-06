
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminExtraFieldsService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminExtraFieldsConverter")
@RequestScoped
public class AdminExtraFieldsConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminExtraFieldsConverter.class);

	@ManagedProperty(value = "#{adminExtraFieldsService}")
	private IAdminExtraFieldsService adminExtraFieldsService;

	public void setAdminExtraFieldsService(IAdminExtraFieldsService adminExtraFieldsService) {
		this.adminExtraFieldsService = adminExtraFieldsService;
		setEntityService(adminExtraFieldsService);
	}

	public IAdminExtraFieldsService getAdminExtraFieldsService() {
		return adminExtraFieldsService;
	}
}
