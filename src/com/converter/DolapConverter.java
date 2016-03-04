package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IDolapService;
import com.entity.Dolap;

@ManagedBean(name = "dolapConverter")
@RequestScoped
public class DolapConverter extends BaseConverter<Dolap> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{dolapService}")
private IDolapService dolapService;

public void setDolapService(IDolapService dolapService) {
this.dolapService =dolapService;setEntityService(dolapService); 
}

public IDolapService getDolapService() {
return dolapService;
}
}
