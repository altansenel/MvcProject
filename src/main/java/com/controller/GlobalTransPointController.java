

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
                                                                                
        
                                                                                            
        
                                                                                                        
        
                                                                                                                    
        
                                                                                                                                
        
                                                                                                                                            
        
                                                                                                                                                        
        
                                                                                                                                                                    
        
                                                                                                                                                                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalTransPointService;
import com.entity.GlobalTransPoint;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalTransPointController")
public class GlobalTransPointController extends BaseController<GlobalTransPoint>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalTransPointController.class);
	@ManagedProperty(value = "#{globalTransPointService}")
	private IGlobalTransPointService globalTransPointService;

	@Override
	public void createEntity() {
		GlobalTransPoint globalTransPoint = new GlobalTransPoint();
		setEntity(globalTransPoint);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalTransPoint>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalTransPoint());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalTransPointService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalTransPointService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalTransPointService.update(getEntity());
				setMessage("GlobalTransPoint is successfully updated");
				clean();
			} else {
				this.globalTransPointService.add(getEntity());
				setMessage("GlobalTransPoint is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalTransPointService.remove(getEntityList().get(row).getId());
			setMessage("GlobalTransPoint with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalTransPointService.getEntityById(getEntityList()
				.get(row).getId()));
		return "GlobalTransPoint?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalTransPoint());
		return "GlobalTransPoint?faces-redirect=true";
	}

	public IGlobalTransPointService getGlobalTransPointService() {
		return globalTransPointService;
	}

	public void setGlobalTransPointService(IGlobalTransPointService globalTransPointService) {
		this.globalTransPointService = globalTransPointService;
	}




}