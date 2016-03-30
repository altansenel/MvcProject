

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IInvoiceTransStatusService;
import com.entity.InvoiceTransStatus;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "invoiceTransStatusController")
public class InvoiceTransStatusController extends BaseController<InvoiceTransStatus>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(InvoiceTransStatusController.class);
	@ManagedProperty(value = "#{invoiceTransStatusService}")
	private IInvoiceTransStatusService invoiceTransStatusService;

	@Override
	public void createEntity() {
		InvoiceTransStatus invoiceTransStatus = new InvoiceTransStatus();
		setEntity(invoiceTransStatus);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<InvoiceTransStatus>());
	}

	@Override
	public void clean() {
		setEntity(new InvoiceTransStatus());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(invoiceTransStatusService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.invoiceTransStatusService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.invoiceTransStatusService.update(getEntity());
				setMessage("InvoiceTransStatus is successfully updated");
				clean();
			} else {
				this.invoiceTransStatusService.add(getEntity());
				setMessage("InvoiceTransStatus is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.invoiceTransStatusService.remove(getEntityList().get(row).getId());
			setMessage("InvoiceTransStatus with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.invoiceTransStatusService.getEntityById(getEntityList()
				.get(row).getId()));
		return "invoiceTransStatus?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new InvoiceTransStatus());
		return "InvoiceTransStatus?faces-redirect=true";
	}

	public IInvoiceTransStatusService getInvoiceTransStatusService() {
		return invoiceTransStatusService;
	}

	public void setInvoiceTransStatusService(IInvoiceTransStatusService invoiceTransStatusService) {
		this.invoiceTransStatusService = invoiceTransStatusService;
	}




	public String addInvoiceTransStatus(String pageName) {
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
		childDataBean.setFrom("invoiceTransStatusList");
		childDataBean.setName("org.demo.bean.yeni.InvoiceTransStatus");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "invoiceTransStatusList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}