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
 * @version {} Aralık 16, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "ALISVERIS", indexes = { @Index(columnList = "kitap", name = "IND_ALISVERIS_KITAP"),@Index(columnList = "ogrenci", name = "IND_ALISVERIS_OGRENCI") } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Alisveris extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@NotNull
@JoinColumn(name = "kitap")
@ManyToOne(fetch = FetchType.EAGER)
private Kitap kitap;

@NotNull
@JoinColumn(name = "ogrenci")
@ManyToOne(fetch = FetchType.EAGER)
private Ogrenci ogrenci;

@Column(name = "alis_tarihi")
private Date alisTarihi;

@Transient
private Date ilkAlisTarihi;

@Transient
private Date sonAlisTarihi;

@Column(name = "iade_tarihi")
private Date iadeTarihi;

@Transient
private Date ilkIadeTarihi;

@Transient
private Date sonIadeTarihi;

public Kitap getKitap() {
	return kitap;
}

public void setKitap(Kitap kitap) {
	this.kitap = kitap;
}

public Ogrenci getOgrenci() {
	return ogrenci;
}

public void setOgrenci(Ogrenci ogrenci) {
	this.ogrenci = ogrenci;
}

public Date getIlkAlisTarihi() {
	return ilkAlisTarihi;
}

public Date getSonAlisTarihi() {
	return sonAlisTarihi;
}

public Date getAlisTarihi() {
	return alisTarihi;
}

public void setIlkAlisTarihi(Date ilkAlisTarihi) {
	this.ilkAlisTarihi = ilkAlisTarihi;
}

public void setSonAlisTarihi(Date sonAlisTarihi) {
	this.sonAlisTarihi = sonAlisTarihi;
}

public void setAlisTarihi(Date alisTarihi) {
	this.alisTarihi = alisTarihi;
}

public Date getIlkIadeTarihi() {
	return ilkIadeTarihi;
}

public Date getSonIadeTarihi() {
	return sonIadeTarihi;
}

public Date getIadeTarihi() {
	return iadeTarihi;
}

public void setIlkIadeTarihi(Date ilkIadeTarihi) {
	this.ilkIadeTarihi = ilkIadeTarihi;
}

public void setSonIadeTarihi(Date sonIadeTarihi) {
	this.sonIadeTarihi = sonIadeTarihi;
}

public void setIadeTarihi(Date iadeTarihi) {
	this.iadeTarihi = iadeTarihi;
}

}