
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "contactExtraFieldsConverter")
@RequestScoped
public class ContactExtraFieldsConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactExtraFieldsConverter.class);

//	@ManagedProperty(value = "#{contactExtraFieldsService}")
//	private IContactExtraFieldsService contactExtraFieldsService;

//	public void setContactExtraFieldsService(IContactExtraFieldsService contactExtraFieldsService) {
//		this.contactExtraFieldsService = contactExtraFieldsService;
//	}

//	public IContactExtraFieldsService getContactExtraFieldsService() {
//		return contactExtraFieldsService;
//	}
}
