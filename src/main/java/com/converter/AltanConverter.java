package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IAltanService;
import com.entity.Altan;

@ManagedBean(name = "altanConverter")
@RequestScoped
public class AltanConverter extends BaseConverter implements Converter, Serializable {

private static final long serialVersionUID = 1L;
private static final Logger logger =Logger.getLogger(AltanConverter.class);

@ManagedProperty(value = "#{altanService}")
private IAltanService altanService;

public void setAltanService(IAltanService altanService) {
this.altanService =altanService;
}

public IAltanService getAltanService() {
return altanService;
}
}
