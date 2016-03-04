package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IOrderService;
import com.entity.Order;

@ManagedBean(name = "orderConverter")
@RequestScoped
public class OrderConverter extends BaseConverter<Order> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{orderService}")
private IOrderService orderService;

public void setOrderService(IOrderService orderService) {
this.orderService =orderService;setEntityService(orderService); 
}

public IOrderService getOrderService() {
return orderService;
}
}
