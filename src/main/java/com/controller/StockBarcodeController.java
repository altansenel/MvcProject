

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockBarcodeService;
import com.entity.StockBarcode;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockBarcodeController")
public class StockBarcodeController extends BaseController<StockBarcode>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockBarcodeController.class);
	@ManagedProperty(value = "#{stockBarcodeService}")
	private IStockBarcodeService stockBarcodeService;

	@Override
	public void createEntity() {
		StockBarcode stockBarcode = new StockBarcode();
		setEntity(stockBarcode);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockBarcode>());
	}

	@Override
	public void clean() {
		setEntity(new StockBarcode());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockBarcodeService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockBarcodeService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockBarcodeService.update(getEntity());
				setMessage("StockBarcode is successfully updated");
				clean();
			} else {
				this.stockBarcodeService.add(getEntity());
				setMessage("StockBarcode is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockBarcodeService.remove(getEntityList().get(row).getId());
			setMessage("StockBarcode with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockBarcodeService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockBarcode?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockBarcode());
		return "StockBarcode?faces-redirect=true";
	}

	public IStockBarcodeService getStockBarcodeService() {
		return stockBarcodeService;
	}

	public void setStockBarcodeService(IStockBarcodeService stockBarcodeService) {
		this.stockBarcodeService = stockBarcodeService;
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



}