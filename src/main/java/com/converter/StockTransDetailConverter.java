
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockTransDetailService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockTransDetailConverter")
@RequestScoped
public class StockTransDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockTransDetailConverter.class);

	@ManagedProperty(value = "#{stockTransDetailService}")
	private IStockTransDetailService stockTransDetailService;

	public void setStockTransDetailService(IStockTransDetailService stockTransDetailService) {
		this.stockTransDetailService = stockTransDetailService;
		setEntityService(stockTransDetailService);
	}

	public IStockTransDetailService getStockTransDetailService() {
		return stockTransDetailService;
	}
}
