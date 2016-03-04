package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Audited
@Entity
@Table(name="GENERATED_ENTITY")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GeneratedEntity extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "TABLE_NAME")
	private String table;

	@Column(name = "ENTITY")
	private String entity;
	
	@OneToMany(mappedBy = "generatedEntity", orphanRemoval=true,  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<GeneratedEntityField> generatedEntityFieldList = new ArrayList<GeneratedEntityField>();
	

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public List<GeneratedEntityField> getGeneratedEntityFieldList() {
		return generatedEntityFieldList;
	}

	public void setGeneratedEntityFieldList(
			List<GeneratedEntityField> generatedEntityFieldList) {
		this.generatedEntityFieldList = generatedEntityFieldList;
	}

}