
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllDetailPartialConverter")
@RequestScoped
public class ChqbllDetailPartialConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllDetailPartialConverter.class);

//	@ManagedProperty(value = "#{chqbllDetailPartialService}")
//	private IChqbllDetailPartialService chqbllDetailPartialService;

//	public void setChqbllDetailPartialService(IChqbllDetailPartialService chqbllDetailPartialService) {
//		this.chqbllDetailPartialService = chqbllDetailPartialService;
//	}

//	public IChqbllDetailPartialService getChqbllDetailPartialService() {
//		return chqbllDetailPartialService;
//	}
}
