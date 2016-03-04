package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.ISinifService;
import com.entity.Sinif;

@ManagedBean(name = "sinifConverter")
@RequestScoped
public class SinifConverter extends BaseConverter<Sinif> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{sinifService}")
private ISinifService sinifService;

public void setSinifService(ISinifService sinifService) {
this.sinifService =sinifService;setEntityService(sinifService); 
}

public ISinifService getSinifService() {
return sinifService;
}
}
