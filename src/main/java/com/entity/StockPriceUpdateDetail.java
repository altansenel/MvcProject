/*
 * Created on 7 Mar 2016 ( Time 11:05:26 )
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
 * Persistent class for entity stored in table "stock_price_update_detail"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_price_update_detail")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockPriceUpdateDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockPriceUpdateDetailKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="stock_id")
    private Integer    stockId      ;    @Column(name="buy_price")
    private Double     buyPrice     ;    @Column(name="sell_price")
    private Double     sellPrice    ;
	// "priceUpdateId" (column "price_update_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="price_update_id", referencedColumnName="id")
    private StockPriceUpdate stockPriceUpdate;


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



    //--- DATABASE MAPPING : stock_id ( INT ) 
    public void setStockId( Integer stockId ) {
        this.stockId = stockId;
    }
    public Integer getStockId() {
        return this.stockId;
    }




    //--- DATABASE MAPPING : buy_price ( DOUBLE ) 
    public void setBuyPrice( Double buyPrice ) {
        this.buyPrice = buyPrice;
    }
    public Double getBuyPrice() {
        return this.buyPrice;
    }




    //--- DATABASE MAPPING : sell_price ( DOUBLE ) 
    public void setSellPrice( Double sellPrice ) {
        this.sellPrice = sellPrice;
    }
    public Double getSellPrice() {
        return this.sellPrice;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setStockPriceUpdate( StockPriceUpdate stockPriceUpdate ) {
        this.stockPriceUpdate = stockPriceUpdate;
    }
    public StockPriceUpdate getStockPriceUpdate() {
        return this.stockPriceUpdate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(stockId);
        sb.append("|");
        sb.append(buyPrice);
        sb.append("|");
        sb.append(sellPrice);
        return sb.toString(); 
    } 

}