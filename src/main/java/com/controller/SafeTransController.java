

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISafeTransService;
import com.entity.SafeTrans;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "safeTransController")
public class SafeTransController extends BaseController<SafeTrans>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SafeTransController.class);
	@ManagedProperty(value = "#{safeTransService}")
	private ISafeTransService safeTransService;

	@Override
	public void createEntity() {
		SafeTrans safeTrans = new SafeTrans();
		setEntity(safeTrans);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<SafeTrans>());
	}

	@Override
	public void clean() {
		setEntity(new SafeTrans());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(safeTransService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.safeTransService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.safeTransService.update(getEntity());
				setMessage("SafeTrans is successfully updated");
				clean();
			} else {
				this.safeTransService.add(getEntity());
				setMessage("SafeTrans is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.safeTransService.remove(getEntityList().get(row).getId());
			setMessage("SafeTrans with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.safeTransService.getEntityById(getEntityList()
				.get(row).getId()));
		return "SafeTrans?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new SafeTrans());
		return "SafeTrans?faces-redirect=true";
	}

	public ISafeTransService getSafeTransService() {
		return safeTransService;
	}

	public void setSafeTransService(ISafeTransService safeTransService) {
		this.safeTransService = safeTransService;
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



	public String addSafeExpense(String pageName) {
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
		childDataBean.setFrom("SafeExpenseList");
		childDataBean.setName("org.demo.bean.yeni.SafeExpense");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "SafeExpenseList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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



	public String addSafe(String pageName) {
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
		childDataBean.setFrom("SafeList");
		childDataBean.setName("org.demo.bean.yeni.Safe");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "SafeList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addSafeTransSource(String pageName) {
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
		childDataBean.setFrom("SafeTransSourceList");
		childDataBean.setName("org.demo.bean.yeni.SafeTransSource");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "SafeTransSourceList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}