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
@Table(name = "SINIF", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Sinif extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "ad")
private String ad;

@OneToMany(mappedBy = "sinif", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();

public List<Ogrenci> getOgrenciList() {
	return ogrenciList;
}

public String getAd() {
	return ad;
}

public void setOgrenciList(List<Ogrenci> ogrenciList) {
	this.ogrenciList = ogrenciList;
}

public void setAd(String ad) {
	this.ad = ad;
}

}