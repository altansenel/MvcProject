
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IContactTransSourceService;

import org.apache.log4j.Logger;



@ManagedBean(name = "contactTransSourceConverter")
@RequestScoped
public class ContactTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactTransSourceConverter.class);

	@ManagedProperty(value = "#{contactTransSourceService}")
	private IContactTransSourceService contactTransSourceService;

	public void setContactTransSourceService(IContactTransSourceService contactTransSourceService) {
		this.contactTransSourceService = contactTransSourceService;
		setEntityService(contactTransSourceService);
	}

	public IContactTransSourceService getContactTransSourceService() {
		return contactTransSourceService;
	}
}
