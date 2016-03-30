



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalCurrencyService;
import com.entity.GlobalCurrency;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalCurrencyController")
public class GlobalCurrencyController extends BaseController<GlobalCurrency>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalCurrencyController.class);
	@ManagedProperty(value = "#{globalCurrencyService}")
	private IGlobalCurrencyService globalCurrencyService;

	@Override
	public void createEntity() {
		GlobalCurrency globalCurrency = new GlobalCurrency();
		setEntity(globalCurrency);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalCurrency>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalCurrency());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalCurrencyService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalCurrencyService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalCurrencyService.update(getEntity());
				setMessage("GlobalCurrency is successfully updated");
				clean();
			} else {
				this.globalCurrencyService.add(getEntity());
				setMessage("GlobalCurrency is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalCurrencyService.remove(getEntityList().get(row).getId());
			setMessage("GlobalCurrency with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalCurrencyService.getEntityById(getEntityList()
				.get(row).getId()));
		return "globalCurrency?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalCurrency());
		return "GlobalCurrency?faces-redirect=true";
	}

	public IGlobalCurrencyService getGlobalCurrencyService() {
		return globalCurrencyService;
	}

	public void setGlobalCurrencyService(IGlobalCurrencyService globalCurrencyService) {
		this.globalCurrencyService = globalCurrencyService;
	}




}