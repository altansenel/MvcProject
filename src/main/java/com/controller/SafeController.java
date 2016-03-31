

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISafeService;
import com.entity.Safe;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "safeController")
public class SafeController extends BaseController<Safe>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SafeController.class);
	@ManagedProperty(value = "#{safeService}")
	private ISafeService safeService;

	@Override
	public void createEntity() {
		Safe safe = new Safe();
		setEntity(safe);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Safe>());
	}

	@Override
	public void clean() {
		setEntity(new Safe());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(safeService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.safeService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.safeService.update(getEntity());
				setMessage("Safe is successfully updated");
				clean();
			} else {
				this.safeService.add(getEntity());
				setMessage("Safe is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.safeService.remove(getEntityList().get(row).getId());
			setMessage("Safe with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.safeService.getEntityById(getEntityList()
				.get(row).getId()));
		return "Safe?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Safe());
		return "Safe?faces-redirect=true";
	}

	public ISafeService getSafeService() {
		return safeService;
	}

	public void setSafeService(ISafeService safeService) {
		this.safeService = safeService;
	}




}