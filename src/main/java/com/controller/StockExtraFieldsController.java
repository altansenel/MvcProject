

    
        
                    
        
                            
    
                                
        
                                            
        
                                                    
    
                                                        
        
                                                                
    
                                        
    
                            
    
                                                    
    
                                                                            
    
                                                                
    
                                                                
    
                                        
    
                                        
    
                            
    
                                                    
    
                                                                            
    
                                                                
    
                                        
    
                            
    
                                                    
    
                                                                            
    
                                                                
    
                                        
    
                            
    
                                                    
    
                                                                
    
                                        
    
                            
    
                                                    
    
                                                                            
    
                                                                
    
                                                                            
    
                                        
    
                            
    
                                                    
    
                                                                            
    
                                        
    
                                                                
    
                                                                            
    
                            
    
                                                                            
    
                            
    
                                        
    
                                                    
    
                                                                
    
                                                    
    
                                                                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockExtraFieldsService;
import com.entity.StockExtraFields;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockExtraFieldsController")
public class StockExtraFieldsController extends BaseController<StockExtraFields>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockExtraFieldsController.class);
	@ManagedProperty(value = "#{stockExtraFieldsService}")
	private IStockExtraFieldsService stockExtraFieldsService;

	@Override
	public void createEntity() {
		StockExtraFields stockExtraFields = new StockExtraFields();
		setEntity(stockExtraFields);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockExtraFields>());
	}

	@Override
	public void clean() {
		setEntity(new StockExtraFields());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockExtraFieldsService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockExtraFieldsService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockExtraFieldsService.update(getEntity());
				setMessage("StockExtraFields is successfully updated");
				clean();
			} else {
				this.stockExtraFieldsService.add(getEntity());
				setMessage("StockExtraFields is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockExtraFieldsService.remove(getEntityList().get(row).getId());
			setMessage("StockExtraFields with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockExtraFieldsService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockExtraFields?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockExtraFields());
		return "StockExtraFields?faces-redirect=true";
	}

	public IStockExtraFieldsService getStockExtraFieldsService() {
		return stockExtraFieldsService;
	}

	public void setStockExtraFieldsService(IStockExtraFieldsService stockExtraFieldsService) {
		this.stockExtraFieldsService = stockExtraFieldsService;
	}




}