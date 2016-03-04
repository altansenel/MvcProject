package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IDolapService;
import com.entity.Dolap;
import com.enums.ProjectEnum.RelationType;
import com.enums.ProjectEnum.AddSelect;

@ViewScoped
@ManagedBean(name = "dolapController")
public class DolapController extends BaseController<Dolap> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(DolapController.class);
@ManagedProperty(value = "#{dolapService}")
private IDolapService dolapService;

@Override
public void createEntity() {
Dolap dolap = new Dolap();
setEntity(dolap);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Dolap>());
}

@Override
public void clean() {
setEntity(new Dolap());
getEntityList().clear();
setDataBean(null);
}

@Override
public void setEid(Long eid) {
setEntity(dolapService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.dolapService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.dolapService.update(getEntity());
setMessage("Dolap is successfully updated");
clean();
} else {
this.dolapService.add(getEntity());
setMessage("Dolap is successfully created");
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
this.dolapService.remove(getEntityList().get(row).getId());
setMessage("Dolap with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.dolapService.getEntityById(getEntityList().get(row).getId()));
return "dolap?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Dolap());
return "dolap?faces-redirect=true";
}

public IDolapService getPersonService() {
return dolapService;
}

public void setDolapService(IDolapService dolapService) {
this.dolapService = dolapService;
}

}