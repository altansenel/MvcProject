package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderDetailService;
import com.entity.OrderDetail;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "orderDetailController")
public class OrderDetailController extends BaseController<OrderDetail>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderDetailController.class);
	@ManagedProperty(value = "#{orderDetailService}")
	private IOrderDetailService orderDetailService;

	@Override
	public void createEntity() {
		OrderDetail orderDetail = new OrderDetail();
		setEntity(orderDetail);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<OrderDetail>());
	}

	@Override
	public void clean() {
		setEntity(new OrderDetail());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(orderDetailService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderDetailService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.orderDetailService.update(getEntity());
				setMessage("OrderDetail is successfully updated");
				clean();
			} else {
				this.orderDetailService.add(getEntity());
				setMessage("OrderDetail is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.orderDetailService.remove(getEntityList().get(row).getId());
			setMessage("OrderDetail with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderDetailService.getEntityById(getEntityList()
				.get(row).getId()));
		return "orderDetail?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new OrderDetail());
		return "orderDetail?faces-redirect=true";
	}

	public IOrderDetailService getPersonService() {
		return orderDetailService;
	}

	public void setOrderDetailService(IOrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public String addProduct(String pageName) {
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
		childDataBean.setFrom("productList");
		childDataBean.setName("com.entity.Product");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "productList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}

	public String addOrder(String pageName) {
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
		childDataBean.setFrom("orderList");
		childDataBean.setName("com.entity.Order");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "orderList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}

}