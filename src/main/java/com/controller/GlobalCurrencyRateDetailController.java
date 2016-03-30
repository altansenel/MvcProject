

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IGlobalCurrencyRateDetailService;
import com.entity.GlobalCurrencyRateDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "globalCurrencyRateDetailController")
public class GlobalCurrencyRateDetailController extends BaseController<GlobalCurrencyRateDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GlobalCurrencyRateDetailController.class);
	@ManagedProperty(value = "#{globalCurrencyRateDetailService}")
	private IGlobalCurrencyRateDetailService globalCurrencyRateDetailService;

	@Override
	public void createEntity() {
		GlobalCurrencyRateDetail globalCurrencyRateDetail = new GlobalCurrencyRateDetail();
		setEntity(globalCurrencyRateDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GlobalCurrencyRateDetail>());
	}

	@Override
	public void clean() {
		setEntity(new GlobalCurrencyRateDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(globalCurrencyRateDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.globalCurrencyRateDetailService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.globalCurrencyRateDetailService.update(getEntity());
				setMessage("GlobalCurrencyRateDetail is successfully updated");
				clean();
			} else {
				this.globalCurrencyRateDetailService.add(getEntity());
				setMessage("GlobalCurrencyRateDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.globalCurrencyRateDetailService.remove(getEntityList().get(row).getId());
			setMessage("GlobalCurrencyRateDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.globalCurrencyRateDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "globalCurrencyRateDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GlobalCurrencyRateDetail());
		return "GlobalCurrencyRateDetail?faces-redirect=true";
	}

	public IGlobalCurrencyRateDetailService getGlobalCurrencyRateDetailService() {
		return globalCurrencyRateDetailService;
	}

	public void setGlobalCurrencyRateDetailService(IGlobalCurrencyRateDetailService globalCurrencyRateDetailService) {
		this.globalCurrencyRateDetailService = globalCurrencyRateDetailService;
	}




	public String addGlobalCurrencyRate(String pageName) {
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
		childDataBean.setFrom("globalCurrencyRateList");
		childDataBean.setName("org.demo.bean.yeni.GlobalCurrencyRate");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "globalCurrencyRateList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}