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
 * Persistent class for entity stored in table "invoice_trans_currency"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "invoice_trans_currency")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InvoiceTransCurrency extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private InvoiceTransCurrencyKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="currency", length=3)
    private String     currency     ;    @Column(name="amount")
    private Double     amount       ;
	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private InvoiceTrans invoiceTrans;


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



    //--- DATABASE MAPPING : currency ( VARCHAR ) 
    public void setCurrency( String currency ) {
        this.currency = currency;
    }
    public String getCurrency() {
        return this.currency;
    }




    //--- DATABASE MAPPING : amount ( DOUBLE ) 
    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setInvoiceTrans( InvoiceTrans invoiceTrans ) {
        this.invoiceTrans = invoiceTrans;
    }
    public InvoiceTrans getInvoiceTrans() {
        return this.invoiceTrans;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(currency);
        sb.append("|");
        sb.append(amount);
        return sb.toString(); 
    } 

}
