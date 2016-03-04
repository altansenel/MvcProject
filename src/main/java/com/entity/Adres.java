package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name="ADRES")
public class Adres {
 
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
     
    @Column(name="sokak")
    private String sokak;

    
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "sehir_id", foreignKey = @ForeignKey(name = "FK_ADRES_SEHIR"))
    private Sehir sehir;
    
	
	@OneToMany(mappedBy = "adres", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PersonAdres> personAdresList = new ArrayList<PersonAdres>();
    
	
	
	
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getSokak() {
		return sokak;
	}

	public void setSokak(String sokak) {
		this.sokak = sokak;
	}

	public Sehir getSehir() {
		return sehir;
	}

	public void setSehir(Sehir sehir) {
		this.sehir = sehir;
	}

	public List<PersonAdres> getPersonAdresList() {
		return personAdresList;
	}

	public void setPersonAdresList(List<PersonAdres> personAdresList) {
		this.personAdresList = personAdresList;
	}

	@Override
    public String toString(){
        return "id="+id+", sokak="+sokak+", sehir="+sehir;
    }
}
