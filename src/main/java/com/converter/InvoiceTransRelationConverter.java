
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IInvoiceTransRelationService;

import org.apache.log4j.Logger;



@ManagedBean(name = "invoiceTransRelationConverter")
@RequestScoped
public class InvoiceTransRelationConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InvoiceTransRelationConverter.class);

	@ManagedProperty(value = "#{invoiceTransRelationService}")
	private IInvoiceTransRelationService invoiceTransRelationService;

	public void setInvoiceTransRelationService(IInvoiceTransRelationService invoiceTransRelationService) {
		this.invoiceTransRelationService = invoiceTransRelationService;
		setEntityService(invoiceTransRelationService);
	}

	public IInvoiceTransRelationService getInvoiceTransRelationService() {
		return invoiceTransRelationService;
	}
}
