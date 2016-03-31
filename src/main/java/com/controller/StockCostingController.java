

    
        
                            
    
                            
    
                    
        
                            
    
                                
        
                            
    
                            
    
                            
    
                                            
        
                                                        
        
                            
    
                            
    
                            
    
                                                                    
        
                                                                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockCostingService;
import com.entity.StockCosting;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockCostingController")
public class StockCostingController extends BaseController<StockCosting>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockCostingController.class);
	@ManagedProperty(value = "#{stockCostingService}")
	private IStockCostingService stockCostingService;

	@Override
	public void createEntity() {
		StockCosting stockCosting = new StockCosting();
		setEntity(stockCosting);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockCosting>());
	}

	@Override
	public void clean() {
		setEntity(new StockCosting());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockCostingService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockCostingService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockCostingService.update(getEntity());
				setMessage("StockCosting is successfully updated");
				clean();
			} else {
				this.stockCostingService.add(getEntity());
				setMessage("StockCosting is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockCostingService.remove(getEntityList().get(row).getId());
			setMessage("StockCosting with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockCostingService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockCosting?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockCosting());
		return "StockCosting?faces-redirect=true";
	}

	public IStockCostingService getStockCostingService() {
		return stockCostingService;
	}

	public void setStockCostingService(IStockCostingService stockCostingService) {
		this.stockCostingService = stockCostingService;
	}




	public String addStockExtraFields(String pageName) {
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
		childDataBean.setFrom("StockExtraFieldsList");
		childDataBean.setName("org.demo.bean.yeni.StockExtraFields");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockExtraFieldsList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockCategory(String pageName) {
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
		childDataBean.setFrom("StockCategoryList");
		childDataBean.setName("org.demo.bean.yeni.StockCategory");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockCategoryList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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
		childDataBean.setFrom("StockList");
		childDataBean.setName("org.demo.bean.yeni.Stock");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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
		childDataBean.setFrom("StockDepotList");
		childDataBean.setName("org.demo.bean.yeni.StockDepot");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockDepotList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addGlobalTransPoint(String pageName) {
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
		childDataBean.setFrom("GlobalTransPointList");
		childDataBean.setName("org.demo.bean.yeni.GlobalTransPoint");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "GlobalTransPointList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}