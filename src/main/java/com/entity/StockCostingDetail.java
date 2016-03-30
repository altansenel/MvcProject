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
 * Persistent class for entity stored in table "stock_costing_detail"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_costing_detail")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockCostingDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockCostingDetailKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="sell_date", nullable=false)
    private Date       sellDate     ;    @Column(name="sell_quantity")
    private Double     sellQuantity ;    @Column(name="sell_cost_price")
    private Double     sellCostPrice ;    @Column(name="sell_cost_amount")
    private Double     sellCostAmount ;    @Column(name="buy_cost_price")
    private Double     buyCostPrice ;    @Column(name="buy_cost_amount")
    private Double     buyCostAmount ;    @Column(name="profit_loss_amount")
    private Double     profitLossAmount ;    @Column(name="trans_year")
    private Integer    transYear    ;    @Column(name="trans_month", length=7)
    private String     transMonth   ;
	// "costingId" (column "costing_id") is not defined by itself because used as FK in a link 
	// "stockId" (column "stock_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private Stock stock       ;

    @ManyToOne
    @JoinColumn(name="costing_id", referencedColumnName="id")
    private StockCosting stockCosting;


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



    //--- DATABASE MAPPING : sell_date ( DATE ) 
    public void setSellDate( Date sellDate ) {
        this.sellDate = sellDate;
    }
    public Date getSellDate() {
        return this.sellDate;
    }




    //--- DATABASE MAPPING : sell_quantity ( DOUBLE ) 
    public void setSellQuantity( Double sellQuantity ) {
        this.sellQuantity = sellQuantity;
    }
    public Double getSellQuantity() {
        return this.sellQuantity;
    }




    //--- DATABASE MAPPING : sell_cost_price ( DOUBLE ) 
    public void setSellCostPrice( Double sellCostPrice ) {
        this.sellCostPrice = sellCostPrice;
    }
    public Double getSellCostPrice() {
        return this.sellCostPrice;
    }




    //--- DATABASE MAPPING : sell_cost_amount ( DOUBLE ) 
    public void setSellCostAmount( Double sellCostAmount ) {
        this.sellCostAmount = sellCostAmount;
    }
    public Double getSellCostAmount() {
        return this.sellCostAmount;
    }




    //--- DATABASE MAPPING : buy_cost_price ( DOUBLE ) 
    public void setBuyCostPrice( Double buyCostPrice ) {
        this.buyCostPrice = buyCostPrice;
    }
    public Double getBuyCostPrice() {
        return this.buyCostPrice;
    }




    //--- DATABASE MAPPING : buy_cost_amount ( DOUBLE ) 
    public void setBuyCostAmount( Double buyCostAmount ) {
        this.buyCostAmount = buyCostAmount;
    }
    public Double getBuyCostAmount() {
        return this.buyCostAmount;
    }




    //--- DATABASE MAPPING : profit_loss_amount ( DOUBLE ) 
    public void setProfitLossAmount( Double profitLossAmount ) {
        this.profitLossAmount = profitLossAmount;
    }
    public Double getProfitLossAmount() {
        return this.profitLossAmount;
    }




    //--- DATABASE MAPPING : trans_year ( INT ) 
    public void setTransYear( Integer transYear ) {
        this.transYear = transYear;
    }
    public Integer getTransYear() {
        return this.transYear;
    }




    //--- DATABASE MAPPING : trans_month ( VARCHAR ) 
    public void setTransMonth( String transMonth ) {
        this.transMonth = transMonth;
    }
    public String getTransMonth() {
        return this.transMonth;
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


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(sellDate);
        sb.append("|");
        sb.append(sellQuantity);
        sb.append("|");
        sb.append(sellCostPrice);
        sb.append("|");
        sb.append(sellCostAmount);
        sb.append("|");
        sb.append(buyCostPrice);
        sb.append("|");
        sb.append(buyCostAmount);
        sb.append("|");
        sb.append(profitLossAmount);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
        return sb.toString(); 
    } 

}