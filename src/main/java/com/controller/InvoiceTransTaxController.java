

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransTaxService;
import com.entity.InvoiceTransTax;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransTaxController")
public class InvoiceTransTaxController extends BaseController<InvoiceTransTax>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransTaxController.class);
	@ManagedProperty(value = "#{invoiceTransTaxService}")
	private IInvoiceTransTaxService invoiceTransTaxService;

	@Override
	public void createEntity() {
		InvoiceTransTax invoiceTransTax = new InvoiceTransTax();
		setEntity(invoiceTransTax);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransTax>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransTax());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransTaxService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransTaxService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransTaxService.update(getEntity());
				setMessage("InvoiceTransTax is successfully updated");
				clean();
			} else {
				this.invoiceTransTaxService.add(getEntity());
				setMessage("InvoiceTransTax is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransTaxService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransTax with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransTaxService.getEntityById(getEntityList()
				.get(row).getId()));
		return "invoiceTransTax?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransTax());
		return "InvoiceTransTax?faces-redirect=true";
	}

	public IInvoiceTransTaxService getInvoiceTransTaxService() {
		return invoiceTransTaxService;
	}

	public void setInvoiceTransTaxService(IInvoiceTransTaxService invoiceTransTaxService) {
		this.invoiceTransTaxService = invoiceTransTaxService;
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