package com.controller;import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IBankExpenseService;
import com.entity.BankExpense;

@ViewScoped
@ManagedBean(name = "bankExpenseController")
public class BankExpenseController extends BaseController<BankExpense> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(BankExpenseController.class);
@ManagedProperty(value = "#{bankExpenseService}")
private IBankExpenseService bankExpenseService;

@Override
public void createEntity() {
BankExpense bankExpense = new BankExpense();
setEntity(bankExpense);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<BankExpense>());
}

@Override
public void clean() {
setEntity(new BankExpense());
getEntityList().clear();
setDataBean(null);
}

@Override
public void setEid(Integer eid) {
setEntity(bankExpenseService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.bankExpenseService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.bankExpenseService.update(getEntity());
setMessage("BankExpense is successfully updated");
clean();
} else {
this.bankExpenseService.add(getEntity());
setMessage("BankExpense is successfully created");
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
this.bankExpenseService.remove(getEntityList().get(row).getId());
setMessage("BankExpense with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.bankExpenseService.getEntityById(getEntityList().get(row).getId()));
return "bankExpense?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new BankExpense());
return "bankExpense?faces-redirect=true";
}

public IBankExpenseService getPersonService() {
return bankExpenseService;
}

public void setBankExpenseService(IBankExpenseService bankExpenseService) {
this.bankExpenseService = bankExpenseService;
}

}