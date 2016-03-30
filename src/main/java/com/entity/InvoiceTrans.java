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
 * Persistent class for entity stored in table "invoice_trans"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "invoice_trans")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InvoiceTrans extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private InvoiceTransKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="receipt_no", nullable=false)
    private Integer    receiptNo    ;    @Column(name="_right", nullable=false, length=50)
    private String     right        ;    @Column(name="is_cash")
    private Boolean    isCash       ;    @Column(name="is_completed")
    private Boolean    isCompleted  ;    @Temporal(TemporalType.DATE)
    @Column(name="trans_date", nullable=false)
    private Date       transDate    ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="real_date")
    private Date       realDate     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="delivery_date")
    private Date       deliveryDate ;    @Column(name="trans_no", length=20)
    private String     transNo      ;    @Column(name="is_tax_include")
    private Boolean    isTaxInclude ;    @Column(name="rounding_digits")
    private Boolean    roundingDigits ;    @Column(name="total")
    private Double     total        ;    @Column(name="discount_total")
    private Double     discountTotal ;    @Column(name="subtotal")
    private Double     subtotal     ;    @Column(name="rounding_discount")
    private Double     roundingDiscount ;    @Column(name="total_discount_rate")
    private Double     totalDiscountRate ;    @Column(name="tax_total")
    private Double     taxTotal     ;    @Column(name="net_total")
    private Double     netTotal     ;    @Column(name="plus_factor_total")
    private Double     plusFactorTotal ;    @Column(name="minus_factor_total")
    private Double     minusFactorTotal ;    @Column(name="withholding_rate")
    private Double     withholdingRate ;    @Column(name="withholding_before")
    private Double     withholdingBefore ;    @Column(name="withholding_amount")
    private Double     withholdingAmount ;    @Column(name="withholding_after")
    private Double     withholdingAfter ;    @Column(name="description", length=100)
    private String     description  ;    @Column(name="trans_year")
    private Integer    transYear    ;    @Column(name="trans_month", length=7)
    private String     transMonth   ;    @Column(name="contact_name", length=100)
    private String     contactName  ;    @Column(name="contact_tax_office", length=20)
    private String     contactTaxOffice ;    @Column(name="contact_tax_number", length=15)
    private String     contactTaxNumber ;    @Column(name="contact_address1", length=100)
    private String     contactAddress1 ;    @Column(name="contact_address2", length=100)
    private String     contactAddress2 ;    @Column(name="consigner", length=50)
    private String     consigner    ;    @Column(name="recepient", length=50)
    private String     recepient    ;    @Column(name="trans_type", nullable=false, length=6)
    private String     transType    ;    @Column(name="exc_code", length=3)
    private String     excCode      ;    @Column(name="exc_rate")
    private Double     excRate      ;    @Column(name="exc_equivalent")
    private Double     excEquivalent ;    @Column(name="insert_by", length=20)
    private String     insertBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;    @Column(name="update_by", length=20)
    private String     updateBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;    @Column(name="contact_trans_id")
    private Integer    contactTransId ;    @Column(name="ref_module", length=10)
    private String     refModule    ;    @Column(name="ref_id")
    private Integer    refId        ;    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;
	// "contactId" (column "contact_id") is not defined by itself because used as FK in a link 
	// "sellerId" (column "seller_id") is not defined by itself because used as FK in a link 
	// "transSourceId" (column "trans_source_id") is not defined by itself because used as FK in a link 
	// "transPointId" (column "trans_point_id") is not defined by itself because used as FK in a link 
	// "privateCodeId" (column "private_code_id") is not defined by itself because used as FK in a link 
	// "depotId" (column "depot_id") is not defined by itself because used as FK in a link 
	// "statusId" (column "status_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="trans_point_id", referencedColumnName="id")
    private GlobalTransPoint globalTransPoint;

    @OneToMany(mappedBy="invoiceTrans", targetEntity=InvoiceTransCurrency.class)
    private List<InvoiceTransCurrency> listOfInvoiceTransCurrency;

    @ManyToOne
    @JoinColumn(name="seller_id", referencedColumnName="id")
    private SaleSeller saleSeller  ;

    @ManyToOne
    @JoinColumn(name="contact_id", referencedColumnName="id")
    private Contact contact     ;

    @OneToMany(mappedBy="invoiceTrans", targetEntity=InvoiceTransFactor.class)
    private List<InvoiceTransFactor> listOfInvoiceTransFactor;

    @ManyToOne
    @JoinColumn(name="private_code_id", referencedColumnName="id")
    private GlobalPrivateCode globalPrivateCode;

    @OneToMany(mappedBy="invoiceTrans", targetEntity=InvoiceTransDetail.class)
    private List<InvoiceTransDetail> listOfInvoiceTransDetail;

    @ManyToOne
    @JoinColumn(name="depot_id", referencedColumnName="id")
    private StockDepot stockDepot  ;

    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName="id")
    private InvoiceTransStatus invoiceTransStatus;

    @OneToMany(mappedBy="invoiceTrans", targetEntity=InvoiceTransTax.class)
    private List<InvoiceTransTax> listOfInvoiceTransTax;

    @ManyToOne
    @JoinColumn(name="trans_source_id", referencedColumnName="id")
    private InvoiceTransSource invoiceTransSource;

    @OneToMany(mappedBy="invoiceTrans", targetEntity=InvoiceTransRelation.class)
    private List<InvoiceTransRelation> listOfInvoiceTransRelation;


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



    //--- DATABASE MAPPING : receipt_no ( INT ) 
    public void setReceiptNo( Integer receiptNo ) {
        this.receiptNo = receiptNo;
    }
    public Integer getReceiptNo() {
        return this.receiptNo;
    }




    //--- DATABASE MAPPING : _right ( VARCHAR ) 
    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }




    //--- DATABASE MAPPING : is_cash ( BIT ) 
    public void setIsCash( Boolean isCash ) {
        this.isCash = isCash;
    }
    public Boolean getIsCash() {
        return this.isCash;
    }




    //--- DATABASE MAPPING : is_completed ( BIT ) 
    public void setIsCompleted( Boolean isCompleted ) {
        this.isCompleted = isCompleted;
    }
    public Boolean getIsCompleted() {
        return this.isCompleted;
    }




    //--- DATABASE MAPPING : trans_date ( DATE ) 
    public void setTransDate( Date transDate ) {
        this.transDate = transDate;
    }
    public Date getTransDate() {
        return this.transDate;
    }




    //--- DATABASE MAPPING : real_date ( DATETIME ) 
    public void setRealDate( Date realDate ) {
        this.realDate = realDate;
    }
    public Date getRealDate() {
        return this.realDate;
    }




    //--- DATABASE MAPPING : delivery_date ( DATETIME ) 
    public void setDeliveryDate( Date deliveryDate ) {
        this.deliveryDate = deliveryDate;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }




    //--- DATABASE MAPPING : trans_no ( VARCHAR ) 
    public void setTransNo( String transNo ) {
        this.transNo = transNo;
    }
    public String getTransNo() {
        return this.transNo;
    }




    //--- DATABASE MAPPING : is_tax_include ( BIT ) 
    public void setIsTaxInclude( Boolean isTaxInclude ) {
        this.isTaxInclude = isTaxInclude;
    }
    public Boolean getIsTaxInclude() {
        return this.isTaxInclude;
    }




    //--- DATABASE MAPPING : rounding_digits ( BIT ) 
    public void setRoundingDigits( Boolean roundingDigits ) {
        this.roundingDigits = roundingDigits;
    }
    public Boolean getRoundingDigits() {
        return this.roundingDigits;
    }




    //--- DATABASE MAPPING : total ( DOUBLE ) 
    public void setTotal( Double total ) {
        this.total = total;
    }
    public Double getTotal() {
        return this.total;
    }




    //--- DATABASE MAPPING : discount_total ( DOUBLE ) 
    public void setDiscountTotal( Double discountTotal ) {
        this.discountTotal = discountTotal;
    }
    public Double getDiscountTotal() {
        return this.discountTotal;
    }




    //--- DATABASE MAPPING : subtotal ( DOUBLE ) 
    public void setSubtotal( Double subtotal ) {
        this.subtotal = subtotal;
    }
    public Double getSubtotal() {
        return this.subtotal;
    }




    //--- DATABASE MAPPING : rounding_discount ( DOUBLE ) 
    public void setRoundingDiscount( Double roundingDiscount ) {
        this.roundingDiscount = roundingDiscount;
    }
    public Double getRoundingDiscount() {
        return this.roundingDiscount;
    }




    //--- DATABASE MAPPING : total_discount_rate ( DOUBLE ) 
    public void setTotalDiscountRate( Double totalDiscountRate ) {
        this.totalDiscountRate = totalDiscountRate;
    }
    public Double getTotalDiscountRate() {
        return this.totalDiscountRate;
    }




    //--- DATABASE MAPPING : tax_total ( DOUBLE ) 
    public void setTaxTotal( Double taxTotal ) {
        this.taxTotal = taxTotal;
    }
    public Double getTaxTotal() {
        return this.taxTotal;
    }




    //--- DATABASE MAPPING : net_total ( DOUBLE ) 
    public void setNetTotal( Double netTotal ) {
        this.netTotal = netTotal;
    }
    public Double getNetTotal() {
        return this.netTotal;
    }




    //--- DATABASE MAPPING : plus_factor_total ( DOUBLE ) 
    public void setPlusFactorTotal( Double plusFactorTotal ) {
        this.plusFactorTotal = plusFactorTotal;
    }
    public Double getPlusFactorTotal() {
        return this.plusFactorTotal;
    }




    //--- DATABASE MAPPING : minus_factor_total ( DOUBLE ) 
    public void setMinusFactorTotal( Double minusFactorTotal ) {
        this.minusFactorTotal = minusFactorTotal;
    }
    public Double getMinusFactorTotal() {
        return this.minusFactorTotal;
    }




    //--- DATABASE MAPPING : withholding_rate ( DOUBLE ) 
    public void setWithholdingRate( Double withholdingRate ) {
        this.withholdingRate = withholdingRate;
    }
    public Double getWithholdingRate() {
        return this.withholdingRate;
    }




    //--- DATABASE MAPPING : withholding_before ( DOUBLE ) 
    public void setWithholdingBefore( Double withholdingBefore ) {
        this.withholdingBefore = withholdingBefore;
    }
    public Double getWithholdingBefore() {
        return this.withholdingBefore;
    }




    //--- DATABASE MAPPING : withholding_amount ( DOUBLE ) 
    public void setWithholdingAmount( Double withholdingAmount ) {
        this.withholdingAmount = withholdingAmount;
    }
    public Double getWithholdingAmount() {
        return this.withholdingAmount;
    }




    //--- DATABASE MAPPING : withholding_after ( DOUBLE ) 
    public void setWithholdingAfter( Double withholdingAfter ) {
        this.withholdingAfter = withholdingAfter;
    }
    public Double getWithholdingAfter() {
        return this.withholdingAfter;
    }




    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
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




    //--- DATABASE MAPPING : contact_name ( VARCHAR ) 
    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }
    public String getContactName() {
        return this.contactName;
    }




    //--- DATABASE MAPPING : contact_tax_office ( VARCHAR ) 
    public void setContactTaxOffice( String contactTaxOffice ) {
        this.contactTaxOffice = contactTaxOffice;
    }
    public String getContactTaxOffice() {
        return this.contactTaxOffice;
    }




    //--- DATABASE MAPPING : contact_tax_number ( VARCHAR ) 
    public void setContactTaxNumber( String contactTaxNumber ) {
        this.contactTaxNumber = contactTaxNumber;
    }
    public String getContactTaxNumber() {
        return this.contactTaxNumber;
    }




    //--- DATABASE MAPPING : contact_address1 ( VARCHAR ) 
    public void setContactAddress1( String contactAddress1 ) {
        this.contactAddress1 = contactAddress1;
    }
    public String getContactAddress1() {
        return this.contactAddress1;
    }




    //--- DATABASE MAPPING : contact_address2 ( VARCHAR ) 
    public void setContactAddress2( String contactAddress2 ) {
        this.contactAddress2 = contactAddress2;
    }
    public String getContactAddress2() {
        return this.contactAddress2;
    }




    //--- DATABASE MAPPING : consigner ( VARCHAR ) 
    public void setConsigner( String consigner ) {
        this.consigner = consigner;
    }
    public String getConsigner() {
        return this.consigner;
    }




    //--- DATABASE MAPPING : recepient ( VARCHAR ) 
    public void setRecepient( String recepient ) {
        this.recepient = recepient;
    }
    public String getRecepient() {
        return this.recepient;
    }




    //--- DATABASE MAPPING : trans_type ( VARCHAR ) 
    public void setTransType( String transType ) {
        this.transType = transType;
    }
    public String getTransType() {
        return this.transType;
    }




    //--- DATABASE MAPPING : exc_code ( VARCHAR ) 
    public void setExcCode( String excCode ) {
        this.excCode = excCode;
    }
    public String getExcCode() {
        return this.excCode;
    }




    //--- DATABASE MAPPING : exc_rate ( DOUBLE ) 
    public void setExcRate( Double excRate ) {
        this.excRate = excRate;
    }
    public Double getExcRate() {
        return this.excRate;
    }




    //--- DATABASE MAPPING : exc_equivalent ( DOUBLE ) 
    public void setExcEquivalent( Double excEquivalent ) {
        this.excEquivalent = excEquivalent;
    }
    public Double getExcEquivalent() {
        return this.excEquivalent;
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




    //--- DATABASE MAPPING : contact_trans_id ( INT ) 
    public void setContactTransId( Integer contactTransId ) {
        this.contactTransId = contactTransId;
    }
    public Integer getContactTransId() {
        return this.contactTransId;
    }




    //--- DATABASE MAPPING : ref_module ( VARCHAR ) 
    public void setRefModule( String refModule ) {
        this.refModule = refModule;
    }
    public String getRefModule() {
        return this.refModule;
    }




    //--- DATABASE MAPPING : ref_id ( INT ) 
    public void setRefId( Integer refId ) {
        this.refId = refId;
    }
    public Integer getRefId() {
        return this.refId;
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
    public void setGlobalTransPoint( GlobalTransPoint globalTransPoint ) {
        this.globalTransPoint = globalTransPoint;
    }
    public GlobalTransPoint getGlobalTransPoint() {
        return this.globalTransPoint;
    }

    public void setListOfInvoiceTransCurrency( List<InvoiceTransCurrency> listOfInvoiceTransCurrency ) {
        this.listOfInvoiceTransCurrency = listOfInvoiceTransCurrency;
    }
    public List<InvoiceTransCurrency> getListOfInvoiceTransCurrency() {
        return this.listOfInvoiceTransCurrency;
    }

    public void setSaleSeller( SaleSeller saleSeller ) {
        this.saleSeller = saleSeller;
    }
    public SaleSeller getSaleSeller() {
        return this.saleSeller;
    }

    public void setContact( Contact contact ) {
        this.contact = contact;
    }
    public Contact getContact() {
        return this.contact;
    }

    public void setListOfInvoiceTransFactor( List<InvoiceTransFactor> listOfInvoiceTransFactor ) {
        this.listOfInvoiceTransFactor = listOfInvoiceTransFactor;
    }
    public List<InvoiceTransFactor> getListOfInvoiceTransFactor() {
        return this.listOfInvoiceTransFactor;
    }

    public void setGlobalPrivateCode( GlobalPrivateCode globalPrivateCode ) {
        this.globalPrivateCode = globalPrivateCode;
    }
    public GlobalPrivateCode getGlobalPrivateCode() {
        return this.globalPrivateCode;
    }

    public void setListOfInvoiceTransDetail( List<InvoiceTransDetail> listOfInvoiceTransDetail ) {
        this.listOfInvoiceTransDetail = listOfInvoiceTransDetail;
    }
    public List<InvoiceTransDetail> getListOfInvoiceTransDetail() {
        return this.listOfInvoiceTransDetail;
    }

    public void setStockDepot( StockDepot stockDepot ) {
        this.stockDepot = stockDepot;
    }
    public StockDepot getStockDepot() {
        return this.stockDepot;
    }

    public void setInvoiceTransStatus( InvoiceTransStatus invoiceTransStatus ) {
        this.invoiceTransStatus = invoiceTransStatus;
    }
    public InvoiceTransStatus getInvoiceTransStatus() {
        return this.invoiceTransStatus;
    }

    public void setListOfInvoiceTransTax( List<InvoiceTransTax> listOfInvoiceTransTax ) {
        this.listOfInvoiceTransTax = listOfInvoiceTransTax;
    }
    public List<InvoiceTransTax> getListOfInvoiceTransTax() {
        return this.listOfInvoiceTransTax;
    }

    public void setInvoiceTransSource( InvoiceTransSource invoiceTransSource ) {
        this.invoiceTransSource = invoiceTransSource;
    }
    public InvoiceTransSource getInvoiceTransSource() {
        return this.invoiceTransSource;
    }

    public void setListOfInvoiceTransRelation( List<InvoiceTransRelation> listOfInvoiceTransRelation ) {
        this.listOfInvoiceTransRelation = listOfInvoiceTransRelation;
    }
    public List<InvoiceTransRelation> getListOfInvoiceTransRelation() {
        return this.listOfInvoiceTransRelation;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(receiptNo);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(isCash);
        sb.append("|");
        sb.append(isCompleted);
        sb.append("|");
        sb.append(transDate);
        sb.append("|");
        sb.append(realDate);
        sb.append("|");
        sb.append(deliveryDate);
        sb.append("|");
        sb.append(transNo);
        sb.append("|");
        sb.append(isTaxInclude);
        sb.append("|");
        sb.append(roundingDigits);
        sb.append("|");
        sb.append(total);
        sb.append("|");
        sb.append(discountTotal);
        sb.append("|");
        sb.append(subtotal);
        sb.append("|");
        sb.append(roundingDiscount);
        sb.append("|");
        sb.append(totalDiscountRate);
        sb.append("|");
        sb.append(taxTotal);
        sb.append("|");
        sb.append(netTotal);
        sb.append("|");
        sb.append(plusFactorTotal);
        sb.append("|");
        sb.append(minusFactorTotal);
        sb.append("|");
        sb.append(withholdingRate);
        sb.append("|");
        sb.append(withholdingBefore);
        sb.append("|");
        sb.append(withholdingAmount);
        sb.append("|");
        sb.append(withholdingAfter);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
        sb.append("|");
        sb.append(contactName);
        sb.append("|");
        sb.append(contactTaxOffice);
        sb.append("|");
        sb.append(contactTaxNumber);
        sb.append("|");
        sb.append(contactAddress1);
        sb.append("|");
        sb.append(contactAddress2);
        sb.append("|");
        sb.append(consigner);
        sb.append("|");
        sb.append(recepient);
        sb.append("|");
        sb.append(transType);
        sb.append("|");
        sb.append(excCode);
        sb.append("|");
        sb.append(excRate);
        sb.append("|");
        sb.append(excEquivalent);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(contactTransId);
        sb.append("|");
        sb.append(refModule);
        sb.append("|");
        sb.append(refId);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}
