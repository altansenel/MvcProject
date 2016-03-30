
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransDetailConverter")
@RequestScoped
public class WaybillTransDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransDetailConverter.class);

//	@ManagedProperty(value = "#{waybillTransDetailService}")
//	private IWaybillTransDetailService waybillTransDetailService;

//	public void setWaybillTransDetailService(IWaybillTransDetailService waybillTransDetailService) {
//		this.waybillTransDetailService = waybillTransDetailService;
//	}

//	public IWaybillTransDetailService getWaybillTransDetailService() {
//		return waybillTransDetailService;
//	}
}
