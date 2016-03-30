

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IChqbllDetailHistoryService;
import com.entity.ChqbllDetailHistory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "chqbllDetailHistoryController")
public class ChqbllDetailHistoryController extends BaseController<ChqbllDetailHistory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ChqbllDetailHistoryController.class);
	@ManagedProperty(value = "#{chqbllDetailHistoryService}")
	private IChqbllDetailHistoryService chqbllDetailHistoryService;

	@Override
	public void createEntity() {
		ChqbllDetailHistory chqbllDetailHistory = new ChqbllDetailHistory();
		setEntity(chqbllDetailHistory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ChqbllDetailHistory>());
	}

	@Override
	public void clean() {
		setEntity(new ChqbllDetailHistory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(chqbllDetailHistoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.chqbllDetailHistoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.chqbllDetailHistoryService.update(getEntity());
				setMessage("ChqbllDetailHistory is successfully updated");
				clean();
			} else {
				this.chqbllDetailHistoryService.add(getEntity());
				setMessage("ChqbllDetailHistory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.chqbllDetailHistoryService.remove(getEntityList().get(row).getId());
			setMessage("ChqbllDetailHistory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.chqbllDetailHistoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "chqbllDetailHistory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ChqbllDetailHistory());
		return "ChqbllDetailHistory?faces-redirect=true";
	}

	public IChqbllDetailHistoryService getChqbllDetailHistoryService() {
		return chqbllDetailHistoryService;
	}

	public void setChqbllDetailHistoryService(IChqbllDetailHistoryService chqbllDetailHistoryService) {
		this.chqbllDetailHistoryService = chqbllDetailHistoryService;
	}




	public String addContact(String pageName) {
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
		childDataBean.setFrom("contactList");
		childDataBean.setName("org.demo.bean.yeni.Contact");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "contactList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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



	public String addBank(String pageName) {
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
		childDataBean.setFrom("bankList");
		childDataBean.setName("org.demo.bean.yeni.Bank");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "bankList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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