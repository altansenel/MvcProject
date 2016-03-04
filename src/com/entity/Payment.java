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
@Table(name = "PAYMENT", indexes = { @Index(columnList = "order_id", name = "IND_PAYMENT_ORDER"),@Index(columnList = "payment_method_id", name = "IND_PAYMENT_PAYMENTMETHOD") } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Payment extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@JoinColumn(name = "order_id")
@ManyToOne(fetch = FetchType.EAGER)
private Order order;

@JoinColumn(name = "payment_method_id")
@ManyToOne(fetch = FetchType.EAGER)
private PaymentMethod paymentMethod;

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public PaymentMethod getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(PaymentMethod paymentMethod) {
	this.paymentMethod = paymentMethod;
}

}