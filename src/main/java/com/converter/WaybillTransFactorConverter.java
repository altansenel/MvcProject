
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransFactorConverter")
@RequestScoped
public class WaybillTransFactorConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransFactorConverter.class);

//	@ManagedProperty(value = "#{waybillTransFactorService}")
//	private IWaybillTransFactorService waybillTransFactorService;

//	public void setWaybillTransFactorService(IWaybillTransFactorService waybillTransFactorService) {
//		this.waybillTransFactorService = waybillTransFactorService;
//	}

//	public IWaybillTransFactorService getWaybillTransFactorService() {
//		return waybillTransFactorService;
//	}
}
