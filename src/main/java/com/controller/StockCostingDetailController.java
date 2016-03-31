

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockCostingDetailService;
import com.entity.StockCostingDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockCostingDetailController")
public class StockCostingDetailController extends BaseController<StockCostingDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockCostingDetailController.class);
	@ManagedProperty(value = "#{stockCostingDetailService}")
	private IStockCostingDetailService stockCostingDetailService;

	@Override
	public void createEntity() {
		StockCostingDetail stockCostingDetail = new StockCostingDetail();
		setEntity(stockCostingDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockCostingDetail>());
	}

	@Override
	public void clean() {
		setEntity(new StockCostingDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockCostingDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockCostingDetailService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockCostingDetailService.update(getEntity());
				setMessage("StockCostingDetail is successfully updated");
				clean();
			} else {
				this.stockCostingDetailService.add(getEntity());
				setMessage("StockCostingDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockCostingDetailService.remove(getEntityList().get(row).getId());
			setMessage("StockCostingDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockCostingDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockCostingDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockCostingDetail());
		return "StockCostingDetail?faces-redirect=true";
	}

	public IStockCostingDetailService getStockCostingDetailService() {
		return stockCostingDetailService;
	}

	public void setStockCostingDetailService(IStockCostingDetailService stockCostingDetailService) {
		this.stockCostingDetailService = stockCostingDetailService;
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



}