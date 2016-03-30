

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IChqbllTypeService;
import com.entity.ChqbllType;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "chqbllTypeController")
public class ChqbllTypeController extends BaseController<ChqbllType>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ChqbllTypeController.class);
	@ManagedProperty(value = "#{chqbllTypeService}")
	private IChqbllTypeService chqbllTypeService;

	@Override
	public void createEntity() {
		ChqbllType chqbllType = new ChqbllType();
		setEntity(chqbllType);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ChqbllType>());
	}

	@Override
	public void clean() {
		setEntity(new ChqbllType());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(chqbllTypeService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.chqbllTypeService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.chqbllTypeService.update(getEntity());
				setMessage("ChqbllType is successfully updated");
				clean();
			} else {
				this.chqbllTypeService.add(getEntity());
				setMessage("ChqbllType is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.chqbllTypeService.remove(getEntityList().get(row).getId());
			setMessage("ChqbllType with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.chqbllTypeService.getEntityById(getEntityList()
				.get(row).getId()));
		return "chqbllType?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ChqbllType());
		return "ChqbllType?faces-redirect=true";
	}

	public IChqbllTypeService getChqbllTypeService() {
		return chqbllTypeService;
	}

	public void setChqbllTypeService(IChqbllTypeService chqbllTypeService) {
		this.chqbllTypeService = chqbllTypeService;
	}




}