

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IWaybillTransRelationService;
import com.entity.WaybillTransRelation;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "waybillTransRelationController")
public class WaybillTransRelationController extends BaseController<WaybillTransRelation>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(WaybillTransRelationController.class);
	@ManagedProperty(value = "#{waybillTransRelationService}")
	private IWaybillTransRelationService waybillTransRelationService;

	@Override
	public void createEntity() {
		WaybillTransRelation waybillTransRelation = new WaybillTransRelation();
		setEntity(waybillTransRelation);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<WaybillTransRelation>());
	}

	@Override
	public void clean() {
		setEntity(new WaybillTransRelation());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(waybillTransRelationService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.waybillTransRelationService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.waybillTransRelationService.update(getEntity());
				setMessage("WaybillTransRelation is successfully updated");
				clean();
			} else {
				this.waybillTransRelationService.add(getEntity());
				setMessage("WaybillTransRelation is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.waybillTransRelationService.remove(getEntityList().get(row).getId());
			setMessage("WaybillTransRelation with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.waybillTransRelationService.getEntityById(getEntityList()
				.get(row).getId()));
		return "WaybillTransRelation?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new WaybillTransRelation());
		return "WaybillTransRelation?faces-redirect=true";
	}

	public IWaybillTransRelationService getWaybillTransRelationService() {
		return waybillTransRelationService;
	}

	public void setWaybillTransRelationService(IWaybillTransRelationService waybillTransRelationService) {
		this.waybillTransRelationService = waybillTransRelationService;
	}




	public String addWaybillTrans(String pageName) {
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
		childDataBean.setFrom("WaybillTransList");
		childDataBean.setName("org.demo.bean.yeni.WaybillTrans");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "WaybillTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}