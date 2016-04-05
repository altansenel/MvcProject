
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransConverter")
@RequestScoped
public class InvoiceTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransConverter.class);

	@ManagedProperty(value = "#{invoiceTransService}")
	private IInvoiceTransService invoiceTransService;

	public void setInvoiceTransService(IInvoiceTransService invoiceTransService) {
		this.invoiceTransService = invoiceTransService;
		setEntityService(invoiceTransService);
	}

	public IInvoiceTransService getInvoiceTransService() {
		return invoiceTransService;
	}
}
