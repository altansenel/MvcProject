
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.IChqbllTypeService;

import org.apache.log4j.Logger;



@ManagedBean(name = "chqbllTypeConverter")
@RequestScoped
public class ChqbllTypeConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChqbllTypeConverter.class);

	@ManagedProperty(value = "#{chqbllTypeService}")
	private IChqbllTypeService chqbllTypeService;

	public void setChqbllTypeService(IChqbllTypeService chqbllTypeService) {
		this.chqbllTypeService = chqbllTypeService;
		setEntityService(chqbllTypeService);
	}

	public IChqbllTypeService getChqbllTypeService() {
		return chqbllTypeService;
	}
}
