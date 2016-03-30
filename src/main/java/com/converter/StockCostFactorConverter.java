
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockCostFactorConverter")
@RequestScoped
public class StockCostFactorConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockCostFactorConverter.class);

//	@ManagedProperty(value = "#{stockCostFactorService}")
//	private IStockCostFactorService stockCostFactorService;

//	public void setStockCostFactorService(IStockCostFactorService stockCostFactorService) {
//		this.stockCostFactorService = stockCostFactorService;
//	}

//	public IStockCostFactorService getStockCostFactorService() {
//		return stockCostFactorService;
//	}
}
