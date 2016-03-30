

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockTransSourceService;
import com.entity.StockTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockTransSourceController")
public class StockTransSourceController extends BaseController<StockTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockTransSourceController.class);
	@ManagedProperty(value = "#{stockTransSourceService}")
	private IStockTransSourceService stockTransSourceService;

	@Override
	public void createEntity() {
		StockTransSource stockTransSource = new StockTransSource();
		setEntity(stockTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new StockTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockTransSourceService.update(getEntity());
				setMessage("StockTransSource is successfully updated");
				clean();
			} else {
				this.stockTransSourceService.add(getEntity());
				setMessage("StockTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("StockTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockTransSource());
		return "StockTransSource?faces-redirect=true";
	}

	public IStockTransSourceService getStockTransSourceService() {
		return stockTransSourceService;
	}

	public void setStockTransSourceService(IStockTransSourceService stockTransSourceService) {
		this.stockTransSourceService = stockTransSourceService;
	}




}