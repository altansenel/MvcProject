
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllDetailHistoryConverter")
@RequestScoped
public class ChqbllDetailHistoryConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllDetailHistoryConverter.class);

//	@ManagedProperty(value = "#{chqbllDetailHistoryService}")
//	private IChqbllDetailHistoryService chqbllDetailHistoryService;

//	public void setChqbllDetailHistoryService(IChqbllDetailHistoryService chqbllDetailHistoryService) {
//		this.chqbllDetailHistoryService = chqbllDetailHistoryService;
//	}

//	public IChqbllDetailHistoryService getChqbllDetailHistoryService() {
//		return chqbllDetailHistoryService;
//	}
}
