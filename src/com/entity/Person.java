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

@Audited
@Entity
@Table(name = "PERSON", indexes = { @Index(columnList = "sehir_id", name = "IND_PERSON_SEHIR") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
// virgül atıp devam eder
public class Person extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Pattern(regexp=".{5}") //@Pattern(regexp="\\w{5}")
	@Column(name = "name")
	private String name;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "sehir_id", foreignKey = @ForeignKey(name = "FK_PERSON_SEHIR"))
	private Sehir sehir;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sehir getSehir() {
		return sehir;
	}

	public void setSehir(Sehir sehir) {
		this.sehir = sehir;
	}

	@Override
	public String toString() {
		return " id= " + getId() + "  name=" + name + ", sehir=" + sehir;
	}
}
