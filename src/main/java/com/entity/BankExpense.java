package com.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;



/**
 * @version {} Aralık 11, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "BANK_EXPENSE", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BankExpense extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@NotNull
@Column(name = "name")
private String name;


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

}