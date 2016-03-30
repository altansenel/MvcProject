
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransFactorConverter")
@RequestScoped
public class StockTransFactorConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransFactorConverter.class);

//	@ManagedProperty(value = "#{stockTransFactorService}")
//	private IStockTransFactorService stockTransFactorService;

//	public void setStockTransFactorService(IStockTransFactorService stockTransFactorService) {
//		this.stockTransFactorService = stockTransFactorService;
//	}

//	public IStockTransFactorService getStockTransFactorService() {
//		return stockTransFactorService;
//	}
}
