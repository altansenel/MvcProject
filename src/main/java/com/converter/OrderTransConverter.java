
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IOrderTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransConverter")
@RequestScoped
public class OrderTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransConverter.class);

	@ManagedProperty(value = "#{orderTransService}")
	private IOrderTransService orderTransService;

	public void setOrderTransService(IOrderTransService orderTransService) {
		this.orderTransService = orderTransService;
		setEntityService(orderTransService);
	}

	public IOrderTransService getOrderTransService() {
		return orderTransService;
	}
}
