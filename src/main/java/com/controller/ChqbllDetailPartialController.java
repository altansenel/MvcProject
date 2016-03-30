

    
        
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IChqbllDetailPartialService;
import com.entity.ChqbllDetailPartial;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "chqbllDetailPartialController")
public class ChqbllDetailPartialController extends BaseController<ChqbllDetailPartial>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ChqbllDetailPartialController.class);
	@ManagedProperty(value = "#{chqbllDetailPartialService}")
	private IChqbllDetailPartialService chqbllDetailPartialService;

	@Override
	public void createEntity() {
		ChqbllDetailPartial chqbllDetailPartial = new ChqbllDetailPartial();
		setEntity(chqbllDetailPartial);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ChqbllDetailPartial>());
	}

	@Override
	public void clean() {
		setEntity(new ChqbllDetailPartial());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(chqbllDetailPartialService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.chqbllDetailPartialService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.chqbllDetailPartialService.update(getEntity());
				setMessage("ChqbllDetailPartial is successfully updated");
				clean();
			} else {
				this.chqbllDetailPartialService.add(getEntity());
				setMessage("ChqbllDetailPartial is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.chqbllDetailPartialService.remove(getEntityList().get(row).getId());
			setMessage("ChqbllDetailPartial with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.chqbllDetailPartialService.getEntityById(getEntityList()
				.get(row).getId()));
		return "chqbllDetailPartial?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ChqbllDetailPartial());
		return "ChqbllDetailPartial?faces-redirect=true";
	}

	public IChqbllDetailPartialService getChqbllDetailPartialService() {
		return chqbllDetailPartialService;
	}

	public void setChqbllDetailPartialService(IChqbllDetailPartialService chqbllDetailPartialService) {
		this.chqbllDetailPartialService = chqbllDetailPartialService;
	}




	public String addSafe(String pageName) {
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
		childDataBean.setFrom("safeList");
		childDataBean.setName("org.demo.bean.yeni.Safe");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "safeList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addSafeTrans(String pageName) {
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
		childDataBean.setFrom("safeTransList");
		childDataBean.setName("org.demo.bean.yeni.SafeTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "safeTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addChqbllPayrollDetail(String pageName) {
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
		childDataBean.setFrom("chqbllPayrollDetailList");
		childDataBean.setName("org.demo.bean.yeni.ChqbllPayrollDetail");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "chqbllPayrollDetailList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}