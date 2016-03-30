
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransDetailConverter")
@RequestScoped
public class InvoiceTransDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransDetailConverter.class);

//	@ManagedProperty(value = "#{invoiceTransDetailService}")
//	private IInvoiceTransDetailService invoiceTransDetailService;

//	public void setInvoiceTransDetailService(IInvoiceTransDetailService invoiceTransDetailService) {
//		this.invoiceTransDetailService = invoiceTransDetailService;
//	}

//	public IInvoiceTransDetailService getInvoiceTransDetailService() {
//		return invoiceTransDetailService;
//	}
}
