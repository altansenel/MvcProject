
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransSourceConverter")
@RequestScoped
public class OrderTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransSourceConverter.class);

//	@ManagedProperty(value = "#{orderTransSourceService}")
//	private IOrderTransSourceService orderTransSourceService;

//	public void setOrderTransSourceService(IOrderTransSourceService orderTransSourceService) {
//		this.orderTransSourceService = orderTransSourceService;
//	}

//	public IOrderTransSourceService getOrderTransSourceService() {
//		return orderTransSourceService;
//	}
}
