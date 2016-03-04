package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IShippingMethodService;
import com.entity.ShippingMethod;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "shippingMethodController")
public class ShippingMethodController extends BaseController<ShippingMethod> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(ShippingMethodController.class);
@ManagedProperty(value = "#{shippingMethodService}")
private IShippingMethodService shippingMethodService;

@Override
public void createEntity() {
ShippingMethod shippingMethod = new ShippingMethod();
setEntity(shippingMethod);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<ShippingMethod>());
}

@Override
public void clean() {
setEntity(new ShippingMethod());
getEntityList().clear();
}

@Override
public void setEid(Long eid) {
setEntity(shippingMethodService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.shippingMethodService.list(getEntity()));
}

public void save(Long id) {
try {
if (id != null) {
this.shippingMethodService.update(getEntity());
setMessage("ShippingMethod is successfully updated");
clean();
} else {
this.shippingMethodService.add(getEntity());
setMessage("ShippingMethod is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}

public void remove(int row) {
try {
this.shippingMethodService.remove(getEntityList().get(row).getId());
setMessage("ShippingMethod with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.shippingMethodService.getEntityById(getEntityList().get(row).getId()));
return "shippingMethod?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new ShippingMethod());
return "shippingMethod?faces-redirect=true";
}

public IShippingMethodService getPersonService() {
return shippingMethodService;
}

public void setShippingMethodService(IShippingMethodService shippingMethodService) {
this.shippingMethodService = shippingMethodService;
}

}