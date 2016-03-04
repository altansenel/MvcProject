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
@Table(name = "BANK", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Bank extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@NotNull
@Column(name = "account_no")
private String accountNo;

@NotNull
@Column(name = "name")
private String name;

@Column(name = "branch")
private String branch;

@Column(name = "city")
private String city;

@Column(name = "iban")
private String iban;

@Column(name = "exc_code")
private String excCode;

@NotNull
@Column(name = "workspace")
private Integer workspace;

public String getAccountNo() {
	return accountNo;
}

public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getIban() {
	return iban;
}

public void setIban(String iban) {
	this.iban = iban;
}

public String getExcCode() {
	return excCode;
}

public void setExcCode(String excCode) {
	this.excCode = excCode;
}

public Integer getWorkspace() {
	return workspace;
}

public void setWorkspace(Integer workspace) {
	this.workspace = workspace;
}

}