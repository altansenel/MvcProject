package com.controller;import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISinifService;
import com.entity.Sinif;

@ViewScoped
@ManagedBean(name = "sinifController")
public class SinifController extends BaseController<Sinif> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(SinifController.class);
@ManagedProperty(value = "#{sinifService}")
private ISinifService sinifService;

@Override
public void createEntity() {
Sinif sinif = new Sinif();
setEntity(sinif);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Sinif>());
}

@Override
public void clean() {
setEntity(new Sinif());
getEntityList().clear();
setDataBean(null);
}

@Override
public void setEid(Integer eid) {
setEntity(sinifService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.sinifService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.sinifService.update(getEntity());
setMessage("Sinif is successfully updated");
clean();
} else {
this.sinifService.add(getEntity());
setMessage("Sinif is successfully created");
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
this.sinifService.remove(getEntityList().get(row).getId());
setMessage("Sinif with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.sinifService.getEntityById(getEntityList().get(row).getId()));
return "sinif?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Sinif());
return "sinif?faces-redirect=true";
}

public ISinifService getPersonService() {
return sinifService;
}

public void setSinifService(ISinifService sinifService) {
this.sinifService = sinifService;
}

}