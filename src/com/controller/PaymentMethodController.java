package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IPaymentMethodService;
import com.entity.PaymentMethod;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "paymentMethodController")
public class PaymentMethodController extends BaseController<PaymentMethod> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(PaymentMethodController.class);
@ManagedProperty(value = "#{paymentMethodService}")
private IPaymentMethodService paymentMethodService;

@Override
public void createEntity() {
PaymentMethod paymentMethod = new PaymentMethod();
setEntity(paymentMethod);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<PaymentMethod>());
}

@Override
public void clean() {
setEntity(new PaymentMethod());
getEntityList().clear();
}

@Override
public void setEid(Long eid) {
setEntity(paymentMethodService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.paymentMethodService.list(getEntity()));
}

public void save(Long id) {
try {
if (id != null) {
this.paymentMethodService.update(getEntity());
setMessage("PaymentMethod is successfully updated");
clean();
} else {
this.paymentMethodService.add(getEntity());
setMessage("PaymentMethod is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}

public void remove(int row) {
try {
this.paymentMethodService.remove(getEntityList().get(row).getId());
setMessage("PaymentMethod with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.paymentMethodService.getEntityById(getEntityList().get(row).getId()));
return "paymentMethod?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new PaymentMethod());
return "paymentMethod?faces-redirect=true";
}

public IPaymentMethodService getPersonService() {
return paymentMethodService;
}

public void setPaymentMethodService(IPaymentMethodService paymentMethodService) {
this.paymentMethodService = paymentMethodService;
}

}