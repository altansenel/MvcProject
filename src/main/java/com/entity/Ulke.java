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
@Table(name="ULKE")
public class Ulke extends BaseEntity implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

    @Column(name="name")
    private String name;
    
	@OneToMany(mappedBy = "ulke", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Sehir> sehirList = new ArrayList<Sehir>();
	
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	public List<Sehir> getSehirList() {
		return sehirList;
	}

	public void setSehirList(List<Sehir> sehirList) {
		this.sehirList = sehirList;
	}

	@Override
    public String toString(){
        return " id= " + getId() + " name="+name ;
    }
}
