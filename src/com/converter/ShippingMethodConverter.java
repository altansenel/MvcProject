package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IShippingMethodService;
import com.entity.ShippingMethod;

@ManagedBean(name = "shippingMethodConverter")
@RequestScoped
public class ShippingMethodConverter extends BaseConverter<ShippingMethod> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{shippingMethodService}")
private IShippingMethodService shippingMethodService;

public void setShippingMethodService(IShippingMethodService shippingMethodService) {
this.shippingMethodService =shippingMethodService;setEntityService(shippingMethodService); 
}

public IShippingMethodService getShippingMethodService() {
return shippingMethodService;
}
}
