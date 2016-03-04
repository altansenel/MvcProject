package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IBankService;
import com.entity.Bank;

@ManagedBean(name = "bankConverter")
@RequestScoped
public class BankConverter extends BaseConverter<Bank> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{bankService}")
private IBankService bankService;

public void setBankService(IBankService bankService) {
this.bankService =bankService;setEntityService(bankService); 
}

public IBankService getBankService() {
return bankService;
}
}
