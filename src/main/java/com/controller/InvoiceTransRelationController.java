

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransRelationService;
import com.entity.InvoiceTransRelation;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransRelationController")
public class InvoiceTransRelationController extends BaseController<InvoiceTransRelation>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransRelationController.class);
	@ManagedProperty(value = "#{invoiceTransRelationService}")
	private IInvoiceTransRelationService invoiceTransRelationService;

	@Override
	public void createEntity() {
		InvoiceTransRelation invoiceTransRelation = new InvoiceTransRelation();
		setEntity(invoiceTransRelation);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransRelation>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransRelation());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransRelationService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransRelationService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransRelationService.update(getEntity());
				setMessage("InvoiceTransRelation is successfully updated");
				clean();
			} else {
				this.invoiceTransRelationService.add(getEntity());
				setMessage("InvoiceTransRelation is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransRelationService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransRelation with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransRelationService.getEntityById(getEntityList()
				.get(row).getId()));
		return "invoiceTransRelation?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransRelation());
		return "InvoiceTransRelation?faces-redirect=true";
	}

	public IInvoiceTransRelationService getInvoiceTransRelationService() {
		return invoiceTransRelationService;
	}

	public void setInvoiceTransRelationService(IInvoiceTransRelationService invoiceTransRelationService) {
		this.invoiceTransRelationService = invoiceTransRelationService;
	}




	public String addInvoiceTrans(String pageName) {
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
		childDataBean.setFrom("invoiceTransList");
		childDataBean.setName("org.demo.bean.yeni.InvoiceTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "invoiceTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}