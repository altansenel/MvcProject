

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IOrderTransFactorService;
import com.entity.OrderTransFactor;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "orderTransFactorController")
public class OrderTransFactorController extends BaseController<OrderTransFactor>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(OrderTransFactorController.class);
	@ManagedProperty(value = "#{orderTransFactorService}")
	private IOrderTransFactorService orderTransFactorService;

	@Override
	public void createEntity() {
		OrderTransFactor orderTransFactor = new OrderTransFactor();
		setEntity(orderTransFactor);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<OrderTransFactor>());
	}

	@Override
	public void clean() {
		setEntity(new OrderTransFactor());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(orderTransFactorService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.orderTransFactorService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.orderTransFactorService.update(getEntity());
				setMessage("OrderTransFactor is successfully updated");
				clean();
			} else {
				this.orderTransFactorService.add(getEntity());
				setMessage("OrderTransFactor is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.orderTransFactorService.remove(getEntityList().get(row).getId());
			setMessage("OrderTransFactor with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.orderTransFactorService.getEntityById(getEntityList()
				.get(row).getId()));
		return "OrderTransFactor?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new OrderTransFactor());
		return "OrderTransFactor?faces-redirect=true";
	}

	public IOrderTransFactorService getOrderTransFactorService() {
		return orderTransFactorService;
	}

	public void setOrderTransFactorService(IOrderTransFactorService orderTransFactorService) {
		this.orderTransFactorService = orderTransFactorService;
	}




	public String addStockCostFactor(String pageName) {
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
		childDataBean.setFrom("stockCostFactorList");
		childDataBean.setName("org.demo.bean.yeni.StockCostFactor");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockCostFactorList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addOrderTrans(String pageName) {
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
		childDataBean.setFrom("orderTransList");
		childDataBean.setName("org.demo.bean.yeni.OrderTrans");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "orderTransList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}