package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IPaymentService;
import com.entity.Payment;

@ManagedBean(name = "paymentConverter")
@RequestScoped
public class PaymentConverter extends BaseConverter<Payment> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{paymentService}")
private IPaymentService paymentService;

public void setPaymentService(IPaymentService paymentService) {
this.paymentService =paymentService;setEntityService(paymentService); 
}

public IPaymentService getPaymentService() {
return paymentService;
}
}
