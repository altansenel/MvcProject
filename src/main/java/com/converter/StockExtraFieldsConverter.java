
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockExtraFieldsConverter")
@RequestScoped
public class StockExtraFieldsConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockExtraFieldsConverter.class);

//	@ManagedProperty(value = "#{stockExtraFieldsService}")
//	private IStockExtraFieldsService stockExtraFieldsService;

//	public void setStockExtraFieldsService(IStockExtraFieldsService stockExtraFieldsService) {
//		this.stockExtraFieldsService = stockExtraFieldsService;
//	}

//	public IStockExtraFieldsService getStockExtraFieldsService() {
//		return stockExtraFieldsService;
//	}
}
