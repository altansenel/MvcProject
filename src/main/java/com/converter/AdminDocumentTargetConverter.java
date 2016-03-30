
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "adminDocumentTargetConverter")
@RequestScoped
public class AdminDocumentTargetConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminDocumentTargetConverter.class);

//	@ManagedProperty(value = "#{adminDocumentTargetService}")
//	private IAdminDocumentTargetService adminDocumentTargetService;

//	public void setAdminDocumentTargetService(IAdminDocumentTargetService adminDocumentTargetService) {
//		this.adminDocumentTargetService = adminDocumentTargetService;
//	}

//	public IAdminDocumentTargetService getAdminDocumentTargetService() {
//		return adminDocumentTargetService;
//	}
}
