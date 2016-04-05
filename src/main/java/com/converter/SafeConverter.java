
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.ISafeService;

import org.apache.log4j.Logger;



@ManagedBean(name = "safeConverter")
@RequestScoped
public class SafeConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SafeConverter.class);

	@ManagedProperty(value = "#{safeService}")
	private ISafeService safeService;

	public void setSafeService(ISafeService safeService) {
		this.safeService = safeService;
		setEntityService(safeService);
	}

	public ISafeService getSafeService() {
		return safeService;
	}
}
