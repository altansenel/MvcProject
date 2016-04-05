

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockTransFactorService;
import com.entity.StockTransFactor;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockTransFactorController")
public class StockTransFactorController extends BaseController<StockTransFactor>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockTransFactorController.class);
	@ManagedProperty(value = "#{stockTransFactorService}")
	private IStockTransFactorService stockTransFactorService;

	@Override
	public void createEntity() {
		StockTransFactor stockTransFactor = new StockTransFactor();
		setEntity(stockTransFactor);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockTransFactor>());
	}

	@Override
	public void clean() {
		setEntity(new StockTransFactor());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockTransFactorService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockTransFactorService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockTransFactorService.update(getEntity());
				setMessage("StockTransFactor is successfully updated");
				clean();
			} else {
				this.stockTransFactorService.add(getEntity());
				setMessage("StockTransFactor is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockTransFactorService.remove(getEntityList().get(row).getId());
			setMessage("StockTransFactor with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockTransFactorService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockTransFactor?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockTransFactor());
		return "StockTransFactor?faces-redirect=true";
	}

	public IStockTransFactorService getStockTransFactorService() {
		return stockTransFactorService;
	}

	public void setStockTransFactorService(IStockTransFactorService stockTransFactorService) {
		this.stockTransFactorService = stockTransFactorService;
	}




	public String addStockCostFactor(String pageName) {
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
		childDataBean.setFrom("StockCostFactorList");
		childDataBean.setName("org.demo.bean.yeni.StockCostFactor");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockCostFactorList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockTrans(String pageName) {
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
		childDataBean.setFrom("StockTransList");
		childDataBean.setName("org.demo.bean.yeni.StockTrans");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}