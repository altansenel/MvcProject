
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IGlobalCurrencyService;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalCurrencyConverter")
@RequestScoped
public class GlobalCurrencyConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalCurrencyConverter.class);

	@ManagedProperty(value = "#{globalCurrencyService}")
	private IGlobalCurrencyService globalCurrencyService;

	public void setGlobalCurrencyService(IGlobalCurrencyService globalCurrencyService) {
		this.globalCurrencyService = globalCurrencyService;
		setEntityService(globalCurrencyService);
	}

	public IGlobalCurrencyService getGlobalCurrencyService() {
		return globalCurrencyService;
	}
}
