
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockTransCurrencyService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransCurrencyConverter")
@RequestScoped
public class StockTransCurrencyConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransCurrencyConverter.class);

	@ManagedProperty(value = "#{stockTransCurrencyService}")
	private IStockTransCurrencyService stockTransCurrencyService;

	public void setStockTransCurrencyService(IStockTransCurrencyService stockTransCurrencyService) {
		this.stockTransCurrencyService = stockTransCurrencyService;
		setEntityService(stockTransCurrencyService);
	}

	public IStockTransCurrencyService getStockTransCurrencyService() {
		return stockTransCurrencyService;
	}
}
