

    
        
                    
        
                            
    
                                
        
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockPriceListService;
import com.entity.StockPriceList;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockPriceListController")
public class StockPriceListController extends BaseController<StockPriceList>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockPriceListController.class);
	@ManagedProperty(value = "#{stockPriceListService}")
	private IStockPriceListService stockPriceListService;

	@Override
	public void createEntity() {
		StockPriceList stockPriceList = new StockPriceList();
		setEntity(stockPriceList);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockPriceList>());
	}

	@Override
	public void clean() {
		setEntity(new StockPriceList());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockPriceListService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockPriceListService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockPriceListService.update(getEntity());
				setMessage("StockPriceList is successfully updated");
				clean();
			} else {
				this.stockPriceListService.add(getEntity());
				setMessage("StockPriceList is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockPriceListService.remove(getEntityList().get(row).getId());
			setMessage("StockPriceList with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockPriceListService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockPriceList?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockPriceList());
		return "StockPriceList?faces-redirect=true";
	}

	public IStockPriceListService getStockPriceListService() {
		return stockPriceListService;
	}

	public void setStockPriceListService(IStockPriceListService stockPriceListService) {
		this.stockPriceListService = stockPriceListService;
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