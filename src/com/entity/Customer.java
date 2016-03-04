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
 * @version {} Eylül 07, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "CUSTOMER", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Customer extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Pattern(regexp=".{5}")
@Column(name = "companyName")
private String companyName;

@Column(name = "contactFirstName")
private String contactFirstName;

@Column(name = "contactLastName")
private String contactLastName;

@Column(name = "city")
private String city;

@Column(name = "country")
private String country;

@Column(name = "phoneNumber")
private String phoneNumber;

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getContactFirstName() {
	return contactFirstName;
}

public void setContactFirstName(String contactFirstName) {
	this.contactFirstName = contactFirstName;
}

public String getContactLastName() {
	return contactLastName;
}

public void setContactLastName(String contactLastName) {
	this.contactLastName = contactLastName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}