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
@Table(name = "DOLAP", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dolap extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "ad")
private String ad;

@OneToMany(mappedBy = "dolap", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Kitap> kitapList = new ArrayList<Kitap>();

public List<Kitap> getKitapList() {
	return kitapList;
}

public String getAd() {
	return ad;
}

public void setKitapList(List<Kitap> kitapList) {
	this.kitapList = kitapList;
}

public void setAd(String ad) {
	this.ad = ad;
}

}