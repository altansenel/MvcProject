package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

/**
 * @version {} Eylül 17, 2015
 * @author Altan Senel
 * 
 */

@Audited
@Entity
@Table(name = "ORDERS", indexes = {
		@Index(columnList = "customer_id", name = "IND_ORDERS_CUSTOMER"),
		@Index(columnList = "employee_id", name = "IND_ORDERS_EMPLOYEE"),
		@Index(columnList = "shippin_Method_id", name = "IND_ORDERS_SHIPPINGMETHOD") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Order extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	@OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

	@JoinColumn(name = "employee_id", referencedColumnName="id", foreignKey = @ForeignKey(name = "FK_ORDER_EMPLOYEE"))
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;

	@JoinColumn(name = "shippin_Method_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private ShippingMethod shippinMethod;

	@Column(name = "orderDate")
	private Date orderDate;

	@Transient
	private Date ilkOrderDate;

	@Transient
	private Date sonOrderDate;

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ShippingMethod getShippinMethod() {
		return shippinMethod;
	}

	public void setShippinMethod(ShippingMethod shippinMethod) {
		this.shippinMethod = shippinMethod;
	}

	public Date getIlkOrderDate() {
		return ilkOrderDate;
	}

	public Date getSonOrderDate() {
		return sonOrderDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setIlkOrderDate(Date ilkOrderDate) {
		this.ilkOrderDate = ilkOrderDate;
	}

	public void setSonOrderDate(Date sonOrderDate) {
		this.sonOrderDate = sonOrderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}