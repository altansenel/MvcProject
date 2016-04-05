

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockPriceUpdateDetailService;
import com.entity.StockPriceUpdateDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockPriceUpdateDetailController")
public class StockPriceUpdateDetailController extends BaseController<StockPriceUpdateDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockPriceUpdateDetailController.class);
	@ManagedProperty(value = "#{stockPriceUpdateDetailService}")
	private IStockPriceUpdateDetailService stockPriceUpdateDetailService;

	@Override
	public void createEntity() {
		StockPriceUpdateDetail stockPriceUpdateDetail = new StockPriceUpdateDetail();
		setEntity(stockPriceUpdateDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockPriceUpdateDetail>());
	}

	@Override
	public void clean() {
		setEntity(new StockPriceUpdateDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockPriceUpdateDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockPriceUpdateDetailService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockPriceUpdateDetailService.update(getEntity());
				setMessage("StockPriceUpdateDetail is successfully updated");
				clean();
			} else {
				this.stockPriceUpdateDetailService.add(getEntity());
				setMessage("StockPriceUpdateDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockPriceUpdateDetailService.remove(getEntityList().get(row).getId());
			setMessage("StockPriceUpdateDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockPriceUpdateDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockPriceUpdateDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockPriceUpdateDetail());
		return "StockPriceUpdateDetail?faces-redirect=true";
	}

	public IStockPriceUpdateDetailService getStockPriceUpdateDetailService() {
		return stockPriceUpdateDetailService;
	}

	public void setStockPriceUpdateDetailService(IStockPriceUpdateDetailService stockPriceUpdateDetailService) {
		this.stockPriceUpdateDetailService = stockPriceUpdateDetailService;
	}




	public String addStockPriceUpdate(String pageName) {
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
		childDataBean.setFrom("StockPriceUpdateList");
		childDataBean.setName("org.demo.bean.yeni.StockPriceUpdate");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockPriceUpdateList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}