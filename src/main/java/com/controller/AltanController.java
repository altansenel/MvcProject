package com.controller;import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.dao.IAltanService;
import com.entity.Altan;

@ViewScoped
@ManagedBean(name = "altanController")
public class AltanController extends BaseController<Altan> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(AltanController.class);
@ManagedProperty(value = "#{altanService}")
private IAltanService altanService;

@Override
public void createEntity() {
Altan altan = new Altan();
setEntity(altan);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Altan>());
}

@Override
public void clean() {
setEntity(new Altan());
getEntityList().clear();
}

@Override
public void setEid(Integer eid) {
setEntity(altanService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.altanService.list(getEntity()));
}

public void save(Long id) {
try {
if (id != null) {
this.altanService.update(getEntity());
setMessage("Altan is successfully updated");
clean();
} else {
this.altanService.add(getEntity());
setMessage("Altan is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}

public void remove(int row) {
try {
this.altanService.remove(getEntityList().get(row).getId());
setMessage("Altan with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.altanService.getEntityById(getEntityList().get(row).getId()));
return "altan?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Altan());
return "altan?faces-redirect=true";
}

public IAltanService getPersonService() {
return altanService;
}

public void setAltanService(IAltanService altanService) {
this.altanService = altanService;
}

}