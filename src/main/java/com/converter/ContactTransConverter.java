
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IContactTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "contactTransConverter")
@RequestScoped
public class ContactTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactTransConverter.class);

	@ManagedProperty(value = "#{contactTransService}")
	private IContactTransService contactTransService;

	public void setContactTransService(IContactTransService contactTransService) {
		this.contactTransService = contactTransService;
		setEntityService(contactTransService);
	}

	public IContactTransService getContactTransService() {
		return contactTransService;
	}
}
