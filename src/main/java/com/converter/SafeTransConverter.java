
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "safeTransConverter")
@RequestScoped
public class SafeTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SafeTransConverter.class);

//	@ManagedProperty(value = "#{safeTransService}")
//	private ISafeTransService safeTransService;

//	public void setSafeTransService(ISafeTransService safeTransService) {
//		this.safeTransService = safeTransService;
//	}

//	public ISafeTransService getSafeTransService() {
//		return safeTransService;
//	}
}
