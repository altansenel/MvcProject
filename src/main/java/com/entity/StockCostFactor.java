/*
 * Created on 7 Mar 2016 ( Time 11:04:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.envers.Audited;

/**
 * Persistent class for entity stored in table "stock_cost_factor"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_cost_factor")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockCostFactor extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockCostFactorKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=30)
    private String     name         ;    @Column(name="factor_type", nullable=false, length=8)
    private String     factorType   ;    @Column(name="calc_type", nullable=false, length=7)
    private String     calcType     ;    @Column(name="effect_type", nullable=false, length=7)
    private String     effectType   ;    @Column(name="effect")
    private Double     effect       ;    @Column(name="insert_by", length=20)
    private String     insertBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;    @Column(name="update_by", length=20)
    private String     updateBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;    @Column(name="is_active")
    private Boolean    isActive     ;    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="stockCostFactor", targetEntity=InvoiceTransFactor.class)
    private List<InvoiceTransFactor> listOfInvoiceTransFactor;

    @OneToMany(mappedBy="stockCostFactor", targetEntity=StockTransFactor.class)
    private List<StockTransFactor> listOfStockTransFactor;

    @OneToMany(mappedBy="stockCostFactor", targetEntity=WaybillTransFactor.class)
    private List<WaybillTransFactor> listOfWaybillTransFactor;

    @OneToMany(mappedBy="stockCostFactor", targetEntity=OrderTransFactor.class)
    private List<OrderTransFactor> listOfOrderTransFactor;


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



    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }




    //--- DATABASE MAPPING : factor_type ( VARCHAR ) 
    public void setFactorType( String factorType ) {
        this.factorType = factorType;
    }
    public String getFactorType() {
        return this.factorType;
    }




    //--- DATABASE MAPPING : calc_type ( VARCHAR ) 
    public void setCalcType( String calcType ) {
        this.calcType = calcType;
    }
    public String getCalcType() {
        return this.calcType;
    }




    //--- DATABASE MAPPING : effect_type ( VARCHAR ) 
    public void setEffectType( String effectType ) {
        this.effectType = effectType;
    }
    public String getEffectType() {
        return this.effectType;
    }




    //--- DATABASE MAPPING : effect ( DOUBLE ) 
    public void setEffect( Double effect ) {
        this.effect = effect;
    }
    public Double getEffect() {
        return this.effect;
    }




    //--- DATABASE MAPPING : insert_by ( VARCHAR ) 
    public void setInsertBy( String insertBy ) {
        this.insertBy = insertBy;
    }
    public String getInsertBy() {
        return this.insertBy;
    }




    //--- DATABASE MAPPING : insert_at ( DATETIME ) 
    public void setInsertAt( Date insertAt ) {
        this.insertAt = insertAt;
    }
    public Date getInsertAt() {
        return this.insertAt;
    }




    //--- DATABASE MAPPING : update_by ( VARCHAR ) 
    public void setUpdateBy( String updateBy ) {
        this.updateBy = updateBy;
    }
    public String getUpdateBy() {
        return this.updateBy;
    }




    //--- DATABASE MAPPING : update_at ( DATETIME ) 
    public void setUpdateAt( Date updateAt ) {
        this.updateAt = updateAt;
    }
    public Date getUpdateAt() {
        return this.updateAt;
    }




    //--- DATABASE MAPPING : is_active ( BIT ) 
    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
    }




    //--- DATABASE MAPPING : workspace ( INT ) 
    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
    }





    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfInvoiceTransFactor( List<InvoiceTransFactor> listOfInvoiceTransFactor ) {
        this.listOfInvoiceTransFactor = listOfInvoiceTransFactor;
    }
    public List<InvoiceTransFactor> getListOfInvoiceTransFactor() {
        return this.listOfInvoiceTransFactor;
    }

    public void setListOfStockTransFactor( List<StockTransFactor> listOfStockTransFactor ) {
        this.listOfStockTransFactor = listOfStockTransFactor;
    }
    public List<StockTransFactor> getListOfStockTransFactor() {
        return this.listOfStockTransFactor;
    }

    public void setListOfWaybillTransFactor( List<WaybillTransFactor> listOfWaybillTransFactor ) {
        this.listOfWaybillTransFactor = listOfWaybillTransFactor;
    }
    public List<WaybillTransFactor> getListOfWaybillTransFactor() {
        return this.listOfWaybillTransFactor;
    }

    public void setListOfOrderTransFactor( List<OrderTransFactor> listOfOrderTransFactor ) {
        this.listOfOrderTransFactor = listOfOrderTransFactor;
    }
    public List<OrderTransFactor> getListOfOrderTransFactor() {
        return this.listOfOrderTransFactor;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(factorType);
        sb.append("|");
        sb.append(calcType);
        sb.append("|");
        sb.append(effectType);
        sb.append("|");
        sb.append(effect);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(isActive);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}
