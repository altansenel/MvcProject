
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "bankConverter")
@RequestScoped
public class BankConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BankConverter.class);

//	@ManagedProperty(value = "#{bankService}")
//	private IBankService bankService;

//	public void setBankService(IBankService bankService) {
//		this.bankService = bankService;
//	}

//	public IBankService getBankService() {
//		return bankService;
//	}
}
