
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalPrivateCodeConverter")
@RequestScoped
public class GlobalPrivateCodeConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalPrivateCodeConverter.class);

//	@ManagedProperty(value = "#{globalPrivateCodeService}")
//	private IGlobalPrivateCodeService globalPrivateCodeService;

//	public void setGlobalPrivateCodeService(IGlobalPrivateCodeService globalPrivateCodeService) {
//		this.globalPrivateCodeService = globalPrivateCodeService;
//	}

//	public IGlobalPrivateCodeService getGlobalPrivateCodeService() {
//		return globalPrivateCodeService;
//	}
}
