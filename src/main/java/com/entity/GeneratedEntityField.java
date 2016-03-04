package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

import com.enums.ProjectEnum.AltanGeneratedPageName;
import com.enums.ProjectEnum.AltanKolonColumnType;
import com.enums.ProjectEnum.AltanKolonEnumerated;
import com.enums.ProjectEnum.AltanKolonFetchMode;
import com.enums.ProjectEnum.Cevap;

/**
 * @version 1.0 Jan 23, 2015
 * @author Altan Şenel
 * 
 */
@Audited
@Entity
@Table(name = "GENERATED_ENTITY_FIELD", indexes = { @Index(columnList = "generated_entity_id", name = "IND_GENERATED_ENTITY_FIELD_GENERATED_ENTITY") })
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GeneratedEntityField extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String ID = "id";
	private static String DATE = "Date";

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "generated_entity_id", foreignKey = @ForeignKey(name = "FK_GENERATED_ENTITY_FIELD_GENERATED_ENTITY"))
	private GeneratedEntity generatedEntity;

	@Column(name = "COLUMN_NAME")
	private String columnName;

	@Column(name = "COLUMN_TYPE")
	private AltanKolonColumnType columnType; // enum JoinColumn ya da Column

	@Column(name = "DATA_TYPE")
	private String dataType; // primitive de olur complex de olur ya da integer
								// long bigdecimal boolean string
	@Column(name = "DATA_NAME")
	private String dataName;

	@Column(name = "FOREIGN_KEY")
	private String foreignKey;

	@Column(name = "INDEX_NAME")
	private String indexName;

	@Column(name = "FETCH_MODE")
	private AltanKolonFetchMode fetchMode; // enum

	@Column(name = "ENUMERATED")
	private AltanKolonEnumerated enumerated; // enum

	@Column(name = "ENUM_NAME")
	private String enumName;

	@Column(name = "ONE_TO_MANY_DATA_LIST_NAME")
	private String oneToManyDataListName;

	@Column(name = "ONE_TO_MANY_LIST_EXISTS")
	private Cevap oneToManyListExists;

	@Column(name = "ONE_TO_ONE")
	private Cevap oneToOne;

	@Column(name = "MIN")
	private Cevap min;

	@Column(name = "NOT_NULL")
	private Cevap notNull = Cevap.HAYIR;

	@Column(name = "PATTERN")
	private String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Cevap getNotNull() {
		return notNull;
	}

	public void setNotNull(Cevap notNull) {
		this.notNull = notNull;
	}

	public GeneratedEntity getGeneratedEntity() {
		return generatedEntity;
	}

	public void setGeneratedEntity(GeneratedEntity generatedEntity) {
		this.generatedEntity = generatedEntity;
	}
	
	public String getColumnNameWithNotNull(String mySQLDataType) {
		if (notNull!=null && notNull.equals(Cevap.EVET)) {
			return  columnName+ " " + mySQLDataType + " NOT NULL  ";
		} else {
			return columnName + " " + mySQLDataType;
		}
		
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public AltanKolonColumnType getColumnType() {
		return columnType;
	}

	public void setColumnType(AltanKolonColumnType columnType) {
		this.columnType = columnType;
	}

	public Cevap getOneToOne() {
		return oneToOne;
	}

	public void setOneToOne(Cevap oneToOne) {
		this.oneToOne = oneToOne;
	}

	public Cevap getMin() {
		return min;
	}

	public void setMin(Cevap min) {
		this.min = min;
	}

	public String getNotNullFull() {
		if (notNull != null && notNull.equals(Cevap.EVET)) {
			return "@NotNull\n";
		} else {
			return "";
		}
	}

	public String getPatternFull() {
		if (pattern != null && !pattern.equals("")) {
			return "@Pattern(regexp=\"" + pattern + "\")\n";
		} else {
			return "";
		}
	}

	public String getColumnNameColumnTypeForeignKeyFull() {
		if (foreignKey != null && !foreignKey.isEmpty()) {
			return "@" + columnType.getAd() + "(name = \"" + columnName
					+ "\" , foreignKey = @ForeignKey(name = \"" + foreignKey
					+ "\"))\n";
		} else {
			return "@" + columnType.getAd() + "(name = \"" + columnName
					+ "\")\n";
		}
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataTypeDataNameFull() {
		if (dataName.equals(ID)) {
			return "@Id\n" + "private " + dataType + " " + dataName + ";\n\n";
		} else if (dataType.equals("Date")){
			return "private " + dataType + " " + dataName + ";\n\n"
			+ "@Transient\nprivate " + dataType + " ilk"
			+ dataName.substring(0, 1).toUpperCase()
			+ dataName.substring(1) + ";\n\n" + "@Transient\nprivate " + dataType
			+ " son" + dataName.substring(0, 1).toUpperCase()
			+ dataName.substring(1) + ";\n\n";
		} else {
			return "private " + dataType + " " + dataName + ";\n\n";
		}
	}

	public String getDataTypeDataNameFullForFilterModel() {
		if (dataType.equals(DATE)) {
			return "@Transient\nprivate " + dataType + " " + dataName + ";\n\n"
					+ "private " + dataType + " ilk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n\n" + "private " + dataType
					+ " son" + dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n\n";
		} else {
			return "private " + dataType + " " + dataName + ";\n\n";
		}

	}

	// (fetch = FetchType.LAZY)
	// @ForeignKey(name = "FK_TH_TAHSILAT_15")
	// @JoinColumn(name = "DEGISTIRILEN_POLICE_ID")
	// @Fetch(FetchMode.SELECT)
	// @Index(name = "IND_TH_TAHSILAT_NDX08")
	// private Police degistirilenPolice;

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getManyToOneFull() {
		return "@ManyToOne(fetch = FetchType.EAGER)\n";
	}

	public String getOneToManyDataListName() {
		return oneToManyDataListName;
	}

	public void setOneToManyDataListName(String oneToManyDataListName) {
		this.oneToManyDataListName = oneToManyDataListName;
	}

	public Cevap getOneToManyListExists() {
		return oneToManyListExists;
	}

	public void setOneToManyListExists(Cevap oneToManyListExists) {
		this.oneToManyListExists = oneToManyListExists;
	}

	// @OneToMany(mappedBy = "sehir", orphanRemoval=true, cascade =
	// CascadeType.ALL, fetch = FetchType.LAZY)
	// private List<Person> personList = new ArrayList<Person>();
	public String getOneToManyDataListNameFull(
			String oneToManyDataListNameElement) {
		return "@OneToMany(mappedBy = \""
				+ getGeneratedEntity().getEntity().toLowerCase()
				+ "\", orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)\n"
				+ "private List<" + oneToManyDataListNameElement + "> "
				+ oneToManyDataListNameElement.substring(0, 1).toLowerCase()
				+ oneToManyDataListNameElement.substring(1) + "List"
				+ " = new ArrayList<" + oneToManyDataListNameElement
				+ ">();\n\n";
	}

	public String getOneToManyFullForFilterModel() {
		return "private List<" + oneToManyDataListName + "> "
				+ oneToManyDataListName.toLowerCase() + " = new ArrayList<"
				+ oneToManyDataListName + ">();\n\n";
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	// @Index(name = "IND_TH_TAHSILAT_NDX08")
	public String getIndexNameFull() {
		if (indexName != null && !indexName.isEmpty()) {
			return "@Index(name = \"" + getIndexName() + "\")\n";
		} else {
			return "";
		}

	}

	public AltanKolonFetchMode getFetchMode() {
		return fetchMode;
	}

	public void setFetchMode(AltanKolonFetchMode fetchMode) {
		this.fetchMode = fetchMode;
	}

	// @Fetch(FetchMode.SELECT)
	public String getFetchModeFull() {
		if (fetchMode != null) {
			return " @Fetch(FetchMode." + getFetchMode() + ")\n";
		} else {
			return "";
		}

	}

	public AltanKolonEnumerated getEnumerated() {
		return enumerated;
	}

	public void setEnumerated(AltanKolonEnumerated enumerated) {
		this.enumerated = enumerated;
	}

	// @Enumerated(EnumType.ORDINAL)
	public String getEnumeratedFull() {
		if (enumerated != null) {
			return "@Enumerated(EnumType." + getEnumerated() + ")\n";
		} else {
			return "";
		}
	}

	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	// public enum Yon {
	// KUZEY, GUNEY, DOGU, BATI
	// }
	public String getEnumNameFull() {
		if (enumerated != null && enumName != null) {
			return "\n\n	public enum " + getDataType() + " {\n" + "		"
					+ getEnumName() + "\n" + "	}\n\n";
		} else {
			return "";
		}
	}

	// public PusulaEnum.Yon[] getYon() {
	// return PusulaEnum.Yon.values();
	// }
	public String getEnumActionFull() {
		if (enumerated != null && enumName != null) {
			return "\n\npublic ProjectEnum." + getDataType() + "[] get"
					//+ getGeneratedEntity().getEntity() 
					+ getDataType()
					+ "() {\n" + "	return ProjectEnum." + getDataType()
					+ ".values();\n" + "}\n\n";
		} else {
			return "";
		}
	}

	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	// @JoinColumn(name = "TAHSILAT_TARSIM_ENT_DETAY_ID")
	// @ForeignKey(name = "FK_TH_TAHSILAT_14")
	// @Index(name = "IND_TH_TAHSILAT_NDX07")
	// private TahsilatTarsimEntegrasyonDetay tahsilatTarsimEntegrasyonDetay;
	public String getOneToOneDataListNameFull() {
		if (oneToOne != null && oneToOne.equals(Cevap.EVET)) {
			return "@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)\n"
					+ "@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)\n";
		} else {
			return "";
		}
	}

	// @Min(value = 0)
	public String getMinFull() {
		if (min != null && min == Cevap.EVET) {
			return "@Min(value = 0)";
		} else {
			return "";
		}
	}

	public String getKolonFull() {

		String result = getNotNullFull() + getPatternFull()
				+ getColumnNameColumnTypeForeignKeyFull() + getIndexNameFull()
				+ getFetchModeFull() + getEnumeratedFull()
				+ getOneToOneDataListNameFull();

		if (
//				(oneToManyDataListName == null || oneToManyDataListName.isEmpty())
//				&& getOneToOneDataListNameFull().isEmpty() &&
				getColumnType() == AltanKolonColumnType.JOIN_COLUMN) {
			result = result + getManyToOneFull();
		}

		result = result + getDataTypeDataNameFull();

		if (oneToManyDataListName != null && !oneToManyDataListName.isEmpty()) {
			for (String oneToManyDataListNameElement : oneToManyDataListName
					.split(";")) {
				result = result
						+ getOneToManyDataListNameFull(oneToManyDataListNameElement);
			}
		}

		return result;

	}

	// public String getKolonFullForFilterModel() {
	//
	// String result = "";
	//
	// if (oneToManyDataListName != null && !oneToManyDataListName.isEmpty()) {
	// return result + getOneToManyFullForFilterModel();
	// } else {
	// return result + getDataTypeDataNameFullForFilterModel();
	// }
	//
	// }

	// public List<MakbuzTahsilat> getMakbuzTahsilatListesi() {
	// return makbuzTahsilatListesi;
	// }
	// public String getTable() {
	// return table;
	// }
	public String getKolonGetter(AltanGeneratedPageName pageName) {

		String result = "";
		if (oneToManyDataListName != null && !oneToManyDataListName.isEmpty()) {
			for (String oneToManyDataListNameElement : oneToManyDataListName
					.split(";")) {
				result = result + "public List<"
						+ oneToManyDataListNameElement
						+ "> get"
						+ oneToManyDataListNameElement.substring(0, 1)
								.toUpperCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List() {\n"
						+ "	return "
						+ oneToManyDataListNameElement.substring(0, 1)
								.toLowerCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List;\n}\n\n";
			}
		}

		if (dataType.equals(DATE)) {
			result = result + "public " + dataType + " getIlk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "() {\n" + "	return ilk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n}\n\n" + "public " + dataType
					+ " getSon" + dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "() {\n" + "	return son"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n}\n\n" + "public " + dataType
					+ " get" + dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "() {\n" + "	return " + dataName
					+ ";\n}\n\n";
		} else {
			result = result + "public " + dataType + " get"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "() {\n" + "	return " + dataName
					+ ";\n}\n\n";
		}

		return result;
	}

	// public void setMakbuzTahsilatListesi(List<MakbuzTahsilat>
	// makbuzTahsilatListesi) {
	// this.makbuzTahsilatListesi = makbuzTahsilatListesi;
	// }
	// public void setTable(String table) {
	// this.table = table;
	// }
	public String getKolonSetter(AltanGeneratedPageName pageName) {

		// public void setPersonList(List<Person> personList) {
		// this.personList = personList;
		// }

		String result = "";
		if (oneToManyDataListName != null && !oneToManyDataListName.isEmpty()) {
			for (String oneToManyDataListNameElement : oneToManyDataListName
					.split(";")) {
				result = result + "public void set"
						+ oneToManyDataListNameElement.substring(0, 1)
								.toUpperCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List(List<"
						+ oneToManyDataListNameElement
						+ "> "
						+ oneToManyDataListNameElement.substring(0, 1)
								.toLowerCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List) {\n"
						+ "	this."
						+ oneToManyDataListNameElement.substring(0, 1)
								.toLowerCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List = "
						+ oneToManyDataListNameElement.substring(0, 1)
								.toLowerCase()
						+ oneToManyDataListNameElement.substring(1)
						+ "List;\n}\n\n";
			}
		}
		if (dataType.equals(DATE)) {
			result = result + "public void setIlk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "(" + dataType + " ilk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ") {\n" + "	this.ilk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + " = ilk"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n}\n\n" + "public void setSon"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "(" + dataType + " son"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ") {\n" + "	this.son"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + " = son"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + ";\n}\n\n" + "public void set"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "(" + dataType + " " + dataName
					+ ") {\n" + "	this." + dataName + " = " + dataName
					+ ";\n}\n\n";
		} else {
			result = result + "public void set"
					+ dataName.substring(0, 1).toUpperCase()
					+ dataName.substring(1) + "(" + dataType + " " + dataName
					+ ") {\n" + "	this." + dataName + " = " + dataName
					+ ";\n}\n\n";
		 }

		return result;
	}

}
