

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransFactorService;
import com.entity.InvoiceTransFactor;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransFactorController")
public class InvoiceTransFactorController extends BaseController<InvoiceTransFactor>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransFactorController.class);
	@ManagedProperty(value = "#{invoiceTransFactorService}")
	private IInvoiceTransFactorService invoiceTransFactorService;

	@Override
	public void createEntity() {
		InvoiceTransFactor invoiceTransFactor = new InvoiceTransFactor();
		setEntity(invoiceTransFactor);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransFactor>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransFactor());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransFactorService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransFactorService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransFactorService.update(getEntity());
				setMessage("InvoiceTransFactor is successfully updated");
				clean();
			} else {
				this.invoiceTransFactorService.add(getEntity());
				setMessage("InvoiceTransFactor is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransFactorService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransFactor with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransFactorService.getEntityById(getEntityList()
				.get(row).getId()));
		return "InvoiceTransFactor?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransFactor());
		return "InvoiceTransFactor?faces-redirect=true";
	}

	public IInvoiceTransFactorService getInvoiceTransFactorService() {
		return invoiceTransFactorService;
	}

	public void setInvoiceTransFactorService(IInvoiceTransFactorService invoiceTransFactorService) {
		this.invoiceTransFactorService = invoiceTransFactorService;
	}




	public String addStockCostFactor(String pageName) {
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
		childDataBean.setFrom("StockCostFactorList");
		childDataBean.setName("org.demo.bean.yeni.StockCostFactor");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "StockCostFactorList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addInvoiceTrans(String pageName) {
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
		childDataBean.setFrom("InvoiceTransList");
		childDataBean.setName("org.demo.bean.yeni.InvoiceTrans");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "InvoiceTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}