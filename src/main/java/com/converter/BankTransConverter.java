
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IBankTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "bankTransConverter")
@RequestScoped
public class BankTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BankTransConverter.class);

	@ManagedProperty(value = "#{bankTransService}")
	private IBankTransService bankTransService;

	public void setBankTransService(IBankTransService bankTransService) {
		this.bankTransService = bankTransService;
		setEntityService(bankTransService);
	}

	public IBankTransService getBankTransService() {
		return bankTransService;
	}
}
