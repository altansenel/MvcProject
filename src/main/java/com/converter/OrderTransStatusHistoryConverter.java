
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IOrderTransStatusHistoryService;

import org.apache.log4j.Logger;



@ManagedBean(name = "orderTransStatusHistoryConverter")
@RequestScoped
public class OrderTransStatusHistoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderTransStatusHistoryConverter.class);

	@ManagedProperty(value = "#{orderTransStatusHistoryService}")
	private IOrderTransStatusHistoryService orderTransStatusHistoryService;

	public void setOrderTransStatusHistoryService(IOrderTransStatusHistoryService orderTransStatusHistoryService) {
		this.orderTransStatusHistoryService = orderTransStatusHistoryService;
		setEntityService(orderTransStatusHistoryService);
	}

	public IOrderTransStatusHistoryService getOrderTransStatusHistoryService() {
		return orderTransStatusHistoryService;
	}
}
