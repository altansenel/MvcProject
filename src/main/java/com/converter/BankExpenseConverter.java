
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IBankExpenseService;

import org.apache.log4j.Logger;



@ManagedBean(name = "bankExpenseConverter")
@RequestScoped
public class BankExpenseConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BankExpenseConverter.class);

	@ManagedProperty(value = "#{bankExpenseService}")
	private IBankExpenseService bankExpenseService;

	public void setBankExpenseService(IBankExpenseService bankExpenseService) {
		this.bankExpenseService = bankExpenseService;
		setEntityService(bankExpenseService);
	}

	public IBankExpenseService getBankExpenseService() {
		return bankExpenseService;
	}
}
