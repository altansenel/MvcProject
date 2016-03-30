



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderTransStatusHistoryService;
import com.entity.OrderTransStatusHistory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "orderTransStatusHistoryController")
public class OrderTransStatusHistoryController extends BaseController<OrderTransStatusHistory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderTransStatusHistoryController.class);
	@ManagedProperty(value = "#{orderTransStatusHistoryService}")
	private IOrderTransStatusHistoryService orderTransStatusHistoryService;

	@Override
	public void createEntity() {
		OrderTransStatusHistory orderTransStatusHistory = new OrderTransStatusHistory();
		setEntity(orderTransStatusHistory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<OrderTransStatusHistory>());
	}

	@Override
	public void clean() {
		setEntity(new OrderTransStatusHistory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(orderTransStatusHistoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderTransStatusHistoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.orderTransStatusHistoryService.update(getEntity());
				setMessage("OrderTransStatusHistory is successfully updated");
				clean();
			} else {
				this.orderTransStatusHistoryService.add(getEntity());
				setMessage("OrderTransStatusHistory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.orderTransStatusHistoryService.remove(getEntityList().get(row).getId());
			setMessage("OrderTransStatusHistory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderTransStatusHistoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "orderTransStatusHistory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new OrderTransStatusHistory());
		return "OrderTransStatusHistory?faces-redirect=true";
	}

	public IOrderTransStatusHistoryService getOrderTransStatusHistoryService() {
		return orderTransStatusHistoryService;
	}

	public void setOrderTransStatusHistoryService(IOrderTransStatusHistoryService orderTransStatusHistoryService) {
		this.orderTransStatusHistoryService = orderTransStatusHistoryService;
	}




}