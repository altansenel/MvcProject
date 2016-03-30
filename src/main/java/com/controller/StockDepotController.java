

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                    
    
                                                                    
        
                                                                                
        
                                                                                            
        
                                                                                                        
        
                                                                                                                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockDepotService;
import com.entity.StockDepot;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockDepotController")
public class StockDepotController extends BaseController<StockDepot>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockDepotController.class);
	@ManagedProperty(value = "#{stockDepotService}")
	private IStockDepotService stockDepotService;

	@Override
	public void createEntity() {
		StockDepot stockDepot = new StockDepot();
		setEntity(stockDepot);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockDepot>());
	}

	@Override
	public void clean() {
		setEntity(new StockDepot());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockDepotService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockDepotService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockDepotService.update(getEntity());
				setMessage("StockDepot is successfully updated");
				clean();
			} else {
				this.stockDepotService.add(getEntity());
				setMessage("StockDepot is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockDepotService.remove(getEntityList().get(row).getId());
			setMessage("StockDepot with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockDepotService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockDepot?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockDepot());
		return "StockDepot?faces-redirect=true";
	}

	public IStockDepotService getStockDepotService() {
		return stockDepotService;
	}

	public void setStockDepotService(IStockDepotService stockDepotService) {
		this.stockDepotService = stockDepotService;
	}




}