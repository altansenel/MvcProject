/*
 * Created on 7 Mar 2016 ( Time 11:04:57 )
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
 * Persistent class for entity stored in table "admin_user_given_role"
 *
 * @author Telosys Tools Generator
 *
 */




@Audited
@Entity
// Define named queries here
@Table(name = "admin_user_given_role")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdminUserGivenRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
//	@EmbeddedId
//   private AdminUserGivenRoleKey compositePrimaryKey ;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

	// "userGroupId" (column "user_group_id") is not defined by itself because used as FK in a link 
	// "workspaceId" (column "workspace_id") is not defined by itself because used as FK in a link 
	// "userRoleId" (column "user_role_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="user_group_id", referencedColumnName="id")
    private AdminUserGroup adminUserGroup;

    @ManyToOne
    @JoinColumn(name="user_role_id", referencedColumnName="id")
    private AdminUserRole adminUserRole;

    @ManyToOne
    @JoinColumn(name="workspace_id", referencedColumnName="id")
    private AdminWorkspace adminWorkspace;


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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setAdminUserGroup( AdminUserGroup adminUserGroup ) {
        this.adminUserGroup = adminUserGroup;
    }
    public AdminUserGroup getAdminUserGroup() {
        return this.adminUserGroup;
    }

    public void setAdminUserRole( AdminUserRole adminUserRole ) {
        this.adminUserRole = adminUserRole;
    }
    public AdminUserRole getAdminUserRole() {
        return this.adminUserRole;
    }

    public void setAdminWorkspace( AdminWorkspace adminWorkspace ) {
        this.adminWorkspace = adminWorkspace;
    }
    public AdminWorkspace getAdminWorkspace() {
        return this.adminWorkspace;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
