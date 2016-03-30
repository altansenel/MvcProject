
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalCurrencyRateDetailConverter")
@RequestScoped
public class GlobalCurrencyRateDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalCurrencyRateDetailConverter.class);

//	@ManagedProperty(value = "#{globalCurrencyRateDetailService}")
//	private IGlobalCurrencyRateDetailService globalCurrencyRateDetailService;

//	public void setGlobalCurrencyRateDetailService(IGlobalCurrencyRateDetailService globalCurrencyRateDetailService) {
//		this.globalCurrencyRateDetailService = globalCurrencyRateDetailService;
//	}

//	public IGlobalCurrencyRateDetailService getGlobalCurrencyRateDetailService() {
//		return globalCurrencyRateDetailService;
//	}
}
