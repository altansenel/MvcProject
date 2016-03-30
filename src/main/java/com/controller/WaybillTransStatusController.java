

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IWaybillTransStatusService;
import com.entity.WaybillTransStatus;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "waybillTransStatusController")
public class WaybillTransStatusController extends BaseController<WaybillTransStatus>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(WaybillTransStatusController.class);
	@ManagedProperty(value = "#{waybillTransStatusService}")
	private IWaybillTransStatusService waybillTransStatusService;

	@Override
	public void createEntity() {
		WaybillTransStatus waybillTransStatus = new WaybillTransStatus();
		setEntity(waybillTransStatus);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<WaybillTransStatus>());
	}

	@Override
	public void clean() {
		setEntity(new WaybillTransStatus());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(waybillTransStatusService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.waybillTransStatusService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.waybillTransStatusService.update(getEntity());
				setMessage("WaybillTransStatus is successfully updated");
				clean();
			} else {
				this.waybillTransStatusService.add(getEntity());
				setMessage("WaybillTransStatus is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.waybillTransStatusService.remove(getEntityList().get(row).getId());
			setMessage("WaybillTransStatus with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.waybillTransStatusService.getEntityById(getEntityList()
				.get(row).getId()));
		return "waybillTransStatus?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new WaybillTransStatus());
		return "WaybillTransStatus?faces-redirect=true";
	}

	public IWaybillTransStatusService getWaybillTransStatusService() {
		return waybillTransStatusService;
	}

	public void setWaybillTransStatusService(IWaybillTransStatusService waybillTransStatusService) {
		this.waybillTransStatusService = waybillTransStatusService;
	}




	public String addWaybillTransStatus(String pageName) {
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
		childDataBean.setFrom("waybillTransStatusList");
		childDataBean.setName("org.demo.bean.yeni.WaybillTransStatus");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "waybillTransStatusList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}