
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockUnitConverter")
@RequestScoped
public class StockUnitConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockUnitConverter.class);

//	@ManagedProperty(value = "#{stockUnitService}")
//	private IStockUnitService stockUnitService;

//	public void setStockUnitService(IStockUnitService stockUnitService) {
//		this.stockUnitService = stockUnitService;
//	}

//	public IStockUnitService getStockUnitService() {
//		return stockUnitService;
//	}
}
