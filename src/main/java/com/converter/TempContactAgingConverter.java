
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.ITempContactAgingService;

import org.apache.log4j.Logger;



@ManagedBean(name = "tempContactAgingConverter")
@RequestScoped
public class TempContactAgingConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TempContactAgingConverter.class);

	@ManagedProperty(value = "#{tempContactAgingService}")
	private ITempContactAgingService tempContactAgingService;

	public void setTempContactAgingService(ITempContactAgingService tempContactAgingService) {
		this.tempContactAgingService = tempContactAgingService;
		setEntityService(tempContactAgingService);
	}

	public ITempContactAgingService getTempContactAgingService() {
		return tempContactAgingService;
	}
}
