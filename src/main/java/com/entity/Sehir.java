package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;
 
@Audited
@Entity
@Table(name="SEHIR")
public class Sehir extends BaseEntity implements Serializable{
 

	private static final long serialVersionUID = 1L;

	@Column(name="name")
    private String name;

    
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "ulke_id", foreignKey = @ForeignKey(name = "FK_PERSON_ULKE"))
	private Ulke ulke;
    
	@OneToMany(mappedBy = "sehir", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Person> personList = new ArrayList<Person>();
    
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
    public Ulke getUlke() {
		return ulke;
	}

	public void setUlke(Ulke ulke) {
		this.ulke = ulke;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	@Override
    public String toString(){
        return "id="+getId()+", name="+name ;
    }
}
