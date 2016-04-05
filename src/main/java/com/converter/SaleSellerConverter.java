
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.ISaleSellerService;

import org.apache.log4j.Logger;



@ManagedBean(name = "saleSellerConverter")
@RequestScoped
public class SaleSellerConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SaleSellerConverter.class);

	@ManagedProperty(value = "#{saleSellerService}")
	private ISaleSellerService saleSellerService;

	public void setSaleSellerService(ISaleSellerService saleSellerService) {
		this.saleSellerService = saleSellerService;
		setEntityService(saleSellerService);
	}

	public ISaleSellerService getSaleSellerService() {
		return saleSellerService;
	}
}
