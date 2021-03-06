/*
 * Created on 7 Mar 2016 ( Time 11:04:58 )
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
 * Persistent class for entity stored in table "chqbll_trans_detail"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "chqbll_trans_detail")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ChqbllTransDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private ChqbllTransDetailKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 
	// "detailId" (column "detail_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="detail_id", referencedColumnName="id")
    private ChqbllPayrollDetail chqbllPayrollDetail;

    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private ChqbllTrans chqbllTrans ;


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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setChqbllPayrollDetail( ChqbllPayrollDetail chqbllPayrollDetail ) {
        this.chqbllPayrollDetail = chqbllPayrollDetail;
    }
    public ChqbllPayrollDetail getChqbllPayrollDetail() {
        return this.chqbllPayrollDetail;
    }

    public void setChqbllTrans( ChqbllTrans chqbllTrans ) {
        this.chqbllTrans = chqbllTrans;
    }
    public ChqbllTrans getChqbllTrans() {
        return this.chqbllTrans;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
