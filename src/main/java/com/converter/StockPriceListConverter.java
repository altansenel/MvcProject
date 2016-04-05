
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockPriceListService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockPriceListConverter")
@RequestScoped
public class StockPriceListConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockPriceListConverter.class);

	@ManagedProperty(value = "#{stockPriceListService}")
	private IStockPriceListService stockPriceListService;

	public void setStockPriceListService(IStockPriceListService stockPriceListService) {
		this.stockPriceListService = stockPriceListService;
		setEntityService(stockPriceListService);
	}

	public IStockPriceListService getStockPriceListService() {
		return stockPriceListService;
	}
}
