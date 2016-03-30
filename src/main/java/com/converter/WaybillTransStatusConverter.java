
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransStatusConverter")
@RequestScoped
public class WaybillTransStatusConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransStatusConverter.class);

//	@ManagedProperty(value = "#{waybillTransStatusService}")
//	private IWaybillTransStatusService waybillTransStatusService;

//	public void setWaybillTransStatusService(IWaybillTransStatusService waybillTransStatusService) {
//		this.waybillTransStatusService = waybillTransStatusService;
//	}

//	public IWaybillTransStatusService getWaybillTransStatusService() {
//		return waybillTransStatusService;
//	}
}
