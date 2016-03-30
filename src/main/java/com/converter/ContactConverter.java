
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "contactConverter")
@RequestScoped
public class ContactConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactConverter.class);

//	@ManagedProperty(value = "#{contactService}")
//	private IContactService contactService;

//	public void setContactService(IContactService contactService) {
//		this.contactService = contactService;
//	}

//	public IContactService getContactService() {
//		return contactService;
//	}
}
