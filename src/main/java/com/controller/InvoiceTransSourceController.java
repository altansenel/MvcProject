

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransSourceService;
import com.entity.InvoiceTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransSourceController")
public class InvoiceTransSourceController extends BaseController<InvoiceTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransSourceController.class);
	@ManagedProperty(value = "#{invoiceTransSourceService}")
	private IInvoiceTransSourceService invoiceTransSourceService;

	@Override
	public void createEntity() {
		InvoiceTransSource invoiceTransSource = new InvoiceTransSource();
		setEntity(invoiceTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransSourceService.update(getEntity());
				setMessage("InvoiceTransSource is successfully updated");
				clean();
			} else {
				this.invoiceTransSourceService.add(getEntity());
				setMessage("InvoiceTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "invoiceTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransSource());
		return "InvoiceTransSource?faces-redirect=true";
	}

	public IInvoiceTransSourceService getInvoiceTransSourceService() {
		return invoiceTransSourceService;
	}

	public void setInvoiceTransSourceService(IInvoiceTransSourceService invoiceTransSourceService) {
		this.invoiceTransSourceService = invoiceTransSourceService;
	}




}