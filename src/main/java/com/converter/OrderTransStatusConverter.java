
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransStatusConverter")
@RequestScoped
public class OrderTransStatusConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransStatusConverter.class);

//	@ManagedProperty(value = "#{orderTransStatusService}")
//	private IOrderTransStatusService orderTransStatusService;

//	public void setOrderTransStatusService(IOrderTransStatusService orderTransStatusService) {
//		this.orderTransStatusService = orderTransStatusService;
//	}

//	public IOrderTransStatusService getOrderTransStatusService() {
//		return orderTransStatusService;
//	}
}
