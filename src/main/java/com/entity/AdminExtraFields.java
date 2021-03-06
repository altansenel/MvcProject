/*
 * Created on 7 Mar 2016 ( Time 11:04:57 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

import org.hibernate.envers.Audited;

/**
 * Persistent class for entity stored in table "admin_extra_fields"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "admin_extra_fields")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdminExtraFields extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private AdminExtraFieldsKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="idno", nullable=false)
    private Integer    idno         ;    @Column(name="distinction", nullable=false, length=15)
    private String     distinction  ;    @Column(name="name", nullable=false, length=12)
    private String     name         ;    @Column(name="is_required")
    private Boolean    isRequired   ;    @Column(name="is_active")
    private Boolean    isActive     ;


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------



    //--- DATABASE MAPPING : idno ( INT ) 
    public void setIdno( Integer idno ) {
        this.idno = idno;
    }
    public Integer getIdno() {
        return this.idno;
    }




    //--- DATABASE MAPPING : distinction ( VARCHAR ) 
    public void setDistinction( String distinction ) {
        this.distinction = distinction;
    }
    public String getDistinction() {
        return this.distinction;
    }




    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }




    //--- DATABASE MAPPING : is_required ( BIT ) 
    public void setIsRequired( Boolean isRequired ) {
        this.isRequired = isRequired;
    }
    public Boolean getIsRequired() {
        return this.isRequired;
    }




    //--- DATABASE MAPPING : is_active ( BIT ) 
    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(idno);
        sb.append("|");
        sb.append(distinction);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(isRequired);
        sb.append("|");
        sb.append(isActive);
        return sb.toString(); 
    } 

}
