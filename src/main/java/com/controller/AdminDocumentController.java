

    
        
                            
    
                            
    
                            
    
                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminDocumentService;
import com.entity.AdminDocument;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminDocumentController")
public class AdminDocumentController extends BaseController<AdminDocument>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminDocumentController.class);
	@ManagedProperty(value = "#{adminDocumentService}")
	private IAdminDocumentService adminDocumentService;

	@Override
	public void createEntity() {
		AdminDocument adminDocument = new AdminDocument();
		setEntity(adminDocument);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminDocument>());
	}

	@Override
	public void clean() {
		setEntity(new AdminDocument());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminDocumentService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminDocumentService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminDocumentService.update(getEntity());
				setMessage("AdminDocument is successfully updated");
				clean();
			} else {
				this.adminDocumentService.add(getEntity());
				setMessage("AdminDocument is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminDocumentService.remove(getEntityList().get(row).getId());
			setMessage("AdminDocument with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminDocumentService.getEntityById(getEntityList()
				.get(row).getId()));
		return "adminDocument?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminDocument());
		return "AdminDocument?faces-redirect=true";
	}

	public IAdminDocumentService getAdminDocumentService() {
		return adminDocumentService;
	}

	public void setAdminDocumentService(IAdminDocumentService adminDocumentService) {
		this.adminDocumentService = adminDocumentService;
	}




}