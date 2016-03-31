

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
                                                                                
        
                                                                                            
        
                                                                                                        
        
                                                                                                                    
        
                                                                                                                                
        
                                                                                                                                            
        
                                                                                                                                                        
        
                                                                                                                                                                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalPrivateCodeService;
import com.entity.GlobalPrivateCode;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalPrivateCodeController")
public class GlobalPrivateCodeController extends BaseController<GlobalPrivateCode>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalPrivateCodeController.class);
	@ManagedProperty(value = "#{globalPrivateCodeService}")
	private IGlobalPrivateCodeService globalPrivateCodeService;

	@Override
	public void createEntity() {
		GlobalPrivateCode globalPrivateCode = new GlobalPrivateCode();
		setEntity(globalPrivateCode);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalPrivateCode>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalPrivateCode());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalPrivateCodeService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalPrivateCodeService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalPrivateCodeService.update(getEntity());
				setMessage("GlobalPrivateCode is successfully updated");
				clean();
			} else {
				this.globalPrivateCodeService.add(getEntity());
				setMessage("GlobalPrivateCode is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalPrivateCodeService.remove(getEntityList().get(row).getId());
			setMessage("GlobalPrivateCode with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalPrivateCodeService.getEntityById(getEntityList()
				.get(row).getId()));
		return "GlobalPrivateCode?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalPrivateCode());
		return "GlobalPrivateCode?faces-redirect=true";
	}

	public IGlobalPrivateCodeService getGlobalPrivateCodeService() {
		return globalPrivateCodeService;
	}

	public void setGlobalPrivateCodeService(IGlobalPrivateCodeService globalPrivateCodeService) {
		this.globalPrivateCodeService = globalPrivateCodeService;
	}




}