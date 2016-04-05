
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransConverter")
@RequestScoped
public class StockTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransConverter.class);

	@ManagedProperty(value = "#{stockTransService}")
	private IStockTransService stockTransService;

	public void setStockTransService(IStockTransService stockTransService) {
		this.stockTransService = stockTransService;
		setEntityService(stockTransService);
	}

	public IStockTransService getStockTransService() {
		return stockTransService;
	}
}
