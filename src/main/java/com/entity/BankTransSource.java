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
 * @version {} Aralık 11, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "BANK_TRANS_SOURCE", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BankTransSource extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "name")
private String name;

@NotNull
@Column(name = "suitable_right")
private String suitableRight;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSuitableRight() {
	return suitableRight;
}

public void setSuitableRight(String suitableRight) {
	this.suitableRight = suitableRight;
}

}