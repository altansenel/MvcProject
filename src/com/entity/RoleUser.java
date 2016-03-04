package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

/**
 * @version {} Ağustos 26, 2015
 * @author Altan Senel
 * 
 */

@Audited
@Entity
@Table(name = "ROLE_MEMBERS", indexes = {
		@Index(columnList = "roles_id", name = "IND_ROLE_MEMBERS_ROLE"),
		@Index(columnList = "members_id", name = "IND_ROLE_MEMBERS_USER") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RoleUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "roles_id", foreignKey = @ForeignKey(name = "FK_ROLE_MEMBERS_ROLE"))
	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	@JoinColumn(name = "members_id", foreignKey = @ForeignKey(name = "FK_ROLE_MEMBERS_USER"))
	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}