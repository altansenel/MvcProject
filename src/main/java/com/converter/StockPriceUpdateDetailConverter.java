
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockPriceUpdateDetailService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockPriceUpdateDetailConverter")
@RequestScoped
public class StockPriceUpdateDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockPriceUpdateDetailConverter.class);

	@ManagedProperty(value = "#{stockPriceUpdateDetailService}")
	private IStockPriceUpdateDetailService stockPriceUpdateDetailService;

	public void setStockPriceUpdateDetailService(IStockPriceUpdateDetailService stockPriceUpdateDetailService) {
		this.stockPriceUpdateDetailService = stockPriceUpdateDetailService;
		setEntityService(stockPriceUpdateDetailService);
	}

	public IStockPriceUpdateDetailService getStockPriceUpdateDetailService() {
		return stockPriceUpdateDetailService;
	}
}
