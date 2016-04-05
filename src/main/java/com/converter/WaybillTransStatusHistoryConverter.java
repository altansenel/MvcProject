
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IWaybillTransStatusHistoryService;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransStatusHistoryConverter")
@RequestScoped
public class WaybillTransStatusHistoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransStatusHistoryConverter.class);

	@ManagedProperty(value = "#{waybillTransStatusHistoryService}")
	private IWaybillTransStatusHistoryService waybillTransStatusHistoryService;

	public void setWaybillTransStatusHistoryService(IWaybillTransStatusHistoryService waybillTransStatusHistoryService) {
		this.waybillTransStatusHistoryService = waybillTransStatusHistoryService;
		setEntityService(waybillTransStatusHistoryService);
	}

	public IWaybillTransStatusHistoryService getWaybillTransStatusHistoryService() {
		return waybillTransStatusHistoryService;
	}
}
