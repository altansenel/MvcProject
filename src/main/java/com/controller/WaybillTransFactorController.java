

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IWaybillTransFactorService;
import com.entity.WaybillTransFactor;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "waybillTransFactorController")
public class WaybillTransFactorController extends BaseController<WaybillTransFactor>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(WaybillTransFactorController.class);
	@ManagedProperty(value = "#{waybillTransFactorService}")
	private IWaybillTransFactorService waybillTransFactorService;

	@Override
	public void createEntity() {
		WaybillTransFactor waybillTransFactor = new WaybillTransFactor();
		setEntity(waybillTransFactor);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<WaybillTransFactor>());
	}

	@Override
	public void clean() {
		setEntity(new WaybillTransFactor());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(waybillTransFactorService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.waybillTransFactorService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.waybillTransFactorService.update(getEntity());
				setMessage("WaybillTransFactor is successfully updated");
				clean();
			} else {
				this.waybillTransFactorService.add(getEntity());
				setMessage("WaybillTransFactor is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.waybillTransFactorService.remove(getEntityList().get(row).getId());
			setMessage("WaybillTransFactor with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.waybillTransFactorService.getEntityById(getEntityList()
				.get(row).getId()));
		return "WaybillTransFactor?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new WaybillTransFactor());
		return "WaybillTransFactor?faces-redirect=true";
	}

	public IWaybillTransFactorService getWaybillTransFactorService() {
		return waybillTransFactorService;
	}

	public void setWaybillTransFactorService(IWaybillTransFactorService waybillTransFactorService) {
		this.waybillTransFactorService = waybillTransFactorService;
	}




	public String addStockCostFactor(String pageName) {
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
		childDataBean.setFrom("stockCostFactorList");
		childDataBean.setName("org.demo.bean.yeni.StockCostFactor");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockCostFactorList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addWaybillTrans(String pageName) {
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
		childDataBean.setFrom("waybillTransList");
		childDataBean.setName("org.demo.bean.yeni.WaybillTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "waybillTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}