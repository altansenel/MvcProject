
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransSourceConverter")
@RequestScoped
public class StockTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransSourceConverter.class);

//	@ManagedProperty(value = "#{stockTransSourceService}")
//	private IStockTransSourceService stockTransSourceService;

//	public void setStockTransSourceService(IStockTransSourceService stockTransSourceService) {
//		this.stockTransSourceService = stockTransSourceService;
//	}

//	public IStockTransSourceService getStockTransSourceService() {
//		return stockTransSourceService;
//	}
}
