
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IWaybillTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransConverter")
@RequestScoped
public class WaybillTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransConverter.class);

	@ManagedProperty(value = "#{waybillTransService}")
	private IWaybillTransService waybillTransService;

	public void setWaybillTransService(IWaybillTransService waybillTransService) {
		this.waybillTransService = waybillTransService;
		setEntityService(waybillTransService);
	}

	public IWaybillTransService getWaybillTransService() {
		return waybillTransService;
	}
}
