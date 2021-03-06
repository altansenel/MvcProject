
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockPriceUpdateService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockPriceUpdateConverter")
@RequestScoped
public class StockPriceUpdateConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockPriceUpdateConverter.class);

	@ManagedProperty(value = "#{stockPriceUpdateService}")
	private IStockPriceUpdateService stockPriceUpdateService;

	public void setStockPriceUpdateService(IStockPriceUpdateService stockPriceUpdateService) {
		this.stockPriceUpdateService = stockPriceUpdateService;
		setEntityService(stockPriceUpdateService);
	}

	public IStockPriceUpdateService getStockPriceUpdateService() {
		return stockPriceUpdateService;
	}
}
