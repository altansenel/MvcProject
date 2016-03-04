package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IKitapService;
import com.entity.Kitap;

@ManagedBean(name = "kitapConverter")
@RequestScoped
public class KitapConverter extends BaseConverter<Kitap> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{kitapService}")
private IKitapService kitapService;

public void setKitapService(IKitapService kitapService) {
this.kitapService =kitapService;setEntityService(kitapService); 
}

public IKitapService getKitapService() {
return kitapService;
}
}
