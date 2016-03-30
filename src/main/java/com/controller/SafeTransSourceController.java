

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISafeTransSourceService;
import com.entity.SafeTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "safeTransSourceController")
public class SafeTransSourceController extends BaseController<SafeTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SafeTransSourceController.class);
	@ManagedProperty(value = "#{safeTransSourceService}")
	private ISafeTransSourceService safeTransSourceService;

	@Override
	public void createEntity() {
		SafeTransSource safeTransSource = new SafeTransSource();
		setEntity(safeTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<SafeTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new SafeTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(safeTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.safeTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.safeTransSourceService.update(getEntity());
				setMessage("SafeTransSource is successfully updated");
				clean();
			} else {
				this.safeTransSourceService.add(getEntity());
				setMessage("SafeTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.safeTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("SafeTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.safeTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "safeTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new SafeTransSource());
		return "SafeTransSource?faces-redirect=true";
	}

	public ISafeTransSourceService getSafeTransSourceService() {
		return safeTransSourceService;
	}

	public void setSafeTransSourceService(ISafeTransSourceService safeTransSourceService) {
		this.safeTransSourceService = safeTransSourceService;
	}




}