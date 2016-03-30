
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalCurrencyRateConverter")
@RequestScoped
public class GlobalCurrencyRateConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalCurrencyRateConverter.class);

//	@ManagedProperty(value = "#{globalCurrencyRateService}")
//	private IGlobalCurrencyRateService globalCurrencyRateService;

//	public void setGlobalCurrencyRateService(IGlobalCurrencyRateService globalCurrencyRateService) {
//		this.globalCurrencyRateService = globalCurrencyRateService;
//	}

//	public IGlobalCurrencyRateService getGlobalCurrencyRateService() {
//		return globalCurrencyRateService;
//	}
}
