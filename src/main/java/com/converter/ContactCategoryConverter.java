
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IContactCategoryService;

import org.apache.log4j.Logger;



@ManagedBean(name = "contactCategoryConverter")
@RequestScoped
public class ContactCategoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactCategoryConverter.class);

	@ManagedProperty(value = "#{contactCategoryService}")
	private IContactCategoryService contactCategoryService;

	public void setContactCategoryService(IContactCategoryService contactCategoryService) {
		this.contactCategoryService = contactCategoryService;
		setEntityService(contactCategoryService);
	}

	public IContactCategoryService getContactCategoryService() {
		return contactCategoryService;
	}
}
