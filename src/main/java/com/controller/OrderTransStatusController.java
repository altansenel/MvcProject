

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderTransStatusService;
import com.entity.OrderTransStatus;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "orderTransStatusController")
public class OrderTransStatusController extends BaseController<OrderTransStatus>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderTransStatusController.class);
	@ManagedProperty(value = "#{orderTransStatusService}")
	private IOrderTransStatusService orderTransStatusService;

	@Override
	public void createEntity() {
		OrderTransStatus orderTransStatus = new OrderTransStatus();
		setEntity(orderTransStatus);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<OrderTransStatus>());
	}

	@Override
	public void clean() {
		setEntity(new OrderTransStatus());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(orderTransStatusService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderTransStatusService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.orderTransStatusService.update(getEntity());
				setMessage("OrderTransStatus is successfully updated");
				clean();
			} else {
				this.orderTransStatusService.add(getEntity());
				setMessage("OrderTransStatus is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.orderTransStatusService.remove(getEntityList().get(row).getId());
			setMessage("OrderTransStatus with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderTransStatusService.getEntityById(getEntityList()
				.get(row).getId()));
		return "OrderTransStatus?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new OrderTransStatus());
		return "OrderTransStatus?faces-redirect=true";
	}

	public IOrderTransStatusService getOrderTransStatusService() {
		return orderTransStatusService;
	}

	public void setOrderTransStatusService(IOrderTransStatusService orderTransStatusService) {
		this.orderTransStatusService = orderTransStatusService;
	}




	public String addOrderTransStatus(String pageName) {
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
		childDataBean.setFrom("OrderTransStatusList");
		childDataBean.setName("org.demo.bean.yeni.OrderTransStatus");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "OrderTransStatusList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}