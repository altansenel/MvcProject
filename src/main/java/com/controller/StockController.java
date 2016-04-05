

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                    
    
                                                    
    
                                                                    
        
                                                    
    
                                                                                
        
                                                    
    
                                                    
    
                                                    
    
                                                    
    
                                                                                            
        
                                                    
    
                                                                                                        
        
                                                    
    
                                                                                                                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockService;
import com.entity.Stock;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockController")
public class StockController extends BaseController<Stock>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockController.class);
	@ManagedProperty(value = "#{stockService}")
	private IStockService stockService;

	@Override
	public void createEntity() {
		Stock stock = new Stock();
		setEntity(stock);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Stock>());
	}

	@Override
	public void clean() {
		setEntity(new Stock());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockService.update(getEntity());
				setMessage("Stock is successfully updated");
				clean();
			} else {
				this.stockService.add(getEntity());
				setMessage("Stock is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockService.remove(getEntityList().get(row).getId());
			setMessage("Stock with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockService.getEntityById(getEntityList()
				.get(row).getId()));
		return "Stock?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Stock());
		return "Stock?faces-redirect=true";
	}

	public IStockService getStockService() {
		return stockService;
	}

	public void setStockService(IStockService stockService) {
		this.stockService = stockService;
	}




	public String addStockCategory(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName.split(",")[0]);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("StockCategoryList");
		childDataBean.setName("org.demo.bean.yeni.StockCategory");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockCategoryList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockExtraFields(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName.split(",")[0]);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("StockExtraFieldsList");
		childDataBean.setName("org.demo.bean.yeni.StockExtraFields");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockExtraFieldsList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}