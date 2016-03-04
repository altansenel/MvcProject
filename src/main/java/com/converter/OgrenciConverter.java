package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IOgrenciService;
import com.entity.Ogrenci;

@ManagedBean(name = "ogrenciConverter")
@RequestScoped
public class OgrenciConverter extends BaseConverter<Ogrenci> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{ogrenciService}")
private IOgrenciService ogrenciService;

public void setOgrenciService(IOgrenciService ogrenciService) {
this.ogrenciService =ogrenciService;setEntityService(ogrenciService); 
}

public IOgrenciService getOgrenciService() {
return ogrenciService;
}
}
