

    
        
                            
    
                            
    
                            
    
                            
    
                    
        
                            
    
                            
    
                            
    
                            
    
                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISaleCampaignService;
import com.entity.SaleCampaign;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "saleCampaignController")
public class SaleCampaignController extends BaseController<SaleCampaign>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SaleCampaignController.class);
	@ManagedProperty(value = "#{saleCampaignService}")
	private ISaleCampaignService saleCampaignService;

	@Override
	public void createEntity() {
		SaleCampaign saleCampaign = new SaleCampaign();
		setEntity(saleCampaign);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<SaleCampaign>());
	}

	@Override
	public void clean() {
		setEntity(new SaleCampaign());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(saleCampaignService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.saleCampaignService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.saleCampaignService.update(getEntity());
				setMessage("SaleCampaign is successfully updated");
				clean();
			} else {
				this.saleCampaignService.add(getEntity());
				setMessage("SaleCampaign is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.saleCampaignService.remove(getEntityList().get(row).getId());
			setMessage("SaleCampaign with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.saleCampaignService.getEntityById(getEntityList()
				.get(row).getId()));
		return "SaleCampaign?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new SaleCampaign());
		return "SaleCampaign?faces-redirect=true";
	}

	public ISaleCampaignService getSaleCampaignService() {
		return saleCampaignService;
	}

	public void setSaleCampaignService(ISaleCampaignService saleCampaignService) {
		this.saleCampaignService = saleCampaignService;
	}




	public String addStockExtraFields(String pageName) {
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
		childDataBean.setFrom("StockExtraFieldsList");
		childDataBean.setName("org.demo.bean.yeni.StockExtraFields");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockExtraFieldsList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockCategory(String pageName) {
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
		childDataBean.setFrom("StockCategoryList");
		childDataBean.setName("org.demo.bean.yeni.StockCategory");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockCategoryList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}