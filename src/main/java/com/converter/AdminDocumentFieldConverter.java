
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IAdminDocumentFieldService;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminDocumentFieldConverter")
@RequestScoped
public class AdminDocumentFieldConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminDocumentFieldConverter.class);

	@ManagedProperty(value = "#{adminDocumentFieldService}")
	private IAdminDocumentFieldService adminDocumentFieldService;

	public void setAdminDocumentFieldService(IAdminDocumentFieldService adminDocumentFieldService) {
		this.adminDocumentFieldService = adminDocumentFieldService;
		setEntityService(adminDocumentFieldService);
	}

	public IAdminDocumentFieldService getAdminDocumentFieldService() {
		return adminDocumentFieldService;
	}
}
