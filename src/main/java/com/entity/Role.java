package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="ROLES")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
     
    @Column(name="name")
    private String name;
    
	@OneToMany(mappedBy = "role", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RoleUser> roleUserList = new ArrayList<RoleUser>();
	
	@OneToMany(mappedBy = "role", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleUser> getRoleUserList() {
		return roleUserList;
	}

	public void setRoleUserList(List<RoleUser> roleUserList) {
		this.roleUserList = roleUserList;
	}

	public List<RolePermission> getRolePermissionList() {
		return rolePermissionList;
	}

	public void setRolePermissionList(List<RolePermission> rolePermissionList) {
		this.rolePermissionList = rolePermissionList;
	}

}

		                  
