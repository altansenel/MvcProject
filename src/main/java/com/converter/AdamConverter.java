package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import com.dao.IAdamService;

@ManagedBean(name = "adamConverter")
@RequestScoped
public class AdamConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdamConverter.class);

	@ManagedProperty(value = "#{adamService}")
	private IAdamService adamService;

	public void setAdamService(IAdamService adamService) {
		this.adamService = adamService;
	}

	public IAdamService getAdamService() {
		return adamService;
	}
}
