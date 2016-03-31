

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockTransTaxService;
import com.entity.StockTransTax;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockTransTaxController")
public class StockTransTaxController extends BaseController<StockTransTax>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockTransTaxController.class);
	@ManagedProperty(value = "#{stockTransTaxService}")
	private IStockTransTaxService stockTransTaxService;

	@Override
	public void createEntity() {
		StockTransTax stockTransTax = new StockTransTax();
		setEntity(stockTransTax);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockTransTax>());
	}

	@Override
	public void clean() {
		setEntity(new StockTransTax());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockTransTaxService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockTransTaxService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockTransTaxService.update(getEntity());
				setMessage("StockTransTax is successfully updated");
				clean();
			} else {
				this.stockTransTaxService.add(getEntity());
				setMessage("StockTransTax is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockTransTaxService.remove(getEntityList().get(row).getId());
			setMessage("StockTransTax with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockTransTaxService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockTransTax?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockTransTax());
		return "StockTransTax?faces-redirect=true";
	}

	public IStockTransTaxService getStockTransTaxService() {
		return stockTransTaxService;
	}

	public void setStockTransTaxService(IStockTransTaxService stockTransTaxService) {
		this.stockTransTaxService = stockTransTaxService;
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
		childDataBean.setFrom("stockTransList");
		childDataBean.setName("org.demo.bean.yeni.StockTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}