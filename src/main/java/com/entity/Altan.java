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

import com.enums.ProjectEnum.Yon;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


/**
 * @version {} Ağustos 27, 2015
 * @author Altan Senel
 * 
 */


@Audited
@Entity
@Table(name = "ALTAN", indexes = { } )
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Altan extends BaseEntity implements Serializable {

private static final long serialVersionUID = 1L;

@Column(name = "yon")
@Enumerated(EnumType.ORDINAL)
private Yon yon;

public Yon getYon() {
	return yon;
}

public void setYon(Yon yon) {
	this.yon = yon;
}

}