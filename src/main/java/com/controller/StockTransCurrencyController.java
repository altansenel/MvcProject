

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockTransCurrencyService;
import com.entity.StockTransCurrency;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockTransCurrencyController")
public class StockTransCurrencyController extends BaseController<StockTransCurrency>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockTransCurrencyController.class);
	@ManagedProperty(value = "#{stockTransCurrencyService}")
	private IStockTransCurrencyService stockTransCurrencyService;

	@Override
	public void createEntity() {
		StockTransCurrency stockTransCurrency = new StockTransCurrency();
		setEntity(stockTransCurrency);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockTransCurrency>());
	}

	@Override
	public void clean() {
		setEntity(new StockTransCurrency());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockTransCurrencyService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockTransCurrencyService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockTransCurrencyService.update(getEntity());
				setMessage("StockTransCurrency is successfully updated");
				clean();
			} else {
				this.stockTransCurrencyService.add(getEntity());
				setMessage("StockTransCurrency is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockTransCurrencyService.remove(getEntityList().get(row).getId());
			setMessage("StockTransCurrency with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockTransCurrencyService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockTransCurrency?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockTransCurrency());
		return "StockTransCurrency?faces-redirect=true";
	}

	public IStockTransCurrencyService getStockTransCurrencyService() {
		return stockTransCurrencyService;
	}

	public void setStockTransCurrencyService(IStockTransCurrencyService stockTransCurrencyService) {
		this.stockTransCurrencyService = stockTransCurrencyService;
	}




	public String addStockTrans(String pageName) {
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
		childDataBean.setFrom("StockTransList");
		childDataBean.setName("org.demo.bean.yeni.StockTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}