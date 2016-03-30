
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransSourceConverter")
@RequestScoped
public class WaybillTransSourceConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransSourceConverter.class);

//	@ManagedProperty(value = "#{waybillTransSourceService}")
//	private IWaybillTransSourceService waybillTransSourceService;

//	public void setWaybillTransSourceService(IWaybillTransSourceService waybillTransSourceService) {
//		this.waybillTransSourceService = waybillTransSourceService;
//	}

//	public IWaybillTransSourceService getWaybillTransSourceService() {
//		return waybillTransSourceService;
//	}
}
