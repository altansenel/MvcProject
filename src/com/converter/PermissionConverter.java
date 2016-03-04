package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IPermissionService;
import com.entity.Permission;

@ManagedBean(name = "permissionConverter")
@RequestScoped
public class PermissionConverter extends BaseConverter<Permission> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{permissionService}")
private IPermissionService permissionService;

public void setPermissionService(IPermissionService permissionService) {
this.permissionService =permissionService;setEntityService(permissionService); 
}

public IPermissionService getPermissionService() {
return permissionService;
}
}
