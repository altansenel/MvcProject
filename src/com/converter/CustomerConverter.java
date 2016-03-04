package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.ICustomerService;
import com.entity.Customer;

@ManagedBean(name = "customerConverter")
@RequestScoped
public class CustomerConverter extends BaseConverter<Customer> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{customerService}")
private ICustomerService customerService;

public void setCustomerService(ICustomerService customerService) {
this.customerService =customerService;setEntityService(customerService); 
}

public ICustomerService getCustomerService() {
return customerService;
}
}
