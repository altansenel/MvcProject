
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransTaxService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransTaxConverter")
@RequestScoped
public class InvoiceTransTaxConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransTaxConverter.class);

	@ManagedProperty(value = "#{invoiceTransTaxService}")
	private IInvoiceTransTaxService invoiceTransTaxService;

	public void setInvoiceTransTaxService(IInvoiceTransTaxService invoiceTransTaxService) {
		this.invoiceTransTaxService = invoiceTransTaxService;
		setEntityService(invoiceTransTaxService);
	}

	public IInvoiceTransTaxService getInvoiceTransTaxService() {
		return invoiceTransTaxService;
	}
}
