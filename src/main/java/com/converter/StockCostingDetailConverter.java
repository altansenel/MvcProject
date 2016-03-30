
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockCostingDetailConverter")
@RequestScoped
public class StockCostingDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockCostingDetailConverter.class);

//	@ManagedProperty(value = "#{stockCostingDetailService}")
//	private IStockCostingDetailService stockCostingDetailService;

//	public void setStockCostingDetailService(IStockCostingDetailService stockCostingDetailService) {
//		this.stockCostingDetailService = stockCostingDetailService;
//	}

//	public IStockCostingDetailService getStockCostingDetailService() {
//		return stockCostingDetailService;
//	}
}
