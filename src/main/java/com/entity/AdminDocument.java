/*
 * Created on 7 Mar 2016 ( Time 11:04:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * Persistent class for entity stored in table "admin_document"
 *
 * @author Telosys Tools Generator
 *
 */

@Audited
@Entity
// Define named queries here
@Table(name = "admin_document")
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdminDocument extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
	// ----------------------------------------------------------------------
	// @EmbeddedId
	// private AdminDocumentKey compositePrimaryKey ;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "module", nullable = false, length = 10)
	private String module;
	@Column(name = "header", length = 20)
	private String header;
	@Column(name = "_right", nullable = false, length = 50)
	private String right;
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@Column(name = "page_rows")
	private Integer pageRows;
	@Column(name = "report_title_rows")
	private Integer reportTitleRows;
	@Column(name = "page_title_rows")
	private Integer pageTitleRows;
	@Column(name = "detail_rows")
	private Integer detailRows;
	@Column(name = "page_footer_rows")
	private Integer pageFooterRows;
	@Column(name = "report_footer_rows")
	private Integer reportFooterRows;
	@Column(name = "report_title_labels")
	private Boolean reportTitleLabels;
	@Column(name = "page_title_labels")
	private Boolean pageTitleLabels;
	@Column(name = "detail_labels")
	private Boolean detailLabels;
	@Column(name = "page_footer_labels")
	private Boolean pageFooterLabels;
	@Column(name = "report_footer_labels")
	private Boolean reportFooterLabels;
	@Column(name = "left_margin")
	private Integer leftMargin;
	@Column(name = "top_margin")
	private Integer topMargin;
	@Column(name = "bottom_margin")
	private Integer bottomMargin;
	@Column(name = "is_single_page")
	private Boolean isSinglePage;
	@Column(name = "has_paging")
	private Boolean hasPaging;
	@Column(name = "column_title_type", length = 7)
	private String columnTitleType;
	@Column(name = "carrying_over_name", length = 50)
	private String carryingOverName;
	@Column(name = "description", length = 30)
	private String description;
	@Column(name = "template_rows")
	private String templateRows;
	@Column(name = "is_active")
	private Boolean isActive;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------
	@OneToMany(mappedBy = "adminDocument3", targetEntity = AdminDocumentField.class)
	private List<AdminDocumentField> listOfAdminDocumentField3;

	@OneToMany(mappedBy = "adminDocument5", targetEntity = AdminDocumentField.class)
	private List<AdminDocumentField> listOfAdminDocumentField5;

	@OneToMany(mappedBy = "adminDocument2", targetEntity = AdminDocumentField.class)
	private List<AdminDocumentField> listOfAdminDocumentField2;

	@OneToMany(mappedBy = "adminDocument4", targetEntity = AdminDocumentField.class)
	private List<AdminDocumentField> listOfAdminDocumentField4;

	@OneToMany(mappedBy = "adminDocument", targetEntity = AdminDocumentField.class)
	private List<AdminDocumentField> listOfAdminDocumentField;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE COMPOSITE KEY
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------

	// --- DATABASE MAPPING : module ( VARCHAR )
	public void setModule(String module) {
		this.module = module;
	}

	public String getModule() {
		return this.module;
	}

	// --- DATABASE MAPPING : header ( VARCHAR )
	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader() {
		return this.header;
	}

	// --- DATABASE MAPPING : _right ( VARCHAR )
	public void setRight(String right) {
		this.right = right;
	}

	public String getRight() {
		return this.right;
	}

	// --- DATABASE MAPPING : name ( VARCHAR )
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// --- DATABASE MAPPING : page_rows ( INT )
	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public Integer getPageRows() {
		return this.pageRows;
	}

	// --- DATABASE MAPPING : report_title_rows ( INT )
	public void setReportTitleRows(Integer reportTitleRows) {
		this.reportTitleRows = reportTitleRows;
	}

	public Integer getReportTitleRows() {
		return this.reportTitleRows;
	}

	// --- DATABASE MAPPING : page_title_rows ( INT )
	public void setPageTitleRows(Integer pageTitleRows) {
		this.pageTitleRows = pageTitleRows;
	}

	public Integer getPageTitleRows() {
		return this.pageTitleRows;
	}

	// --- DATABASE MAPPING : detail_rows ( INT )
	public void setDetailRows(Integer detailRows) {
		this.detailRows = detailRows;
	}

	public Integer getDetailRows() {
		return this.detailRows;
	}

	// --- DATABASE MAPPING : page_footer_rows ( INT )
	public void setPageFooterRows(Integer pageFooterRows) {
		this.pageFooterRows = pageFooterRows;
	}

	public Integer getPageFooterRows() {
		return this.pageFooterRows;
	}

	// --- DATABASE MAPPING : report_footer_rows ( INT )
	public void setReportFooterRows(Integer reportFooterRows) {
		this.reportFooterRows = reportFooterRows;
	}

	public Integer getReportFooterRows() {
		return this.reportFooterRows;
	}

	// --- DATABASE MAPPING : report_title_labels ( BIT )
	public void setReportTitleLabels(Boolean reportTitleLabels) {
		this.reportTitleLabels = reportTitleLabels;
	}

	public Boolean getReportTitleLabels() {
		return this.reportTitleLabels;
	}

	// --- DATABASE MAPPING : page_title_labels ( BIT )
	public void setPageTitleLabels(Boolean pageTitleLabels) {
		this.pageTitleLabels = pageTitleLabels;
	}

	public Boolean getPageTitleLabels() {
		return this.pageTitleLabels;
	}

	// --- DATABASE MAPPING : detail_labels ( BIT )
	public void setDetailLabels(Boolean detailLabels) {
		this.detailLabels = detailLabels;
	}

	public Boolean getDetailLabels() {
		return this.detailLabels;
	}

	// --- DATABASE MAPPING : page_footer_labels ( BIT )
	public void setPageFooterLabels(Boolean pageFooterLabels) {
		this.pageFooterLabels = pageFooterLabels;
	}

	public Boolean getPageFooterLabels() {
		return this.pageFooterLabels;
	}

	// --- DATABASE MAPPING : report_footer_labels ( BIT )
	public void setReportFooterLabels(Boolean reportFooterLabels) {
		this.reportFooterLabels = reportFooterLabels;
	}

	public Boolean getReportFooterLabels() {
		return this.reportFooterLabels;
	}

	// --- DATABASE MAPPING : left_margin ( INT )
	public void setLeftMargin(Integer leftMargin) {
		this.leftMargin = leftMargin;
	}

	public Integer getLeftMargin() {
		return this.leftMargin;
	}

	// --- DATABASE MAPPING : top_margin ( INT )
	public void setTopMargin(Integer topMargin) {
		this.topMargin = topMargin;
	}

	public Integer getTopMargin() {
		return this.topMargin;
	}

	// --- DATABASE MAPPING : bottom_margin ( INT )
	public void setBottomMargin(Integer bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public Integer getBottomMargin() {
		return this.bottomMargin;
	}

	// --- DATABASE MAPPING : is_single_page ( BIT )
	public void setIsSinglePage(Boolean isSinglePage) {
		this.isSinglePage = isSinglePage;
	}

	public Boolean getIsSinglePage() {
		return this.isSinglePage;
	}

	// --- DATABASE MAPPING : has_paging ( BIT )
	public void setHasPaging(Boolean hasPaging) {
		this.hasPaging = hasPaging;
	}

	public Boolean getHasPaging() {
		return this.hasPaging;
	}

	// --- DATABASE MAPPING : column_title_type ( VARCHAR )
	public void setColumnTitleType(String columnTitleType) {
		this.columnTitleType = columnTitleType;
	}

	public String getColumnTitleType() {
		return this.columnTitleType;
	}

	// --- DATABASE MAPPING : carrying_over_name ( VARCHAR )
	public void setCarryingOverName(String carryingOverName) {
		this.carryingOverName = carryingOverName;
	}

	public String getCarryingOverName() {
		return this.carryingOverName;
	}

	// --- DATABASE MAPPING : description ( VARCHAR )
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	// --- DATABASE MAPPING : template_rows ( TEXT )
	public void setTemplateRows(String templateRows) {
		this.templateRows = templateRows;
	}

	public String getTemplateRows() {
		return this.templateRows;
	}

	// --- DATABASE MAPPING : is_active ( BIT )
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------
	public void setListOfAdminDocumentField3(List<AdminDocumentField> listOfAdminDocumentField3) {
		this.listOfAdminDocumentField3 = listOfAdminDocumentField3;
	}

	public List<AdminDocumentField> getListOfAdminDocumentField3() {
		return this.listOfAdminDocumentField3;
	}

	public void setListOfAdminDocumentField5(List<AdminDocumentField> listOfAdminDocumentField5) {
		this.listOfAdminDocumentField5 = listOfAdminDocumentField5;
	}

	public List<AdminDocumentField> getListOfAdminDocumentField5() {
		return this.listOfAdminDocumentField5;
	}

	public void setListOfAdminDocumentField2(List<AdminDocumentField> listOfAdminDocumentField2) {
		this.listOfAdminDocumentField2 = listOfAdminDocumentField2;
	}

	public List<AdminDocumentField> getListOfAdminDocumentField2() {
		return this.listOfAdminDocumentField2;
	}

	public void setListOfAdminDocumentField4(List<AdminDocumentField> listOfAdminDocumentField4) {
		this.listOfAdminDocumentField4 = listOfAdminDocumentField4;
	}

	public List<AdminDocumentField> getListOfAdminDocumentField4() {
		return this.listOfAdminDocumentField4;
	}

	public void setListOfAdminDocumentField(List<AdminDocumentField> listOfAdminDocumentField) {
		this.listOfAdminDocumentField = listOfAdminDocumentField;
	}

	public List<AdminDocumentField> getListOfAdminDocumentField() {
		return this.listOfAdminDocumentField;
	}

	// //----------------------------------------------------------------------
	// // toString METHOD
	// //----------------------------------------------------------------------
	// public String toString() {
	// StringBuffer sb = new StringBuffer();
	// sb.append("[");
	// sb.append(id);
	// sb.append("]:");
	// sb.append(module);
	// sb.append("|");
	// sb.append(header);
	// sb.append("|");
	// sb.append(right);
	// sb.append("|");
	// sb.append(name);
	// sb.append("|");
	// sb.append(pageRows);
	// sb.append("|");
	// sb.append(reportTitleRows);
	// sb.append("|");
	// sb.append(pageTitleRows);
	// sb.append("|");
	// sb.append(detailRows);
	// sb.append("|");
	// sb.append(pageFooterRows);
	// sb.append("|");
	// sb.append(reportFooterRows);
	// sb.append("|");
	// sb.append(reportTitleLabels);
	// sb.append("|");
	// sb.append(pageTitleLabels);
	// sb.append("|");
	// sb.append(detailLabels);
	// sb.append("|");
	// sb.append(pageFooterLabels);
	// sb.append("|");
	// sb.append(reportFooterLabels);
	// sb.append("|");
	// sb.append(leftMargin);
	// sb.append("|");
	// sb.append(topMargin);
	// sb.append("|");
	// sb.append(bottomMargin);
	// sb.append("|");
	// sb.append(isSinglePage);
	// sb.append("|");
	// sb.append(hasPaging);
	// sb.append("|");
	// sb.append(columnTitleType);
	// sb.append("|");
	// sb.append(carryingOverName);
	// sb.append("|");
	// sb.append(description);
	// // attribute 'templateRows' not usable (type = String Long Text)
	// sb.append("|");
	// sb.append(isActive);
	// sb.append("|");
	// sb.append(version);
	// return sb.toString();
	// }

}
