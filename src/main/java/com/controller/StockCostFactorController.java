

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockCostFactorService;
import com.entity.StockCostFactor;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockCostFactorController")
public class StockCostFactorController extends BaseController<StockCostFactor>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockCostFactorController.class);
	@ManagedProperty(value = "#{stockCostFactorService}")
	private IStockCostFactorService stockCostFactorService;

	@Override
	public void createEntity() {
		StockCostFactor stockCostFactor = new StockCostFactor();
		setEntity(stockCostFactor);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockCostFactor>());
	}

	@Override
	public void clean() {
		setEntity(new StockCostFactor());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockCostFactorService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockCostFactorService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockCostFactorService.update(getEntity());
				setMessage("StockCostFactor is successfully updated");
				clean();
			} else {
				this.stockCostFactorService.add(getEntity());
				setMessage("StockCostFactor is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockCostFactorService.remove(getEntityList().get(row).getId());
			setMessage("StockCostFactor with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockCostFactorService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockCostFactor?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockCostFactor());
		return "StockCostFactor?faces-redirect=true";
	}

	public IStockCostFactorService getStockCostFactorService() {
		return stockCostFactorService;
	}

	public void setStockCostFactorService(IStockCostFactorService stockCostFactorService) {
		this.stockCostFactorService = stockCostFactorService;
	}




}