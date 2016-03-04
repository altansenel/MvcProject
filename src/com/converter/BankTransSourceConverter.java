package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IBankTransSourceService;
import com.entity.BankTransSource;

@ManagedBean(name = "bankTransSourceConverter")
@RequestScoped
public class BankTransSourceConverter extends BaseConverter<BankTransSource> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{bankTransSourceService}")
private IBankTransSourceService bankTransSourceService;

public void setBankTransSourceService(IBankTransSourceService bankTransSourceService) {
this.bankTransSourceService =bankTransSourceService;setEntityService(bankTransSourceService); 
}

public IBankTransSourceService getBankTransSourceService() {
return bankTransSourceService;
}
}
