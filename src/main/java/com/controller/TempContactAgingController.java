



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ITempContactAgingService;
import com.entity.TempContactAging;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "tempContactAgingController")
public class TempContactAgingController extends BaseController<TempContactAging>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(TempContactAgingController.class);
	@ManagedProperty(value = "#{tempContactAgingService}")
	private ITempContactAgingService tempContactAgingService;

	@Override
	public void createEntity() {
		TempContactAging tempContactAging = new TempContactAging();
		setEntity(tempContactAging);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<TempContactAging>());
	}

	@Override
	public void clean() {
		setEntity(new TempContactAging());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(tempContactAgingService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.tempContactAgingService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.tempContactAgingService.update(getEntity());
				setMessage("TempContactAging is successfully updated");
				clean();
			} else {
				this.tempContactAgingService.add(getEntity());
				setMessage("TempContactAging is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.tempContactAgingService.remove(getEntityList().get(row).getId());
			setMessage("TempContactAging with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.tempContactAgingService.getEntityById(getEntityList()
				.get(row).getId()));
		return "tempContactAging?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new TempContactAging());
		return "TempContactAging?faces-redirect=true";
	}

	public ITempContactAgingService getTempContactAgingService() {
		return tempContactAgingService;
	}

	public void setTempContactAgingService(ITempContactAgingService tempContactAgingService) {
		this.tempContactAgingService = tempContactAgingService;
	}




}