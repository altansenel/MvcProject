



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockUnitService;
import com.entity.StockUnit;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockUnitController")
public class StockUnitController extends BaseController<StockUnit>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockUnitController.class);
	@ManagedProperty(value = "#{stockUnitService}")
	private IStockUnitService stockUnitService;

	@Override
	public void createEntity() {
		StockUnit stockUnit = new StockUnit();
		setEntity(stockUnit);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockUnit>());
	}

	@Override
	public void clean() {
		setEntity(new StockUnit());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockUnitService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockUnitService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockUnitService.update(getEntity());
				setMessage("StockUnit is successfully updated");
				clean();
			} else {
				this.stockUnitService.add(getEntity());
				setMessage("StockUnit is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockUnitService.remove(getEntityList().get(row).getId());
			setMessage("StockUnit with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockUnitService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockUnit?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockUnit());
		return "StockUnit?faces-redirect=true";
	}

	public IStockUnitService getStockUnitService() {
		return stockUnitService;
	}

	public void setStockUnitService(IStockUnitService stockUnitService) {
		this.stockUnitService = stockUnitService;
	}




}