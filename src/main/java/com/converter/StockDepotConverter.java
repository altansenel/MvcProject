
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockDepotConverter")
@RequestScoped
public class StockDepotConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockDepotConverter.class);

//	@ManagedProperty(value = "#{stockDepotService}")
//	private IStockDepotService stockDepotService;

//	public void setStockDepotService(IStockDepotService stockDepotService) {
//		this.stockDepotService = stockDepotService;
//	}

//	public IStockDepotService getStockDepotService() {
//		return stockDepotService;
//	}
}
