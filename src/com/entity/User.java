package com.entity;
import java.io.Serializable;
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



/**
 * @version {} Ağustos 28, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "USERS", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "username")
private String username;

@OneToMany(mappedBy = "user", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<RoleUser> roleUserList = new ArrayList<RoleUser>();

@Column(name = "password")
private String password;

@Column(name = "enabled")
private Boolean enabled;

public List<RoleUser> getRoleUserList() {
	return roleUserList;
}

public String getUsername() {
	return username;
}

public void setRoleUserList(List<RoleUser> roleUserList) {
	this.roleUserList = roleUserList;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Boolean getEnabled() {
	return enabled;
}

public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

}