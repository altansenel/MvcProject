
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IChqbllPayrollDetailService;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllPayrollDetailConverter")
@RequestScoped
public class ChqbllPayrollDetailConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllPayrollDetailConverter.class);

	@ManagedProperty(value = "#{chqbllPayrollDetailService}")
	private IChqbllPayrollDetailService chqbllPayrollDetailService;

	public void setChqbllPayrollDetailService(IChqbllPayrollDetailService chqbllPayrollDetailService) {
		this.chqbllPayrollDetailService = chqbllPayrollDetailService;
		setEntityService(chqbllPayrollDetailService);
	}

	public IChqbllPayrollDetailService getChqbllPayrollDetailService() {
		return chqbllPayrollDetailService;
	}
}
