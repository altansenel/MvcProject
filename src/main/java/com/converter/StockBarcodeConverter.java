
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IStockBarcodeService;

import org.apache.log4j.Logger;



@ManagedBean(name = "stockBarcodeConverter")
@RequestScoped
public class StockBarcodeConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StockBarcodeConverter.class);

	@ManagedProperty(value = "#{stockBarcodeService}")
	private IStockBarcodeService stockBarcodeService;

	public void setStockBarcodeService(IStockBarcodeService stockBarcodeService) {
		this.stockBarcodeService = stockBarcodeService;
		setEntityService(stockBarcodeService);
	}

	public IStockBarcodeService getStockBarcodeService() {
		return stockBarcodeService;
	}
}
