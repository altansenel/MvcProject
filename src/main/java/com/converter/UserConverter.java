package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import com.dao.IUserService;

@ManagedBean(name = "userConverter")
@RequestScoped
public class UserConverter extends BaseConverter implements Converter,
		Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserConverter.class);

	@ManagedProperty(value = "#{userService}")
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserService getUserService() {
		return userService;
	}
}
