package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IAlisverisService;
import com.entity.Alisveris;

@ManagedBean(name = "alisverisConverter")
@RequestScoped
public class AlisverisConverter extends BaseConverter<Alisveris> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{alisverisService}")
private IAlisverisService alisverisService;

public void setAlisverisService(IAlisverisService alisverisService) {
this.alisverisService =alisverisService;setEntityService(alisverisService); 
}

public IAlisverisService getAlisverisService() {
return alisverisService;
}
}
