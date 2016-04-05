
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransCurrencyService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransCurrencyConverter")
@RequestScoped
public class InvoiceTransCurrencyConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransCurrencyConverter.class);

	@ManagedProperty(value = "#{invoiceTransCurrencyService}")
	private IInvoiceTransCurrencyService invoiceTransCurrencyService;

	public void setInvoiceTransCurrencyService(IInvoiceTransCurrencyService invoiceTransCurrencyService) {
		this.invoiceTransCurrencyService = invoiceTransCurrencyService;
		setEntityService(invoiceTransCurrencyService);
	}

	public IInvoiceTransCurrencyService getInvoiceTransCurrencyService() {
		return invoiceTransCurrencyService;
	}
}
