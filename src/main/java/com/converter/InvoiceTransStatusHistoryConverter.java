
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransStatusHistoryConverter")
@RequestScoped
public class InvoiceTransStatusHistoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransStatusHistoryConverter.class);

//	@ManagedProperty(value = "#{invoiceTransStatusHistoryService}")
//	private IInvoiceTransStatusHistoryService invoiceTransStatusHistoryService;

//	public void setInvoiceTransStatusHistoryService(IInvoiceTransStatusHistoryService invoiceTransStatusHistoryService) {
//		this.invoiceTransStatusHistoryService = invoiceTransStatusHistoryService;
//	}

//	public IInvoiceTransStatusHistoryService getInvoiceTransStatusHistoryService() {
//		return invoiceTransStatusHistoryService;
//	}
}
