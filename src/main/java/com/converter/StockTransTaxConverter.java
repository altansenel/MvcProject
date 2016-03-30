
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransTaxConverter")
@RequestScoped
public class StockTransTaxConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransTaxConverter.class);

//	@ManagedProperty(value = "#{stockTransTaxService}")
//	private IStockTransTaxService stockTransTaxService;

//	public void setStockTransTaxService(IStockTransTaxService stockTransTaxService) {
//		this.stockTransTaxService = stockTransTaxService;
//	}

//	public IStockTransTaxService getStockTransTaxService() {
//		return stockTransTaxService;
//	}
}
