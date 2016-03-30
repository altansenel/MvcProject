/*
 * Created on 7 Mar 2016 ( Time 11:05:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.envers.Audited;

/**
 * Persistent class for entity stored in table "stock_costing_inventory"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_costing_inventory")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockCostingInventory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockCostingInventoryKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="_date")
    private Date       date         ;    @Column(name="input")
    private Double     input        ;    @Column(name="remain")
    private Double     remain       ;    @Column(name="price")
    private Double     price        ;    @Column(name="amount")
    private Double     amount       ;
	// "costingId" (column "costing_id") is not defined by itself because used as FK in a link 
	// "stockId" (column "stock_id") is not defined by itself because used as FK in a link 
	// "depotId" (column "depot_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private Stock stock       ;

    @ManyToOne
    @JoinColumn(name="costing_id", referencedColumnName="id")
    private StockCosting stockCosting;

    @ManyToOne
    @JoinColumn(name="depot_id", referencedColumnName="id")
    private StockDepot stockDepot  ;


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



    //--- DATABASE MAPPING : _date ( DATE ) 
    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }




    //--- DATABASE MAPPING : input ( DOUBLE ) 
    public void setInput( Double input ) {
        this.input = input;
    }
    public Double getInput() {
        return this.input;
    }




    //--- DATABASE MAPPING : remain ( DOUBLE ) 
    public void setRemain( Double remain ) {
        this.remain = remain;
    }
    public Double getRemain() {
        return this.remain;
    }




    //--- DATABASE MAPPING : price ( DOUBLE ) 
    public void setPrice( Double price ) {
        this.price = price;
    }
    public Double getPrice() {
        return this.price;
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
    public void setStock( Stock stock ) {
        this.stock = stock;
    }
    public Stock getStock() {
        return this.stock;
    }

    public void setStockCosting( StockCosting stockCosting ) {
        this.stockCosting = stockCosting;
    }
    public StockCosting getStockCosting() {
        return this.stockCosting;
    }

    public void setStockDepot( StockDepot stockDepot ) {
        this.stockDepot = stockDepot;
    }
    public StockDepot getStockDepot() {
        return this.stockDepot;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(date);
        sb.append("|");
        sb.append(input);
        sb.append("|");
        sb.append(remain);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(amount);
        return sb.toString(); 
    } 

}