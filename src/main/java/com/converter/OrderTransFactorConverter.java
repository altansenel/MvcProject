
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IOrderTransFactorService;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransFactorConverter")
@RequestScoped
public class OrderTransFactorConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransFactorConverter.class);

	@ManagedProperty(value = "#{orderTransFactorService}")
	private IOrderTransFactorService orderTransFactorService;

	public void setOrderTransFactorService(IOrderTransFactorService orderTransFactorService) {
		this.orderTransFactorService = orderTransFactorService;
		setEntityService(orderTransFactorService);
	}

	public IOrderTransFactorService getOrderTransFactorService() {
		return orderTransFactorService;
	}
}
