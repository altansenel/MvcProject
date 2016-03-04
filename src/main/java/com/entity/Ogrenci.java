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
@Table(name = "OGRENCI", indexes = { @Index(columnList = "sinif", name = "IND_OGRENCI_SINIF") } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Ogrenci extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "ad")
private String ad;

@OneToMany(mappedBy = "ogrenci", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Alisveris> alisverisList = new ArrayList<Alisveris>();

@Column(name = "soyad")
private String soyad;

@NotNull
@JoinColumn(name = "sinif")
@ManyToOne(fetch = FetchType.EAGER)
private Sinif sinif;

@NotNull
@Column(name = "numara")
private Integer numara;

public List<Alisveris> getAlisverisList() {
	return alisverisList;
}

public String getAd() {
	return ad;
}

public void setAlisverisList(List<Alisveris> alisverisList) {
	this.alisverisList = alisverisList;
}

public void setAd(String ad) {
	this.ad = ad;
}

public String getSoyad() {
	return soyad;
}

public void setSoyad(String soyad) {
	this.soyad = soyad;
}

public Sinif getSinif() {
	return sinif;
}

public void setSinif(Sinif sinif) {
	this.sinif = sinif;
}

public Integer getNumara() {
	return numara;
}

public void setNumara(Integer numara) {
	this.numara = numara;
}

}