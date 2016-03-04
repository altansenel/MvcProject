package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderService;
import com.entity.Order;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "orderController")
public class OrderController extends BaseController<Order> implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderController.class);
	@ManagedProperty(value = "#{orderService}")
	private IOrderService orderService;

	@Override
	public void createEntity() {
		Order order = new Order();
		setEntity(order);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Order>());
	}

	@Override
	public void clean() {
		setEntity(new Order());
		getEntityList().clear();
		setDataBean(null);
	}

	@Override
	public void setEid(Long eid) {
		setEntity(orderService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderService.list(getEntity()));
	}

	public void save(Long id) {
		if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
			try {
				if (id != null) {
					this.orderService.update(getEntity());
					setMessage("Order is successfully updated");
					clean();
				} else {
					this.orderService.add(getEntity());
					setMessage("Order is successfully created");
					clean();
				}
			} catch (Exception e) {
				logger.error(e);
				setMessage(e.getMessage());
			}
		}
	}

	public void remove(int row) {
		try {
			this.orderService.remove(getEntityList().get(row).getId());
			setMessage("Order with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderService.getEntityById(getEntityList().get(row)
				.getId()));
		return "order?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Order());
		return "order?faces-redirect=true";
	}

	public IOrderService getPersonService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public String addCustomerManyToOne(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("customerList");
		childDataBean.setName("com.entity.Customer");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "customerList?faces-redirect=true&addSelect="
				+ AddSelect.ADD.ordinal();
	}

	public String orderDetailEkleOneToMany(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.oneToMany);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("orderDetailList");
		childDataBean.setName("com.entity.OrderDetail");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "orderDetailList?faces-redirect=true&addSelect="
				+ AddSelect.ADD.ordinal();
	}

	public String addEmployeeManyToOne(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("employeeList");
		childDataBean.setName("com.entity.Employee");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "employeeList?faces-redirect=true&addSelect="
				+ AddSelect.ADD.ordinal();
	}

	public String addShippingMethodManyToOne(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("shippingMethodList");
		childDataBean.setName("com.entity.ShippingMethod");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "shippingMethodList?faces-redirect=true&addSelect="
				+ AddSelect.ADD.ordinal();
	}
}