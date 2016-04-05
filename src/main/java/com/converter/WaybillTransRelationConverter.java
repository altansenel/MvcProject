
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IWaybillTransRelationService;

import org.apache.log4j.Logger;



@ManagedBean(name = "waybillTransRelationConverter")
@RequestScoped
public class WaybillTransRelationConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WaybillTransRelationConverter.class);

	@ManagedProperty(value = "#{waybillTransRelationService}")
	private IWaybillTransRelationService waybillTransRelationService;

	public void setWaybillTransRelationService(IWaybillTransRelationService waybillTransRelationService) {
		this.waybillTransRelationService = waybillTransRelationService;
		setEntityService(waybillTransRelationService);
	}

	public IWaybillTransRelationService getWaybillTransRelationService() {
		return waybillTransRelationService;
	}
}
