

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
                                                                                
        
                                                                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IStockTransDetailService;
import com.entity.StockTransDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "stockTransDetailController")
public class StockTransDetailController extends BaseController<StockTransDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(StockTransDetailController.class);
	@ManagedProperty(value = "#{stockTransDetailService}")
	private IStockTransDetailService stockTransDetailService;

	@Override
	public void createEntity() {
		StockTransDetail stockTransDetail = new StockTransDetail();
		setEntity(stockTransDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<StockTransDetail>());
	}

	@Override
	public void clean() {
		setEntity(new StockTransDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(stockTransDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.stockTransDetailService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.stockTransDetailService.update(getEntity());
				setMessage("StockTransDetail is successfully updated");
				clean();
			} else {
				this.stockTransDetailService.add(getEntity());
				setMessage("StockTransDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.stockTransDetailService.remove(getEntityList().get(row).getId());
			setMessage("StockTransDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.stockTransDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "StockTransDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new StockTransDetail());
		return "StockTransDetail?faces-redirect=true";
	}

	public IStockTransDetailService getStockTransDetailService() {
		return stockTransDetailService;
	}

	public void setStockTransDetailService(IStockTransDetailService stockTransDetailService) {
		this.stockTransDetailService = stockTransDetailService;
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



	public String addStockTransSource(String pageName) {
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
		childDataBean.setFrom("StockTransSourceList");
		childDataBean.setName("org.demo.bean.yeni.StockTransSource");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockTransSourceList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockDepot(String pageName) {
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
		childDataBean.setFrom("StockDepotList");
		childDataBean.setName("org.demo.bean.yeni.StockDepot");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockDepotList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addGlobalPrivateCode(String pageName) {
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
		childDataBean.setFrom("GlobalPrivateCodeList");
		childDataBean.setName("org.demo.bean.yeni.GlobalPrivateCode");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "GlobalPrivateCodeList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addSaleSeller(String pageName) {
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
		childDataBean.setFrom("SaleSellerList");
		childDataBean.setName("org.demo.bean.yeni.SaleSeller");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "SaleSellerList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStock(String pageName) {
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
		childDataBean.setFrom("StockList");
		childDataBean.setName("org.demo.bean.yeni.Stock");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addGlobalTransPoint(String pageName) {
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
		childDataBean.setFrom("GlobalTransPointList");
		childDataBean.setName("org.demo.bean.yeni.GlobalTransPoint");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "GlobalTransPointList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addContact(String pageName) {
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
		childDataBean.setFrom("ContactList");
		childDataBean.setName("org.demo.bean.yeni.Contact");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "ContactList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}