

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalCurrencyRateService;
import com.entity.GlobalCurrencyRate;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalCurrencyRateController")
public class GlobalCurrencyRateController extends BaseController<GlobalCurrencyRate>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalCurrencyRateController.class);
	@ManagedProperty(value = "#{globalCurrencyRateService}")
	private IGlobalCurrencyRateService globalCurrencyRateService;

	@Override
	public void createEntity() {
		GlobalCurrencyRate globalCurrencyRate = new GlobalCurrencyRate();
		setEntity(globalCurrencyRate);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalCurrencyRate>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalCurrencyRate());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalCurrencyRateService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalCurrencyRateService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalCurrencyRateService.update(getEntity());
				setMessage("GlobalCurrencyRate is successfully updated");
				clean();
			} else {
				this.globalCurrencyRateService.add(getEntity());
				setMessage("GlobalCurrencyRate is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalCurrencyRateService.remove(getEntityList().get(row).getId());
			setMessage("GlobalCurrencyRate with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalCurrencyRateService.getEntityById(getEntityList()
				.get(row).getId()));
		return "globalCurrencyRate?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalCurrencyRate());
		return "GlobalCurrencyRate?faces-redirect=true";
	}

	public IGlobalCurrencyRateService getGlobalCurrencyRateService() {
		return globalCurrencyRateService;
	}

	public void setGlobalCurrencyRateService(IGlobalCurrencyRateService globalCurrencyRateService) {
		this.globalCurrencyRateService = globalCurrencyRateService;
	}




}