
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminDocumentConverter")
@RequestScoped
public class AdminDocumentConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminDocumentConverter.class);

//	@ManagedProperty(value = "#{adminDocumentService}")
//	private IAdminDocumentService adminDocumentService;

//	public void setAdminDocumentService(IAdminDocumentService adminDocumentService) {
//		this.adminDocumentService = adminDocumentService;
//	}

//	public IAdminDocumentService getAdminDocumentService() {
//		return adminDocumentService;
//	}
}
