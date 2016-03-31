

    
        
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IContactExtraFieldsService;
import com.entity.ContactExtraFields;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "contactExtraFieldsController")
public class ContactExtraFieldsController extends BaseController<ContactExtraFields>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ContactExtraFieldsController.class);
	@ManagedProperty(value = "#{contactExtraFieldsService}")
	private IContactExtraFieldsService contactExtraFieldsService;

	@Override
	public void createEntity() {
		ContactExtraFields contactExtraFields = new ContactExtraFields();
		setEntity(contactExtraFields);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ContactExtraFields>());
	}

	@Override
	public void clean() {
		setEntity(new ContactExtraFields());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(contactExtraFieldsService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.contactExtraFieldsService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.contactExtraFieldsService.update(getEntity());
				setMessage("ContactExtraFields is successfully updated");
				clean();
			} else {
				this.contactExtraFieldsService.add(getEntity());
				setMessage("ContactExtraFields is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.contactExtraFieldsService.remove(getEntityList().get(row).getId());
			setMessage("ContactExtraFields with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.contactExtraFieldsService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ContactExtraFields?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ContactExtraFields());
		return "ContactExtraFields?faces-redirect=true";
	}

	public IContactExtraFieldsService getContactExtraFieldsService() {
		return contactExtraFieldsService;
	}

	public void setContactExtraFieldsService(IContactExtraFieldsService contactExtraFieldsService) {
		this.contactExtraFieldsService = contactExtraFieldsService;
	}




}