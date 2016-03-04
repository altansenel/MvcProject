package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "MENU", indexes = {
		@Index(columnList = "permission_id", name = "IND_MENU_PERMISSION"),
		@Index(columnList = "parent_id", name = "IND_MENU_MENU") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Menu extends BaseEntity implements Serializable, Comparable<Menu> {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "link")
	private String link;

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "FK_MENU_PERMISSION"))
	private Permission permission;

	@Column(name = "sira")
	private Integer sira;

	@OrderBy("sira")
	@OneToMany(mappedBy = "menu", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Menu> menuList = new ArrayList<Menu>();

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_MENU_MENU"))
	private Menu menu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Integer getSira() {
		return sira;
	}

	public void setSira(Integer sira) {
		this.sira = sira;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public int compareTo(Menu o) {
		int int1;
		int int2;
		if (getSira() != null) {
			int1 = getSira();
		} else {
			int1 = getName().hashCode();
		}
		if (o.getSira() != null) {
			int2 = o.getSira();
		} else {
			int2 = o.getName().hashCode();
		}

		if (int1 < int2) {
			return -1;
		} else if (int1 == int2) {
			return 0;
		} else {
			return 1;
		}
	}

}
