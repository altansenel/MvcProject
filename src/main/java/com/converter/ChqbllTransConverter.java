
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IChqbllTransService;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllTransConverter")
@RequestScoped
public class ChqbllTransConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllTransConverter.class);

	@ManagedProperty(value = "#{chqbllTransService}")
	private IChqbllTransService chqbllTransService;

	public void setChqbllTransService(IChqbllTransService chqbllTransService) {
		this.chqbllTransService = chqbllTransService;
		setEntityService(chqbllTransService);
	}

	public IChqbllTransService getChqbllTransService() {
		return chqbllTransService;
	}
}
