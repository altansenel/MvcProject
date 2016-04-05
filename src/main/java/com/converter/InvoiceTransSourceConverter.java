
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransSourceService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransSourceConverter")
@RequestScoped
public class InvoiceTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransSourceConverter.class);

	@ManagedProperty(value = "#{invoiceTransSourceService}")
	private IInvoiceTransSourceService invoiceTransSourceService;

	public void setInvoiceTransSourceService(IInvoiceTransSourceService invoiceTransSourceService) {
		this.invoiceTransSourceService = invoiceTransSourceService;
		setEntityService(invoiceTransSourceService);
	}

	public IInvoiceTransSourceService getInvoiceTransSourceService() {
		return invoiceTransSourceService;
	}
}
