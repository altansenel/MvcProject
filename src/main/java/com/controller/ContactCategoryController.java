

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IContactCategoryService;
import com.entity.ContactCategory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "contactCategoryController")
public class ContactCategoryController extends BaseController<ContactCategory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ContactCategoryController.class);
	@ManagedProperty(value = "#{contactCategoryService}")
	private IContactCategoryService contactCategoryService;

	@Override
	public void createEntity() {
		ContactCategory contactCategory = new ContactCategory();
		setEntity(contactCategory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ContactCategory>());
	}

	@Override
	public void clean() {
		setEntity(new ContactCategory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(contactCategoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.contactCategoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.contactCategoryService.update(getEntity());
				setMessage("ContactCategory is successfully updated");
				clean();
			} else {
				this.contactCategoryService.add(getEntity());
				setMessage("ContactCategory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.contactCategoryService.remove(getEntityList().get(row).getId());
			setMessage("ContactCategory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.contactCategoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ContactCategory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ContactCategory());
		return "ContactCategory?faces-redirect=true";
	}

	public IContactCategoryService getContactCategoryService() {
		return contactCategoryService;
	}

	public void setContactCategoryService(IContactCategoryService contactCategoryService) {
		this.contactCategoryService = contactCategoryService;
	}




}