

    
        
                    
        
                                
        
                                            
        
                                                        
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockCategoryService;
import com.entity.StockCategory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockCategoryController")
public class StockCategoryController extends BaseController<StockCategory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockCategoryController.class);
	@ManagedProperty(value = "#{stockCategoryService}")
	private IStockCategoryService stockCategoryService;

	@Override
	public void createEntity() {
		StockCategory stockCategory = new StockCategory();
		setEntity(stockCategory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockCategory>());
	}

	@Override
	public void clean() {
		setEntity(new StockCategory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockCategoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockCategoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockCategoryService.update(getEntity());
				setMessage("StockCategory is successfully updated");
				clean();
			} else {
				this.stockCategoryService.add(getEntity());
				setMessage("StockCategory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockCategoryService.remove(getEntityList().get(row).getId());
			setMessage("StockCategory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockCategoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "stockCategory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockCategory());
		return "StockCategory?faces-redirect=true";
	}

	public IStockCategoryService getStockCategoryService() {
		return stockCategoryService;
	}

	public void setStockCategoryService(IStockCategoryService stockCategoryService) {
		this.stockCategoryService = stockCategoryService;
	}




}