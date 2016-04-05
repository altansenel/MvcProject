
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IBankTransSourceService;

import org.apache.log4j.Logger;



@ManagedBean(name = "bankTransSourceConverter")
@RequestScoped
public class BankTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BankTransSourceConverter.class);

	@ManagedProperty(value = "#{bankTransSourceService}")
	private IBankTransSourceService bankTransSourceService;

	public void setBankTransSourceService(IBankTransSourceService bankTransSourceService) {
		this.bankTransSourceService = bankTransSourceService;
		setEntityService(bankTransSourceService);
	}

	public IBankTransSourceService getBankTransSourceService() {
		return bankTransSourceService;
	}
}
