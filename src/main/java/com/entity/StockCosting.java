/*
 * Created on 7 Mar 2016 ( Time 11:05:19 )
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
 * Persistent class for entity stored in table "stock_costing"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "stock_costing")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockCosting extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private StockCostingKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", length=30)
    private String     name         ;    @Column(name="properties", nullable=false, length=100)
    private String     properties   ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="exec_date")
    private Date       execDate     ;    @Temporal(TemporalType.DATE)
    @Column(name="calc_date", nullable=false)
    private Date       calcDate     ;    @Column(name="costing_type", nullable=false, length=8)
    private String     costingType  ;    @Column(name="provider_code", length=30)
    private String     providerCode ;    @Column(name="insert_by", length=20)
    private String     insertBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;    @Column(name="update_by", length=20)
    private String     updateBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;    @Column(name="is_active")
    private Boolean    isActive     ;    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;
	// "transPointId" (column "trans_point_id") is not defined by itself because used as FK in a link 
	// "categoryId" (column "category_id") is not defined by itself because used as FK in a link 
	// "depotId" (column "depot_id") is not defined by itself because used as FK in a link 
	// "stockId" (column "stock_id") is not defined by itself because used as FK in a link 
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
    @JoinColumn(name="extra_field1_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields7;

    @ManyToOne
    @JoinColumn(name="extra_field9_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields5;

    @ManyToOne
    @JoinColumn(name="extra_field5_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName="id")
    private StockCategory stockCategory;

    @ManyToOne
    @JoinColumn(name="extra_field2_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields8;

    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private Stock stock       ;

    @ManyToOne
    @JoinColumn(name="extra_field6_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields2;

    @ManyToOne
    @JoinColumn(name="extra_field3_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields9;

    @ManyToOne
    @JoinColumn(name="extra_field7_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields3;

    @ManyToOne
    @JoinColumn(name="depot_id", referencedColumnName="id")
    private StockDepot stockDepot  ;

    @OneToMany(mappedBy="stockCosting", targetEntity=StockCostingDetail.class)
    private List<StockCostingDetail> listOfStockCostingDetail;

    @ManyToOne
    @JoinColumn(name="extra_field4_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields10;

    @ManyToOne
    @JoinColumn(name="extra_field8_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields4;

    @ManyToOne
    @JoinColumn(name="extra_field0_id", referencedColumnName="id")
    private StockExtraFields stockExtraFields6;

    @OneToMany(mappedBy="stockCosting", targetEntity=StockCostingInventory.class)
    private List<StockCostingInventory> listOfStockCostingInventory;

    @ManyToOne
    @JoinColumn(name="trans_point_id", referencedColumnName="id")
    private GlobalTransPoint globalTransPoint;


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




    //--- DATABASE MAPPING : properties ( VARCHAR ) 
    public void setProperties( String properties ) {
        this.properties = properties;
    }
    public String getProperties() {
        return this.properties;
    }




    //--- DATABASE MAPPING : exec_date ( DATETIME ) 
    public void setExecDate( Date execDate ) {
        this.execDate = execDate;
    }
    public Date getExecDate() {
        return this.execDate;
    }




    //--- DATABASE MAPPING : calc_date ( DATE ) 
    public void setCalcDate( Date calcDate ) {
        this.calcDate = calcDate;
    }
    public Date getCalcDate() {
        return this.calcDate;
    }




    //--- DATABASE MAPPING : costing_type ( VARCHAR ) 
    public void setCostingType( String costingType ) {
        this.costingType = costingType;
    }
    public String getCostingType() {
        return this.costingType;
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
    public void setStockExtraFields7( StockExtraFields stockExtraFields7 ) {
        this.stockExtraFields7 = stockExtraFields7;
    }
    public StockExtraFields getStockExtraFields7() {
        return this.stockExtraFields7;
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

    public void setStockCategory( StockCategory stockCategory ) {
        this.stockCategory = stockCategory;
    }
    public StockCategory getStockCategory() {
        return this.stockCategory;
    }

    public void setStockExtraFields8( StockExtraFields stockExtraFields8 ) {
        this.stockExtraFields8 = stockExtraFields8;
    }
    public StockExtraFields getStockExtraFields8() {
        return this.stockExtraFields8;
    }

    public void setStock( Stock stock ) {
        this.stock = stock;
    }
    public Stock getStock() {
        return this.stock;
    }

    public void setStockExtraFields2( StockExtraFields stockExtraFields2 ) {
        this.stockExtraFields2 = stockExtraFields2;
    }
    public StockExtraFields getStockExtraFields2() {
        return this.stockExtraFields2;
    }

    public void setStockExtraFields9( StockExtraFields stockExtraFields9 ) {
        this.stockExtraFields9 = stockExtraFields9;
    }
    public StockExtraFields getStockExtraFields9() {
        return this.stockExtraFields9;
    }

    public void setStockExtraFields3( StockExtraFields stockExtraFields3 ) {
        this.stockExtraFields3 = stockExtraFields3;
    }
    public StockExtraFields getStockExtraFields3() {
        return this.stockExtraFields3;
    }

    public void setStockDepot( StockDepot stockDepot ) {
        this.stockDepot = stockDepot;
    }
    public StockDepot getStockDepot() {
        return this.stockDepot;
    }

    public void setListOfStockCostingDetail( List<StockCostingDetail> listOfStockCostingDetail ) {
        this.listOfStockCostingDetail = listOfStockCostingDetail;
    }
    public List<StockCostingDetail> getListOfStockCostingDetail() {
        return this.listOfStockCostingDetail;
    }

    public void setStockExtraFields10( StockExtraFields stockExtraFields10 ) {
        this.stockExtraFields10 = stockExtraFields10;
    }
    public StockExtraFields getStockExtraFields10() {
        return this.stockExtraFields10;
    }

    public void setStockExtraFields4( StockExtraFields stockExtraFields4 ) {
        this.stockExtraFields4 = stockExtraFields4;
    }
    public StockExtraFields getStockExtraFields4() {
        return this.stockExtraFields4;
    }

    public void setStockExtraFields6( StockExtraFields stockExtraFields6 ) {
        this.stockExtraFields6 = stockExtraFields6;
    }
    public StockExtraFields getStockExtraFields6() {
        return this.stockExtraFields6;
    }

    public void setListOfStockCostingInventory( List<StockCostingInventory> listOfStockCostingInventory ) {
        this.listOfStockCostingInventory = listOfStockCostingInventory;
    }
    public List<StockCostingInventory> getListOfStockCostingInventory() {
        return this.listOfStockCostingInventory;
    }

    public void setGlobalTransPoint( GlobalTransPoint globalTransPoint ) {
        this.globalTransPoint = globalTransPoint;
    }
    public GlobalTransPoint getGlobalTransPoint() {
        return this.globalTransPoint;
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
        sb.append(properties);
        sb.append("|");
        sb.append(execDate);
        sb.append("|");
        sb.append(calcDate);
        sb.append("|");
        sb.append(costingType);
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
