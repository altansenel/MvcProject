package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IRoleUserService;
import com.entity.RoleUser;

@ManagedBean(name = "roleUserConverter")
@RequestScoped
public class RoleUserConverter extends BaseConverter implements Converter, Serializable {

private static final long serialVersionUID = 1L;
private static final Logger logger =Logger.getLogger(RoleUserConverter.class);

@ManagedProperty(value = "#{roleUserService}")
private IRoleUserService roleUserService;

public void setRoleUserService(IRoleUserService roleUserService) {
this.roleUserService =roleUserService;
}

public IRoleUserService getRoleUserService() {
return roleUserService;
}
}
