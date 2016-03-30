
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "globalTransPointConverter")
@RequestScoped
public class GlobalTransPointConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GlobalTransPointConverter.class);

//	@ManagedProperty(value = "#{globalTransPointService}")
//	private IGlobalTransPointService globalTransPointService;

//	public void setGlobalTransPointService(IGlobalTransPointService globalTransPointService) {
//		this.globalTransPointService = globalTransPointService;
//	}

//	public IGlobalTransPointService getGlobalTransPointService() {
//		return globalTransPointService;
//	}
}
