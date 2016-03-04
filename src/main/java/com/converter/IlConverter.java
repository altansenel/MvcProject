package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IIlService;
import com.entity.Il;

@ManagedBean(name = "ilConverter")
@RequestScoped
public class IlConverter extends BaseConverter implements Converter, Serializable {

private static final long serialVersionUID = 1L;
private static final Logger logger =Logger.getLogger(IlConverter.class);

@ManagedProperty(value = "#{ilService}")
private IIlService ilService;

public void setIlService(IIlService ilService) {
this.ilService =ilService;
}

public IIlService getIlService() {
return ilService;
}
}
