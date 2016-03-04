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
@Table(name = "SHIPPING_METHOD", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ShippingMethod extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "shippingMethod")
private String shippingMethod;

public String getShippingMethod() {
	return shippingMethod;
}

public void setShippingMethod(String shippingMethod) {
	this.shippingMethod = shippingMethod;
}

}