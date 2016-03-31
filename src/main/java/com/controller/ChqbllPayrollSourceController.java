

    
        
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IChqbllPayrollSourceService;
import com.entity.ChqbllPayrollSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "chqbllPayrollSourceController")
public class ChqbllPayrollSourceController extends BaseController<ChqbllPayrollSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ChqbllPayrollSourceController.class);
	@ManagedProperty(value = "#{chqbllPayrollSourceService}")
	private IChqbllPayrollSourceService chqbllPayrollSourceService;

	@Override
	public void createEntity() {
		ChqbllPayrollSource chqbllPayrollSource = new ChqbllPayrollSource();
		setEntity(chqbllPayrollSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ChqbllPayrollSource>());
	}

	@Override
	public void clean() {
		setEntity(new ChqbllPayrollSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(chqbllPayrollSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.chqbllPayrollSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.chqbllPayrollSourceService.update(getEntity());
				setMessage("ChqbllPayrollSource is successfully updated");
				clean();
			} else {
				this.chqbllPayrollSourceService.add(getEntity());
				setMessage("ChqbllPayrollSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.chqbllPayrollSourceService.remove(getEntityList().get(row).getId());
			setMessage("ChqbllPayrollSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.chqbllPayrollSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ChqbllPayrollSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ChqbllPayrollSource());
		return "ChqbllPayrollSource?faces-redirect=true";
	}

	public IChqbllPayrollSourceService getChqbllPayrollSourceService() {
		return chqbllPayrollSourceService;
	}

	public void setChqbllPayrollSourceService(IChqbllPayrollSourceService chqbllPayrollSourceService) {
		this.chqbllPayrollSourceService = chqbllPayrollSourceService;
	}




}