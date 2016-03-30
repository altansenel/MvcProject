
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalProfileConverter")
@RequestScoped
public class GlobalProfileConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalProfileConverter.class);

//	@ManagedProperty(value = "#{globalProfileService}")
//	private IGlobalProfileService globalProfileService;

//	public void setGlobalProfileService(IGlobalProfileService globalProfileService) {
//		this.globalProfileService = globalProfileService;
//	}

//	public IGlobalProfileService getGlobalProfileService() {
//		return globalProfileService;
//	}
}
