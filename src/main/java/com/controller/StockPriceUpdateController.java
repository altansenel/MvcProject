

    
        
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockPriceUpdateService;
import com.entity.StockPriceUpdate;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockPriceUpdateController")
public class StockPriceUpdateController extends BaseController<StockPriceUpdate>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockPriceUpdateController.class);
	@ManagedProperty(value = "#{stockPriceUpdateService}")
	private IStockPriceUpdateService stockPriceUpdateService;

	@Override
	public void createEntity() {
		StockPriceUpdate stockPriceUpdate = new StockPriceUpdate();
		setEntity(stockPriceUpdate);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockPriceUpdate>());
	}

	@Override
	public void clean() {
		setEntity(new StockPriceUpdate());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockPriceUpdateService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockPriceUpdateService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockPriceUpdateService.update(getEntity());
				setMessage("StockPriceUpdate is successfully updated");
				clean();
			} else {
				this.stockPriceUpdateService.add(getEntity());
				setMessage("StockPriceUpdate is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockPriceUpdateService.remove(getEntityList().get(row).getId());
			setMessage("StockPriceUpdate with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockPriceUpdateService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockPriceUpdate?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockPriceUpdate());
		return "StockPriceUpdate?faces-redirect=true";
	}

	public IStockPriceUpdateService getStockPriceUpdateService() {
		return stockPriceUpdateService;
	}

	public void setStockPriceUpdateService(IStockPriceUpdateService stockPriceUpdateService) {
		this.stockPriceUpdateService = stockPriceUpdateService;
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
		childDataBean.setFrom("stockExtraFieldsList");
		childDataBean.setName("org.demo.bean.yeni.StockExtraFields");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockExtraFieldsList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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
		childDataBean.setFrom("stockCategoryList");
		childDataBean.setName("org.demo.bean.yeni.StockCategory");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockCategoryList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}