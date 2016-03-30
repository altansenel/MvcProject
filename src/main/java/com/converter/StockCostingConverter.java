
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockCostingConverter")
@RequestScoped
public class StockCostingConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockCostingConverter.class);

//	@ManagedProperty(value = "#{stockCostingService}")
//	private IStockCostingService stockCostingService;

//	public void setStockCostingService(IStockCostingService stockCostingService) {
//		this.stockCostingService = stockCostingService;
//	}

//	public IStockCostingService getStockCostingService() {
//		return stockCostingService;
//	}
}
