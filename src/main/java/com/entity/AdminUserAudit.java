/*
 * Created on 7 Mar 2016 ( Time 11:04:57 )
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
 * Persistent class for entity stored in table "admin_user_audit"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "admin_user_audit")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdminUserAudit extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private AdminUserAuditKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="username", length=20)
    private String     username     ;    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="_date")
    private Date       date         ;    @Column(name="_right", length=30)
    private String     right        ;    @Column(name="ip", length=45)
    private String     ip           ;    @Column(name="description", length=255)
    private String     description  ;    @Column(name="log_level", length=7)
    private String     logLevel     ;    @Column(name="workspace", length=30)
    private String     workspace    ;


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

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



    //--- DATABASE MAPPING : username ( VARCHAR ) 
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }




    //--- DATABASE MAPPING : _date ( DATETIME ) 
    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }




    //--- DATABASE MAPPING : _right ( VARCHAR ) 
    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }




    //--- DATABASE MAPPING : ip ( VARCHAR ) 
    public void setIp( String ip ) {
        this.ip = ip;
    }
    public String getIp() {
        return this.ip;
    }




    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }




    //--- DATABASE MAPPING : log_level ( VARCHAR ) 
    public void setLogLevel( String logLevel ) {
        this.logLevel = logLevel;
    }
    public String getLogLevel() {
        return this.logLevel;
    }




    //--- DATABASE MAPPING : workspace ( VARCHAR ) 
    public void setWorkspace( String workspace ) {
        this.workspace = workspace;
    }
    public String getWorkspace() {
        return this.workspace;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(username);
        sb.append("|");
        sb.append(date);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(ip);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(logLevel);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 

}
