package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IOrderDetailService;
import com.entity.OrderDetail;

@ManagedBean(name = "orderDetailConverter")
@RequestScoped
public class OrderDetailConverter extends BaseConverter<OrderDetail> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{orderDetailService}")
private IOrderDetailService orderDetailService;

public void setOrderDetailService(IOrderDetailService orderDetailService) {
this.orderDetailService =orderDetailService;setEntityService(orderDetailService); 
}

public IOrderDetailService getOrderDetailService() {
return orderDetailService;
}
}
