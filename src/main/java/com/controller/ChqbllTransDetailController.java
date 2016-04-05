

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IChqbllTransDetailService;
import com.entity.ChqbllTransDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "chqbllTransDetailController")
public class ChqbllTransDetailController extends BaseController<ChqbllTransDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ChqbllTransDetailController.class);
	@ManagedProperty(value = "#{chqbllTransDetailService}")
	private IChqbllTransDetailService chqbllTransDetailService;

	@Override
	public void createEntity() {
		ChqbllTransDetail chqbllTransDetail = new ChqbllTransDetail();
		setEntity(chqbllTransDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ChqbllTransDetail>());
	}

	@Override
	public void clean() {
		setEntity(new ChqbllTransDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(chqbllTransDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.chqbllTransDetailService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.chqbllTransDetailService.update(getEntity());
				setMessage("ChqbllTransDetail is successfully updated");
				clean();
			} else {
				this.chqbllTransDetailService.add(getEntity());
				setMessage("ChqbllTransDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.chqbllTransDetailService.remove(getEntityList().get(row).getId());
			setMessage("ChqbllTransDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.chqbllTransDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ChqbllTransDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ChqbllTransDetail());
		return "ChqbllTransDetail?faces-redirect=true";
	}

	public IChqbllTransDetailService getChqbllTransDetailService() {
		return chqbllTransDetailService;
	}

	public void setChqbllTransDetailService(IChqbllTransDetailService chqbllTransDetailService) {
		this.chqbllTransDetailService = chqbllTransDetailService;
	}




	public String addChqbllPayrollDetail(String pageName) {
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
		childDataBean.setFrom("ChqbllPayrollDetailList");
		childDataBean.setName("org.demo.bean.yeni.ChqbllPayrollDetail");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "ChqbllPayrollDetailList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addChqbllTrans(String pageName) {
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
		childDataBean.setFrom("ChqbllTransList");
		childDataBean.setName("org.demo.bean.yeni.ChqbllTrans");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "ChqbllTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}