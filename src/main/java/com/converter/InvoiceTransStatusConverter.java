
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransStatusService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransStatusConverter")
@RequestScoped
public class InvoiceTransStatusConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransStatusConverter.class);

	@ManagedProperty(value = "#{invoiceTransStatusService}")
	private IInvoiceTransStatusService invoiceTransStatusService;

	public void setInvoiceTransStatusService(IInvoiceTransStatusService invoiceTransStatusService) {
		this.invoiceTransStatusService = invoiceTransStatusService;
		setEntityService(invoiceTransStatusService);
	}

	public IInvoiceTransStatusService getInvoiceTransStatusService() {
		return invoiceTransStatusService;
	}
}
