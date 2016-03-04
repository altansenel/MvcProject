package com.controller;import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IEmployeeService;
import com.entity.Employee;

@ViewScoped
@ManagedBean(name = "employeeController")
public class EmployeeController extends BaseController<Employee> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(EmployeeController.class);
@ManagedProperty(value = "#{employeeService}")
private IEmployeeService employeeService;

@Override
public void createEntity() {
Employee employee = new Employee();
setEntity(employee);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Employee>());
}

@Override
public void clean() {
setEntity(new Employee());
getEntityList().clear();
}

@Override
public void setEid(Integer eid) {
setEntity(employeeService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.employeeService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.employeeService.update(getEntity());
setMessage("Employee is successfully updated");
clean();
} else {
this.employeeService.add(getEntity());
setMessage("Employee is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}
}

public void remove(int row) {
try {
this.employeeService.remove(getEntityList().get(row).getId());
setMessage("Employee with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.employeeService.getEntityById(getEntityList().get(row).getId()));
return "employee?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Employee());
return "employee?faces-redirect=true";
}

public IEmployeeService getPersonService() {
return employeeService;
}

public void setEmployeeService(IEmployeeService employeeService) {
this.employeeService = employeeService;
}

}