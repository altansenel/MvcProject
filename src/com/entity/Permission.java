package com.entity;
import java.io.Serializable;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.math.BigDecimal;



/**
 * @version {} Eylül 09, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "PERMISSIONS", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Permission extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "name")
private String name;

@OneToMany(mappedBy = "permission", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();

@OneToMany(mappedBy = "permission", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Menu> menuList = new ArrayList<Menu>();

public List<RolePermission> getRolePermissionList() {
	return rolePermissionList;
}

public List<Menu> getMenuList() {
	return menuList;
}

public String getName() {
	return name;
}

public void setRolePermissionList(List<RolePermission> rolePermissionList) {
	this.rolePermissionList = rolePermissionList;
}

public void setMenuList(List<Menu> menuList) {
	this.menuList = menuList;
}

public void setName(String name) {
	this.name = name;
}

}