package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @version {} Eylül 07, 2015
 * @author Altan Senel
 * 
 */

@Audited
@Entity
@Table(name = "ORDER_DETAIL", indexes = {
		@Index(columnList = "product_id", name = "IND_ORDER_DETAIL_PRODUCT"),
		@Index(columnList = "order_id", name = "IND_ORDER_DETAIL_ORDER") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OrderDetail extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "product_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

	@JoinColumn(name = "order_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Order order;

	@Column(name = "quantity")
	private Integer quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}