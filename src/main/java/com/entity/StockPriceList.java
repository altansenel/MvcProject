/*
 * Created on 7 Mar 2016 ( Time 11:05:23 )
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
 * Persistent class for entity stored in table "stock_price_list"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_price_list")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockPriceList extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockPriceListKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=30)
    private String     name         ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date")
    private Date       startDate    ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    private Date       endDate      ;    @Column(name="is_sell_price")
    private Boolean    isSellPrice  ;    @Column(name="effect_type", nullable=false, length=7)
    private String     effectType   ;    @Column(name="effect_direction", nullable=false, length=8)
    private String     effectDirection ;    @Column(name="effect")
    private Double     effect       ;    @Column(name="description", length=50)
    private String     description  ;    @Column(name="provider_code", length=30)
    private String     providerCode ;    @Column(name="insert_by", length=20)
    private String     insertBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;    @Column(name="update_by", length=20)
    private String     updateBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;    @Column(name="is_active")
    private Boolean    isActive     ;    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;
	// "categoryId" (column "category_id") is not defined by itself because used as FK in a link 
	// "extraField0Id" (column "extra_field0_id") is not defined by itself because used as FK in a link 
	// "extraField1Id" (column "extra_field1_id") is not defined by itself because used as FK in a link 
	// "extraField2Id" (column "extra_field2_id") is not defined by itself because used as FK in a link 
	// "extraField3Id" (column "extra_field3_id") is not defined by itself because used as FK in a link 
	// "extraField4Id" (column "extra_field4_id") is not defined by itself because used as FK in a link 
	// "extraField5Id" (column "extra_field5_id") is not defined by itself because used as FK in a link 
	// "extraField6Id" (column "extra_field6_id") is not defined by itself because used as FK in a link 
	// "extraField7Id" (column "extra_field7_id") is not defined by itself because used as FK in a link 
	// "extraField8Id" (column "extra_field8_id") is not defined by itself because used as FK in a link 
	// "extraField9Id" (column "extra_field9_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="extra_field9_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields2;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName="id")
    private StockCategory stockCategory;

    @ManyToOne
    @JoinColumn(name="extra_field4_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields7;

    @OneToMany(mappedBy="stockPriceList", targetEntity=Contact.class)
    private List<Contact> listOfContact;

    @ManyToOne
    @JoinColumn(name="extra_field0_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields3;

    @ManyToOne
    @JoinColumn(name="extra_field5_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields8;

    @ManyToOne
    @JoinColumn(name="extra_field1_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields4;

    @ManyToOne
    @JoinColumn(name="extra_field6_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields9;

    @ManyToOne
    @JoinColumn(name="extra_field2_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields5;

    @ManyToOne
    @JoinColumn(name="extra_field8_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields;

    @ManyToOne
    @JoinColumn(name="extra_field7_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields10;

    @ManyToOne
    @JoinColumn(name="extra_field3_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields6;


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




    //--- DATABASE MAPPING : start_date ( DATETIME ) 
    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }




    //--- DATABASE MAPPING : end_date ( DATETIME ) 
    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }




    //--- DATABASE MAPPING : is_sell_price ( BIT ) 
    public void setIsSellPrice( Boolean isSellPrice ) {
        this.isSellPrice = isSellPrice;
    }
    public Boolean getIsSellPrice() {
        return this.isSellPrice;
    }




    //--- DATABASE MAPPING : effect_type ( VARCHAR ) 
    public void setEffectType( String effectType ) {
        this.effectType = effectType;
    }
    public String getEffectType() {
        return this.effectType;
    }




    //--- DATABASE MAPPING : effect_direction ( VARCHAR ) 
    public void setEffectDirection( String effectDirection ) {
        this.effectDirection = effectDirection;
    }
    public String getEffectDirection() {
        return this.effectDirection;
    }




    //--- DATABASE MAPPING : effect ( DOUBLE ) 
    public void setEffect( Double effect ) {
        this.effect = effect;
    }
    public Double getEffect() {
        return this.effect;
    }




    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }




    //--- DATABASE MAPPING : provider_code ( VARCHAR ) 
    public void setProviderCode( String providerCode ) {
        this.providerCode = providerCode;
    }
    public String getProviderCode() {
        return this.providerCode;
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
    public void setStockExtraFields2( StockExtraFields stockExtraFields2 ) {
        this.stockExtraFields2 = stockExtraFields2;
    }
    public StockExtraFields getStockExtraFields2() {
        return this.stockExtraFields2;
    }

    public void setStockCategory( StockCategory stockCategory ) {
        this.stockCategory = stockCategory;
    }
    public StockCategory getStockCategory() {
        return this.stockCategory;
    }

    public void setStockExtraFields7( StockExtraFields stockExtraFields7 ) {
        this.stockExtraFields7 = stockExtraFields7;
    }
    public StockExtraFields getStockExtraFields7() {
        return this.stockExtraFields7;
    }

    public void setListOfContact( List<Contact> listOfContact ) {
        this.listOfContact = listOfContact;
    }
    public List<Contact> getListOfContact() {
        return this.listOfContact;
    }

    public void setStockExtraFields3( StockExtraFields stockExtraFields3 ) {
        this.stockExtraFields3 = stockExtraFields3;
    }
    public StockExtraFields getStockExtraFields3() {
        return this.stockExtraFields3;
    }

    public void setStockExtraFields8( StockExtraFields stockExtraFields8 ) {
        this.stockExtraFields8 = stockExtraFields8;
    }
    public StockExtraFields getStockExtraFields8() {
        return this.stockExtraFields8;
    }

    public void setStockExtraFields4( StockExtraFields stockExtraFields4 ) {
        this.stockExtraFields4 = stockExtraFields4;
    }
    public StockExtraFields getStockExtraFields4() {
        return this.stockExtraFields4;
    }

    public void setStockExtraFields9( StockExtraFields stockExtraFields9 ) {
        this.stockExtraFields9 = stockExtraFields9;
    }
    public StockExtraFields getStockExtraFields9() {
        return this.stockExtraFields9;
    }

    public void setStockExtraFields5( StockExtraFields stockExtraFields5 ) {
        this.stockExtraFields5 = stockExtraFields5;
    }
    public StockExtraFields getStockExtraFields5() {
        return this.stockExtraFields5;
    }

    public void setStockExtraFields( StockExtraFields stockExtraFields ) {
        this.stockExtraFields = stockExtraFields;
    }
    public StockExtraFields getStockExtraFields() {
        return this.stockExtraFields;
    }

    public void setStockExtraFields10( StockExtraFields stockExtraFields10 ) {
        this.stockExtraFields10 = stockExtraFields10;
    }
    public StockExtraFields getStockExtraFields10() {
        return this.stockExtraFields10;
    }

    public void setStockExtraFields6( StockExtraFields stockExtraFields6 ) {
        this.stockExtraFields6 = stockExtraFields6;
    }
    public StockExtraFields getStockExtraFields6() {
        return this.stockExtraFields6;
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
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(isSellPrice);
        sb.append("|");
        sb.append(effectType);
        sb.append("|");
        sb.append(effectDirection);
        sb.append("|");
        sb.append(effect);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(providerCode);
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