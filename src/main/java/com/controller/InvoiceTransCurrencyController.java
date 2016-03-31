

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransCurrencyService;
import com.entity.InvoiceTransCurrency;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransCurrencyController")
public class InvoiceTransCurrencyController extends BaseController<InvoiceTransCurrency>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransCurrencyController.class);
	@ManagedProperty(value = "#{invoiceTransCurrencyService}")
	private IInvoiceTransCurrencyService invoiceTransCurrencyService;

	@Override
	public void createEntity() {
		InvoiceTransCurrency invoiceTransCurrency = new InvoiceTransCurrency();
		setEntity(invoiceTransCurrency);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransCurrency>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransCurrency());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransCurrencyService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransCurrencyService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransCurrencyService.update(getEntity());
				setMessage("InvoiceTransCurrency is successfully updated");
				clean();
			} else {
				this.invoiceTransCurrencyService.add(getEntity());
				setMessage("InvoiceTransCurrency is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransCurrencyService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransCurrency with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransCurrencyService.getEntityById(getEntityList()
				.get(row).getId()));
		return "InvoiceTransCurrency?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransCurrency());
		return "InvoiceTransCurrency?faces-redirect=true";
	}

	public IInvoiceTransCurrencyService getInvoiceTransCurrencyService() {
		return invoiceTransCurrencyService;
	}

	public void setInvoiceTransCurrencyService(IInvoiceTransCurrencyService invoiceTransCurrencyService) {
		this.invoiceTransCurrencyService = invoiceTransCurrencyService;
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