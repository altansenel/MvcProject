package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import com.dao.IEmployeeService;
import com.entity.Employee;

@ManagedBean(name = "employeeConverter")
@RequestScoped
public class EmployeeConverter extends BaseConverter<Employee> implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{employeeService}")
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
		setEntityService(employeeService);
	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}
}
