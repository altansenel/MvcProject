package com.entity;
import java.io.Serializable;
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



/**
 * @version {} Ağustos 21, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "ADAM", indexes = { @Index(columnList = "sehir_id", name = "IND_ADAM_SEHIR") } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adam extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "name")
private String name;

@JoinColumn(name = "sehir_id" , foreignKey = @ForeignKey(name = "FK_PERSON_SEHIR"))
@ManyToOne(fetch = FetchType.EAGER)
private Sehir sehir;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Sehir getSehir() {
	return sehir;
}

public void setSehir(Sehir sehir) {
	this.sehir = sehir;
}

}