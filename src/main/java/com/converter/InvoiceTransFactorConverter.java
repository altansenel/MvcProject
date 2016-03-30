
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransFactorConverter")
@RequestScoped
public class InvoiceTransFactorConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransFactorConverter.class);

//	@ManagedProperty(value = "#{invoiceTransFactorService}")
//	private IInvoiceTransFactorService invoiceTransFactorService;

//	public void setInvoiceTransFactorService(IInvoiceTransFactorService invoiceTransFactorService) {
//		this.invoiceTransFactorService = invoiceTransFactorService;
//	}

//	public IInvoiceTransFactorService getInvoiceTransFactorService() {
//		return invoiceTransFactorService;
//	}
}
