

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderTransSourceService;
import com.entity.OrderTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "orderTransSourceController")
public class OrderTransSourceController extends BaseController<OrderTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderTransSourceController.class);
	@ManagedProperty(value = "#{orderTransSourceService}")
	private IOrderTransSourceService orderTransSourceService;

	@Override
	public void createEntity() {
		OrderTransSource orderTransSource = new OrderTransSource();
		setEntity(orderTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<OrderTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new OrderTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(orderTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.orderTransSourceService.update(getEntity());
				setMessage("OrderTransSource is successfully updated");
				clean();
			} else {
				this.orderTransSourceService.add(getEntity());
				setMessage("OrderTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.orderTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("OrderTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "OrderTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new OrderTransSource());
		return "OrderTransSource?faces-redirect=true";
	}

	public IOrderTransSourceService getOrderTransSourceService() {
		return orderTransSourceService;
	}

	public void setOrderTransSourceService(IOrderTransSourceService orderTransSourceService) {
		this.orderTransSourceService = orderTransSourceService;
	}




}