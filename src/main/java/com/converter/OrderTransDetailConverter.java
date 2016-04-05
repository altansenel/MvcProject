
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IOrderTransDetailService;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransDetailConverter")
@RequestScoped
public class OrderTransDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransDetailConverter.class);

	@ManagedProperty(value = "#{orderTransDetailService}")
	private IOrderTransDetailService orderTransDetailService;

	public void setOrderTransDetailService(IOrderTransDetailService orderTransDetailService) {
		this.orderTransDetailService = orderTransDetailService;
		setEntityService(orderTransDetailService);
	}

	public IOrderTransDetailService getOrderTransDetailService() {
		return orderTransDetailService;
	}
}
