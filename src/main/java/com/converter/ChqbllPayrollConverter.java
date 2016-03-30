
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllPayrollConverter")
@RequestScoped
public class ChqbllPayrollConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllPayrollConverter.class);

//	@ManagedProperty(value = "#{chqbllPayrollService}")
//	private IChqbllPayrollService chqbllPayrollService;

//	public void setChqbllPayrollService(IChqbllPayrollService chqbllPayrollService) {
//		this.chqbllPayrollService = chqbllPayrollService;
//	}

//	public IChqbllPayrollService getChqbllPayrollService() {
//		return chqbllPayrollService;
//	}
}
