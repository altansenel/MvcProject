

    
        
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockCostingInventoryService;
import com.entity.StockCostingInventory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockCostingInventoryController")
public class StockCostingInventoryController extends BaseController<StockCostingInventory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockCostingInventoryController.class);
	@ManagedProperty(value = "#{stockCostingInventoryService}")
	private IStockCostingInventoryService stockCostingInventoryService;

	@Override
	public void createEntity() {
		StockCostingInventory stockCostingInventory = new StockCostingInventory();
		setEntity(stockCostingInventory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockCostingInventory>());
	}

	@Override
	public void clean() {
		setEntity(new StockCostingInventory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockCostingInventoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockCostingInventoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockCostingInventoryService.update(getEntity());
				setMessage("StockCostingInventory is successfully updated");
				clean();
			} else {
				this.stockCostingInventoryService.add(getEntity());
				setMessage("StockCostingInventory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockCostingInventoryService.remove(getEntityList().get(row).getId());
			setMessage("StockCostingInventory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockCostingInventoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockCostingInventory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockCostingInventory());
		return "StockCostingInventory?faces-redirect=true";
	}

	public IStockCostingInventoryService getStockCostingInventoryService() {
		return stockCostingInventoryService;
	}

	public void setStockCostingInventoryService(IStockCostingInventoryService stockCostingInventoryService) {
		this.stockCostingInventoryService = stockCostingInventoryService;
	}




	public String addStock(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("stockList");
		childDataBean.setName("org.demo.bean.yeni.Stock");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockCosting(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("stockCostingList");
		childDataBean.setName("org.demo.bean.yeni.StockCosting");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockCostingList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockDepot(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("stockDepotList");
		childDataBean.setName("org.demo.bean.yeni.StockDepot");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockDepotList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}