

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IContactTransSourceService;
import com.entity.ContactTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "contactTransSourceController")
public class ContactTransSourceController extends BaseController<ContactTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ContactTransSourceController.class);
	@ManagedProperty(value = "#{contactTransSourceService}")
	private IContactTransSourceService contactTransSourceService;

	@Override
	public void createEntity() {
		ContactTransSource contactTransSource = new ContactTransSource();
		setEntity(contactTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ContactTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new ContactTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(contactTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.contactTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.contactTransSourceService.update(getEntity());
				setMessage("ContactTransSource is successfully updated");
				clean();
			} else {
				this.contactTransSourceService.add(getEntity());
				setMessage("ContactTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.contactTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("ContactTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.contactTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ContactTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ContactTransSource());
		return "ContactTransSource?faces-redirect=true";
	}

	public IContactTransSourceService getContactTransSourceService() {
		return contactTransSourceService;
	}

	public void setContactTransSourceService(IContactTransSourceService contactTransSourceService) {
		this.contactTransSourceService = contactTransSourceService;
	}




}