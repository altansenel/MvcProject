package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

import com.enums.ProjectEnum.KitapTuru;
import com.enums.ProjectEnum.UygunlukDurumu;

/**
 * @version {} Aralık 16, 2015
 * @author Altan Senel
 * 
 */

@Audited
@Entity
@Table(name = "KITAP", indexes = { @Index(columnList = "dolap", name = "IND_KITAP_DOLAP") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Kitap extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name = "ad")
	private String ad;

	@OneToMany(mappedBy = "kitap", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Alisveris> alisverisList = new ArrayList<Alisveris>();


	@Column(name = "yazar")
	private String yazar;

	@Column(name = "yayinevi")
	private String yayinevi;

	@Column(name = "kitap_turu")
	@Enumerated(EnumType.ORDINAL)
	private KitapTuru kitapTuru;

	@Column(name = "uygunluk_durumu")
	@Enumerated(EnumType.ORDINAL)
	private UygunlukDurumu uygunlukDurumu;

	@Column(name = "basim_tarihi")
	private Date basimTarihi;

	@Transient
	private Date ilkBasimTarihi;

	@Transient
	private Date sonBasimTarihi;

	@JoinColumn(name = "dolap")
	@ManyToOne(fetch = FetchType.EAGER)
	private Dolap dolap;

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

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public String getYayinevi() {
		return yayinevi;
	}

	public void setYayinevi(String yayinevi) {
		this.yayinevi = yayinevi;
	}

	public KitapTuru getKitapTuru() {
		return kitapTuru;
	}

	public void setKitapTuru(KitapTuru kitapTuru) {
		this.kitapTuru = kitapTuru;
	}

	public UygunlukDurumu getUygunlukDurumu() {
		return uygunlukDurumu;
	}

	public void setUygunlukDurumu(UygunlukDurumu uygunlukDurumu) {
		this.uygunlukDurumu = uygunlukDurumu;
	}

	public Date getIlkBasimTarihi() {
		return ilkBasimTarihi;
	}

	public Date getSonBasimTarihi() {
		return sonBasimTarihi;
	}

	public Date getBasimTarihi() {
		return basimTarihi;
	}

	public void setIlkBasimTarihi(Date ilkBasimTarihi) {
		this.ilkBasimTarihi = ilkBasimTarihi;
	}

	public void setSonBasimTarihi(Date sonBasimTarihi) {
		this.sonBasimTarihi = sonBasimTarihi;
	}

	public void setBasimTarihi(Date basimTarihi) {
		this.basimTarihi = basimTarihi;
	}

	public Dolap getDolap() {
		return dolap;
	}

	public void setDolap(Dolap dolap) {
		this.dolap = dolap;
	}

}