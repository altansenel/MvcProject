package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IBankExpenseService;
import com.entity.BankExpense;

@ManagedBean(name = "bankExpenseConverter")
@RequestScoped
public class BankExpenseConverter extends BaseConverter<BankExpense> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{bankExpenseService}")
private IBankExpenseService bankExpenseService;

public void setBankExpenseService(IBankExpenseService bankExpenseService) {
this.bankExpenseService =bankExpenseService;setEntityService(bankExpenseService); 
}

public IBankExpenseService getBankExpenseService() {
return bankExpenseService;
}
}
