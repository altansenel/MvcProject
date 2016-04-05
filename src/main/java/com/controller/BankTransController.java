

    
        
                    
        
                                
        
                                            
        
                                                        
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IBankTransService;
import com.entity.BankTrans;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "bankTransController")
public class BankTransController extends BaseController<BankTrans>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(BankTransController.class);
	@ManagedProperty(value = "#{bankTransService}")
	private IBankTransService bankTransService;

	@Override
	public void createEntity() {
		BankTrans bankTrans = new BankTrans();
		setEntity(bankTrans);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<BankTrans>());
	}

	@Override
	public void clean() {
		setEntity(new BankTrans());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(bankTransService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.bankTransService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.bankTransService.update(getEntity());
				setMessage("BankTrans is successfully updated");
				clean();
			} else {
				this.bankTransService.add(getEntity());
				setMessage("BankTrans is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.bankTransService.remove(getEntityList().get(row).getId());
			setMessage("BankTrans with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.bankTransService.getEntityById(getEntityList()
				.get(row).getId()));
		return "BankTrans?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new BankTrans());
		return "BankTrans?faces-redirect=true";
	}

	public IBankTransService getBankTransService() {
		return bankTransService;
	}

	public void setBankTransService(IBankTransService bankTransService) {
		this.bankTransService = bankTransService;
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



	public String addBank(String pageName) {
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
		childDataBean.setFrom("BankList");
		childDataBean.setName("org.demo.bean.yeni.Bank");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "BankList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addBankTransSource(String pageName) {
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
		childDataBean.setFrom("BankTransSourceList");
		childDataBean.setName("org.demo.bean.yeni.BankTransSource");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "BankTransSourceList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
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



	public String addBankExpense(String pageName) {
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
		childDataBean.setFrom("BankExpenseList");
		childDataBean.setName("org.demo.bean.yeni.BankExpense");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "BankExpenseList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}