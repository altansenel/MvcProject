package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IPaymentService;
import com.entity.Payment;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "paymentController")
public class PaymentController extends BaseController<Payment> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(PaymentController.class);
@ManagedProperty(value = "#{paymentService}")
private IPaymentService paymentService;

@Override
public void createEntity() {
Payment payment = new Payment();
setEntity(payment);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Payment>());
}

@Override
public void clean() {
setEntity(new Payment());
getEntityList().clear();
}

@Override
public void setEid(Long eid) {
setEntity(paymentService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.paymentService.list(getEntity()));
}

public void save(Long id) {
try {
if (id != null) {
this.paymentService.update(getEntity());
setMessage("Payment is successfully updated");
clean();
} else {
this.paymentService.add(getEntity());
setMessage("Payment is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}

public void remove(int row) {
try {
this.paymentService.remove(getEntityList().get(row).getId());
setMessage("Payment with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.paymentService.getEntityById(getEntityList().get(row).getId()));
return "payment?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Payment());
return "payment?faces-redirect=true";
}

public IPaymentService getPersonService() {
return paymentService;
}

public void setPaymentService(IPaymentService paymentService) {
this.paymentService = paymentService;
}

public String addOrder(String pageName) {
DataBean dataBean = new DataBean();
dataBean.setObj(getEntity());
dataBean.setName(getEntity().getClass().getName());
FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", dataBean);
return "orderList?faces-redirect=true&from=" + pageName +"&relationType=" + RelationType.manyToOne.ordinal();
}

public String addPaymentMethod(String pageName) {
DataBean dataBean = new DataBean();
dataBean.setObj(getEntity());
dataBean.setName(getEntity().getClass().getName());
FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", dataBean);
return "paymentMethodList?faces-redirect=true&from=" + pageName +"&relationType=" + RelationType.manyToOne.ordinal();
}

}