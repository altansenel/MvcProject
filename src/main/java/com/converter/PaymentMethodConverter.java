package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IPaymentMethodService;
import com.entity.PaymentMethod;

@ManagedBean(name = "paymentMethodConverter")
@RequestScoped
public class PaymentMethodConverter extends BaseConverter<PaymentMethod> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{paymentMethodService}")
private IPaymentMethodService paymentMethodService;

public void setPaymentMethodService(IPaymentMethodService paymentMethodService) {
this.paymentMethodService =paymentMethodService;setEntityService(paymentMethodService); 
}

public IPaymentMethodService getPaymentMethodService() {
return paymentMethodService;
}
}
