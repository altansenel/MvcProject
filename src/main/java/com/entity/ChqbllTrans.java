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
 * Persistent class for entity stored in table "chqbll_trans"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "chqbll_trans")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ChqbllTrans extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private ChqbllTransKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="sort", nullable=false, length=6)
    private String     sort         ;    @Column(name="receipt_no", nullable=false)
    private Integer    receiptNo    ;    @Column(name="_right", nullable=false, length=50)
    private String     right        ;    @Column(name="from_step", nullable=false, length=15)
    private String     fromStep     ;    @Column(name="to_step", nullable=false, length=15)
    private String     toStep       ;    @Temporal(TemporalType.DATE)
    @Column(name="trans_date", nullable=false)
    private Date       transDate    ;    @Column(name="trans_no", length=20)
    private String     transNo      ;    @Column(name="trans_type", nullable=false, length=6)
    private String     transType    ;    @Column(name="total", nullable=false)
    private Double     total        ;    @Column(name="row_count", nullable=false)
    private Integer    rowCount     ;    @Column(name="adat", nullable=false)
    private Integer    adat         ;    @Temporal(TemporalType.DATE)
    @Column(name="avarage_date", nullable=false)
    private Date       avarageDate  ;    @Column(name="description", length=100)
    private String     description  ;    @Column(name="trans_year")
    private Integer    transYear    ;    @Column(name="trans_month", length=7)
    private String     transMonth   ;    @Column(name="exc_code", length=3)
    private String     excCode      ;    @Column(name="exc_rate")
    private Double     excRate      ;    @Column(name="exc_equivalent")
    private Double     excEquivalent ;    @Column(name="insert_by", length=20)
    private String     insertBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;    @Column(name="update_by", length=20)
    private String     updateBy     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;    @Column(name="ref_module", length=10)
    private String     refModule    ;    @Column(name="ref_id")
    private Integer    refId        ;    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;
	// "transSourceId" (column "trans_source_id") is not defined by itself because used as FK in a link 
	// "transPointId" (column "trans_point_id") is not defined by itself because used as FK in a link 
	// "privateCodeId" (column "private_code_id") is not defined by itself because used as FK in a link 
	// "contactId" (column "contact_id") is not defined by itself because used as FK in a link 
	// "bankId" (column "bank_id") is not defined by itself because used as FK in a link 
	// "safeId" (column "safe_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="bank_id", referencedColumnName="id")
    private Bank bank        ;

    @ManyToOne
    @JoinColumn(name="trans_source_id", referencedColumnName="id")
    private ChqbllPayrollSource chqbllPayrollSource;

    @ManyToOne
    @JoinColumn(name="contact_id", referencedColumnName="id")
    private Contact contact     ;

    @OneToMany(mappedBy="chqbllTrans", targetEntity=ChqbllTransDetail.class)
    private List<ChqbllTransDetail> listOfChqbllTransDetail;

    @ManyToOne
    @JoinColumn(name="private_code_id", referencedColumnName="id")
    private GlobalPrivateCode globalPrivateCode;

    @ManyToOne
    @JoinColumn(name="safe_id", referencedColumnName="id")
    private Safe safe        ;

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



    //--- DATABASE MAPPING : sort ( VARCHAR ) 
    public void setSort( String sort ) {
        this.sort = sort;
    }
    public String getSort() {
        return this.sort;
    }




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




    //--- DATABASE MAPPING : from_step ( VARCHAR ) 
    public void setFromStep( String fromStep ) {
        this.fromStep = fromStep;
    }
    public String getFromStep() {
        return this.fromStep;
    }




    //--- DATABASE MAPPING : to_step ( VARCHAR ) 
    public void setToStep( String toStep ) {
        this.toStep = toStep;
    }
    public String getToStep() {
        return this.toStep;
    }




    //--- DATABASE MAPPING : trans_date ( DATE ) 
    public void setTransDate( Date transDate ) {
        this.transDate = transDate;
    }
    public Date getTransDate() {
        return this.transDate;
    }




    //--- DATABASE MAPPING : trans_no ( VARCHAR ) 
    public void setTransNo( String transNo ) {
        this.transNo = transNo;
    }
    public String getTransNo() {
        return this.transNo;
    }




    //--- DATABASE MAPPING : trans_type ( VARCHAR ) 
    public void setTransType( String transType ) {
        this.transType = transType;
    }
    public String getTransType() {
        return this.transType;
    }




    //--- DATABASE MAPPING : total ( DOUBLE ) 
    public void setTotal( Double total ) {
        this.total = total;
    }
    public Double getTotal() {
        return this.total;
    }




    //--- DATABASE MAPPING : row_count ( INT ) 
    public void setRowCount( Integer rowCount ) {
        this.rowCount = rowCount;
    }
    public Integer getRowCount() {
        return this.rowCount;
    }




    //--- DATABASE MAPPING : adat ( INT ) 
    public void setAdat( Integer adat ) {
        this.adat = adat;
    }
    public Integer getAdat() {
        return this.adat;
    }




    //--- DATABASE MAPPING : avarage_date ( DATE ) 
    public void setAvarageDate( Date avarageDate ) {
        this.avarageDate = avarageDate;
    }
    public Date getAvarageDate() {
        return this.avarageDate;
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
    public void setBank( Bank bank ) {
        this.bank = bank;
    }
    public Bank getBank() {
        return this.bank;
    }

    public void setChqbllPayrollSource( ChqbllPayrollSource chqbllPayrollSource ) {
        this.chqbllPayrollSource = chqbllPayrollSource;
    }
    public ChqbllPayrollSource getChqbllPayrollSource() {
        return this.chqbllPayrollSource;
    }

    public void setContact( Contact contact ) {
        this.contact = contact;
    }
    public Contact getContact() {
        return this.contact;
    }

    public void setListOfChqbllTransDetail( List<ChqbllTransDetail> listOfChqbllTransDetail ) {
        this.listOfChqbllTransDetail = listOfChqbllTransDetail;
    }
    public List<ChqbllTransDetail> getListOfChqbllTransDetail() {
        return this.listOfChqbllTransDetail;
    }

    public void setGlobalPrivateCode( GlobalPrivateCode globalPrivateCode ) {
        this.globalPrivateCode = globalPrivateCode;
    }
    public GlobalPrivateCode getGlobalPrivateCode() {
        return this.globalPrivateCode;
    }

    public void setSafe( Safe safe ) {
        this.safe = safe;
    }
    public Safe getSafe() {
        return this.safe;
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
        sb.append(sort);
        sb.append("|");
        sb.append(receiptNo);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(fromStep);
        sb.append("|");
        sb.append(toStep);
        sb.append("|");
        sb.append(transDate);
        sb.append("|");
        sb.append(transNo);
        sb.append("|");
        sb.append(transType);
        sb.append("|");
        sb.append(total);
        sb.append("|");
        sb.append(rowCount);
        sb.append("|");
        sb.append(adat);
        sb.append("|");
        sb.append(avarageDate);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
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