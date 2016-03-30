



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransStatusHistoryService;
import com.entity.InvoiceTransStatusHistory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransStatusHistoryController")
public class InvoiceTransStatusHistoryController extends BaseController<InvoiceTransStatusHistory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransStatusHistoryController.class);
	@ManagedProperty(value = "#{invoiceTransStatusHistoryService}")
	private IInvoiceTransStatusHistoryService invoiceTransStatusHistoryService;

	@Override
	public void createEntity() {
		InvoiceTransStatusHistory invoiceTransStatusHistory = new InvoiceTransStatusHistory();
		setEntity(invoiceTransStatusHistory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransStatusHistory>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransStatusHistory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransStatusHistoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransStatusHistoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransStatusHistoryService.update(getEntity());
				setMessage("InvoiceTransStatusHistory is successfully updated");
				clean();
			} else {
				this.invoiceTransStatusHistoryService.add(getEntity());
				setMessage("InvoiceTransStatusHistory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransStatusHistoryService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransStatusHistory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransStatusHistoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "invoiceTransStatusHistory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransStatusHistory());
		return "InvoiceTransStatusHistory?faces-redirect=true";
	}

	public IInvoiceTransStatusHistoryService getInvoiceTransStatusHistoryService() {
		return invoiceTransStatusHistoryService;
	}

	public void setInvoiceTransStatusHistoryService(IInvoiceTransStatusHistoryService invoiceTransStatusHistoryService) {
		this.invoiceTransStatusHistoryService = invoiceTransStatusHistoryService;
	}




}