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
 * @version {} Ekim 05, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "EMPLOYEE", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Employee extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "firstName")
private String firstName;

@OneToMany(mappedBy = "employee", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Order> orderList = new ArrayList<Order>();

@Column(name = "lastName")
private String lastName;

@Column(name = "title")
private String title;

@Column(name = "email")
private String email;

public List<Order> getOrderList() {
	return orderList;
}

public String getFirstName() {
	return firstName;
}

public void setOrderList(List<Order> orderList) {
	this.orderList = orderList;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}