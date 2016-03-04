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

import org.hibernate.envers.Audited;

/**
 * @version {} Ağustos 21, 2015
 * @author Altan Senel
 * 
 */

@Audited
@Entity
@Table(name = "IL", indexes = { @Index(columnList = "ulke_id", name = "IND_IL_ULKE") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Il extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@JoinColumn(name = "ulke_id", foreignKey = @ForeignKey(name = "FK_IL_ULKE"))
	@ManyToOne(fetch = FetchType.EAGER)
	private Ulke ulke;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ulke getUlke() {
		return ulke;
	}

	public void setUlke(Ulke ulke) {
		this.ulke = ulke;
	}
	

}