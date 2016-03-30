
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockCostingInventoryConverter")
@RequestScoped
public class StockCostingInventoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockCostingInventoryConverter.class);

//	@ManagedProperty(value = "#{stockCostingInventoryService}")
//	private IStockCostingInventoryService stockCostingInventoryService;

//	public void setStockCostingInventoryService(IStockCostingInventoryService stockCostingInventoryService) {
//		this.stockCostingInventoryService = stockCostingInventoryService;
//	}

//	public IStockCostingInventoryService getStockCostingInventoryService() {
//		return stockCostingInventoryService;
//	}
}
