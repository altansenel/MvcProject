
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockConverter")
@RequestScoped
public class StockConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockConverter.class);

	@ManagedProperty(value = "#{stockService}")
	private IStockService stockService;

	public void setStockService(IStockService stockService) {
		this.stockService = stockService;
		setEntityService(stockService);
	}

	public IStockService getStockService() {
		return stockService;
	}
}
