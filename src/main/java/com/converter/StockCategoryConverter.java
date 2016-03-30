
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockCategoryConverter")
@RequestScoped
public class StockCategoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockCategoryConverter.class);

//	@ManagedProperty(value = "#{stockCategoryService}")
//	private IStockCategoryService stockCategoryService;

//	public void setStockCategoryService(IStockCategoryService stockCategoryService) {
//		this.stockCategoryService = stockCategoryService;
//	}

//	public IStockCategoryService getStockCategoryService() {
//		return stockCategoryService;
//	}
}
