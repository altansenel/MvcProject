package com.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.dao.IGeneratedEntityFieldService;
import com.dao.IGeneratedEntityService;
import com.entity.GeneratedEntity;
import com.entity.GeneratedEntityField;
import com.enums.ProjectEnum.AltanGeneratedPageName;
import com.enums.ProjectEnum.AltanKolonColumnType;
import com.enums.ProjectEnum.Cevap;

@ViewScoped
@ManagedBean(name = "generatedEntityController")
public class GeneratedEntityController extends BaseController<GeneratedEntity> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GeneratedEntityController.class);

	private static final String IMPORT = "import java.io.Serializable;\nimport javax.persistence.Transient;\nimport javax.persistence.Column;\nimport javax.persistence.Entity;\nimport javax.persistence.FetchType;\nimport javax.persistence.ForeignKey;\nimport javax.persistence.Index;\nimport javax.persistence.JoinColumn;\nimport javax.persistence.ManyToOne;\nimport javax.persistence.Table;\nimport javax.validation.constraints.NotNull;\nimport javax.validation.constraints.Pattern;\nimport org.hibernate.annotations.Fetch;\nimport org.hibernate.annotations.FetchMode;\nimport org.hibernate.envers.Audited;\nimport java.util.ArrayList;\nimport java.util.List;\nimport javax.persistence.CascadeType;\nimport javax.persistence.OneToMany;\nimport java.util.Date;\nimport java.math.BigDecimal;\n\n";
	private static final char NOKTA = '.';
	private static final String DOT = "\\.";
	private static final char TIRE_CHAR = '-';
	private static final String TIRE_STRING = "-";
	private GeneratedEntityField generatedEntityField;
	private String kucukHarfEntity;
	private String buyukHarfEntity;
	private String kucukHarfEntityField;
	private String buyukHarfEntityField;

	private DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

	@ManagedProperty(value = "#{generatedEntityService}")
	private IGeneratedEntityService generatedEntityService;

	@ManagedProperty(value = "#{generatedEntityFieldService}")
	private IGeneratedEntityFieldService generatedEntityFieldService;

	@Override
	public void createEntity() {// buradaa içindeki listeler de initialize
								// edilmeli, new için lazım
		GeneratedEntity generatedEntity = new GeneratedEntity();
		generatedEntity.setGeneratedEntityFieldList(new ArrayList<GeneratedEntityField>());
		setEntity(generatedEntity);
		generatedEntityField = new GeneratedEntityField();

	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<GeneratedEntity>());
	}

	@Override
	public void clean() {
		setEntity(new GeneratedEntity());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(generatedEntityService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
		generatedEntityField = new GeneratedEntityField();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.generatedEntityService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			olustur();
			if (id != null) {
				this.generatedEntityService.update(getEntity());
				setMessage("Entity is successfully updated");
				clean();

			} else {
				this.generatedEntityService.add(getEntity());
				setMessage("Entity is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void removeGeneratedEntityFieldList(Long id) {
		this.generatedEntityService.remove(id);
	}

	public void addGeneratedEntityFieldList(GeneratedEntityField generatedEntityField) {
		generatedEntityField.setGeneratedEntity(getEntity());
		this.generatedEntityFieldService.add(generatedEntityField);
	}

	public void remove(int row) {
		try {
			this.generatedEntityService.remove(getEntityList().get(row).getId());
			setMessage("Entity with id: " + getEntityList().get(row).getId() + " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.generatedEntityService.getEntityById(getEntityList().get(row).getId()));
		return "generatedEntity?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new GeneratedEntity());
		return "generatedEntity?faces-redirect=true";
	}

	public void generatedEntityFieldEkle(GeneratedEntityField generatedEntityField) {

		GeneratedEntityField generatedEntityFld = new GeneratedEntityField();
		generatedEntityFld.setGeneratedEntity(generatedEntityField.getGeneratedEntity());
		generatedEntityFld.setColumnName(generatedEntityField.getColumnName());
		generatedEntityFld.setColumnType(generatedEntityField.getColumnType());
		generatedEntityFld.setDataName(generatedEntityField.getDataName());
		generatedEntityFld.setDataType(generatedEntityField.getDataType());
		generatedEntityFld.setEnumerated(generatedEntityField.getEnumerated());
		generatedEntityFld.setEnumName(generatedEntityField.getEnumName());
		generatedEntityFld.setFetchMode(generatedEntityField.getFetchMode());
		generatedEntityFld.setForeignKey(generatedEntityField.getForeignKey());
		generatedEntityFld.setId(generatedEntityField.getId());
		generatedEntityFld.setIndexName(generatedEntityField.getIndexName());
		generatedEntityFld.setMin(generatedEntityField.getMin());
		generatedEntityFld.setOneToManyDataListName(generatedEntityField.getOneToManyDataListName());
		generatedEntityFld.setOneToOne(generatedEntityField.getOneToOne());
		generatedEntityFld.setVersion(generatedEntityField.getVersion());
		generatedEntityFld.setNotNull(generatedEntityField.getNotNull());

		getEntity().getGeneratedEntityFieldList().add(generatedEntityFld);
		generatedEntityField = new GeneratedEntityField();
		// DataBean dataBean = new DataBean();
		// dataBean.setObj(getEntity());
		// dataBean.setName("generatedEntity");
		// FacesContext.getCurrentInstance().getExternalContext().getFlash()
		// .put("obj", dataBean);
		// return "generatedEntityFieldList?faces-redirect=true&from=" +
		// pageName
		// + "&relationType=" + RelationType.manyToOne.ordinal();
	}

	public IGeneratedEntityService getGeneratedEntityService() {
		return generatedEntityService;
	}

	public void setGeneratedEntityService(IGeneratedEntityService generatedEntityService) {
		this.generatedEntityService = generatedEntityService;
	}

	public IGeneratedEntityFieldService getGeneratedEntityFieldService() {
		return generatedEntityFieldService;
	}

	public void setGeneratedEntityFieldService(IGeneratedEntityFieldService generatedEntityFieldService) {
		this.generatedEntityFieldService = generatedEntityFieldService;
	}

	public void olustur() throws ClassNotFoundException {
		kucukHarfEntity = getLastPartOfClass(getEntity().getEntity()).substring(0, 1).toLowerCase() + getLastPartOfClass(getEntity().getEntity()).substring(1);
		buyukHarfEntity = getLastPartOfClass(getEntity().getEntity());
		generatedEntityEntityJavaOlustur(getEntity());
		generatedEntityControllerOlustur(getEntity());
		generatedEntityIDaoOlustur(getEntity());
		generatedEntityDaoImplOlustur(getEntity());
		generatedEntityIServiceOlustur(getEntity());
		generatedEntityServiceImplOlustur(getEntity());
		generatedEntityXHtmlOlustur(getEntity());
		generatedEntityListXHtmlOlustur(getEntity());
		generatedEntityConverterOlustur(getEntity());
		
		//generatedEntityMessagesOlustur(getEntity());

		generatedEntityScriptOlustur(getEntity());
		generatedEntityApplicationContextOlustur(getEntity());
		generatedEntitySecurityConfigOlustur(getEntity());
		generatedEntityProjectEnumOlustur(getEntity());
		generatedEntityProjectEnumActionOlustur(getEntity());
	}

	public void olustur2() throws ClassNotFoundException {
		for (GeneratedEntity generatedEntity : generatedEntityService.list()) {
			setEntity(generatedEntity);
			if (getEntity().getEntity().equals("User") || getEntity().getEntity().equals("RoleUser") || getEntity().getEntity().equals("Menu")) {

			} else if (getEntity().getEntity().equals("Sinif") || getEntity().getEntity().equals("Dolap")
					|| getEntity().getEntity().equals("Ogrenci") || getEntity().getEntity().equals("Kitap") 
					|| getEntity().getEntity().equals("Alisveris")) {
				olustur();
			}
		}
	}

	public void generatedEntityProjectEnumOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.PUSULA_ENUM;
		String result = "";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			result = result + generatedEntityField.getEnumNameFull();
		}
		if (!result.isEmpty()) {
			dosyaOlustur(result, getLastPartOfClass(generatedEntity.getEntity()), pageName);
		}

	}

	public void generatedEntityProjectEnumActionOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.ENUM_ACTION;
		String result = "";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			result = result + generatedEntityField.getEnumActionFull();
		}
		if (!result.isEmpty()) {
			dosyaOlustur(result, getLastPartOfClass(generatedEntity.getEntity()), pageName);
		}

	}

	public void generatedEntityApplicationContextOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.APPLICATION_TXT;
		String result = "<beans:bean id=\"" + kucukHarfEntity + "DAO\" class=\"com.dao." + buyukHarfEntity + "DaoImpl\">"
				+ "<beans:property name=\"sessionFactory\" ref=\"hibernate4AnnotatedSessionFactory\" />" + "</beans:bean>" + "<beans:bean id=\""
				+ kucukHarfEntity + "Service\" class=\"com.dao." + buyukHarfEntity + "ServiceImpl\">" + "<beans:property name=\"entityDAO\" ref=\""
				+ kucukHarfEntity + "DAO\"></beans:property>" + "</beans:bean>";

		dosyaOlustur(result, kucukHarfEntity, pageName);
	}

	public void generatedEntitySecurityConfigOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.SECURITY_TXT;
		String result = "<sec:intercept-url pattern=\"/" + kucukHarfEntity + "List**\" access=\"hasAnyRole('ROLE_" + kucukHarfEntity.toUpperCase()
				+ "_VIEW','ROLE_ADMIN')\" />" + "<sec:intercept-url pattern=\"/" + kucukHarfEntity + "**\" access=\"hasAnyRole('ROLE_"
				+ kucukHarfEntity.toUpperCase() + "_ADD','ROLE_" + kucukHarfEntity.toUpperCase() + "_UPDATE','ROLE_ADMIN')\" />";

		dosyaOlustur(result, kucukHarfEntity, pageName);
	}

	public void generatedEntityScriptOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.SCRIPT_TXT;
		String result = "       create table " + generatedEntity.getTable() + " (\n" + "		   id BIGINT  NOT NULL AUTO_INCREMENT,\n";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {

			if (generatedEntityField.getDataType().equals("String")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("VARCHAR(100)") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("Long")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("BIGINT") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("Integer")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("INT") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("Boolean")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("TINYINT(1)") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("Date")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("DATE") + " ,\n";
			}
			if (generatedEntityField.getDataType().equals("Timestamp")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("DATETIME") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("BigDecimal")) {
				result = result + generatedEntityField.getColumnNameWithNotNull("DECIMAL(10,2)") + "  ,\n";
			}
			if (generatedEntityField.getDataType().equals("String") || generatedEntityField.getDataType().equals("Long")
					|| generatedEntityField.getDataType().equals("Integer") || generatedEntityField.getDataType().equals("Boolean")
					|| generatedEntityField.getDataType().equals("Date") || generatedEntityField.getDataType().equals("Timestamp")
					|| generatedEntityField.getDataType().equals("BigDecimal")) {

			} else {
				result = result + generatedEntityField.getColumnNameWithNotNull("BIGINT") + "  ,\n";
			}

		}
		result = result + "		    version BIGINT default'0',\n" + "		   PRIMARY KEY ( id )\n" + "		);\n";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			if (generatedEntityField.getDataType().equals("String") || generatedEntityField.getDataType().equals("Long")
					|| generatedEntityField.getDataType().equals("Integer") || generatedEntityField.getDataType().equals("Boolean")
					|| generatedEntityField.getDataType().equals("Date") || generatedEntityField.getDataType().equals("Timestamp")
					|| generatedEntityField.getDataType().equals("BigDecimal") || generatedEntityField.getEnumerated() != null) {

			} else {

				result = result + "		ALTER TABLE " + generatedEntity.getTable() + "\n" + "		ADD CONSTRAINT FK_" + generatedEntity.getTable() + "_"
						+ generatedEntityService.getEntityByEntityName(generatedEntityField.getDataType()).getTable() + " foreign key ("
						+ generatedEntityField.getColumnName() + ")\n" + "		  references "
						+ generatedEntityService.getEntityByEntityName(generatedEntityField.getDataType()).getTable() + " (ID);\n";
			}
		}

		result = result + "       create table " + generatedEntity.getTable() + "_v (\n" + "		REV BIGINT  NOT NULL,\n" + "		REVTYPE BIGINT ,\n"
				+ "		   id BIGINT  NOT NULL AUTO_INCREMENT,\n";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {

			if (generatedEntityField.getDataType().equals("String")) {
				result = result + generatedEntityField.getColumnName() + "             VARCHAR(100) ,\n";
			}
			if (generatedEntityField.getDataType().equals("Long")) {
				result = result + generatedEntityField.getColumnName() + "              BIGINT ,\n";
			}
			if (generatedEntityField.getDataType().equals("Integer")) {
				result = result + generatedEntityField.getColumnName() + "              INT ,\n";
			}
			if (generatedEntityField.getDataType().equals("Boolean")) {
				result = result + generatedEntityField.getColumnName() + "               TINYINT(1) ,\n";
			}
			if (generatedEntityField.getDataType().equals("Date")) {
				result = result + generatedEntityField.getColumnName() + "              DATE ,\n";
			}
			if (generatedEntityField.getDataType().equals("Timestamp")) {
				result = result + generatedEntityField.getColumnName() + "              DATETIME ,\n";
			}
			if (generatedEntityField.getDataType().equals("BigDecimal")) {
				result = result + generatedEntityField.getColumnName() + "              DECIMAL(10,2) ,\n";
			}
			if (generatedEntityField.getDataType().equals("String") || generatedEntityField.getDataType().equals("Long")
					|| generatedEntityField.getDataType().equals("Integer") || generatedEntityField.getDataType().equals("Boolean")
					|| generatedEntityField.getDataType().equals("Date") || generatedEntityField.getDataType().equals("Timestamp")
					|| generatedEntityField.getDataType().equals("BigDecimal")) {

			} else {
				result = result + generatedEntityField.getColumnName() + "             BIGINT ,\n";
			}

		}
		result = result + "		    version bigint default'0',\n" + "		   PRIMARY KEY ( id, REV )\n" + "		);\n";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			if (generatedEntityField.getDataType().equals("String") || generatedEntityField.getDataType().equals("Long")
					|| generatedEntityField.getDataType().equals("Integer") || generatedEntityField.getDataType().equals("Boolean")
					|| generatedEntityField.getDataType().equals("Date") || generatedEntityField.getDataType().equals("Timestamp")
					|| generatedEntityField.getDataType().equals("BigDecimal") || generatedEntityField.getEnumerated() != null) {

			} else {
				// bu hata yüzünden kaldırdım: Cannot delete or update a parent row: a foreign key constraint fails (`deneme`.`order_detail_v`, CONSTRAINT
				// `FK_ORDER_DETAIL_v_ORDER` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`))

				// result = result
				// + " ALTER TABLE "
				// + generatedEntity.getTable()
				// + "_v \n"
				// + " ADD CONSTRAINT FK_"
				// + generatedEntity.getTable()
				// + "_v_"
				// + generatedEntityService.getEntityByEntityName(
				// generatedEntityField.getDataType()).getTable()
				// + " foreign key ("
				// + generatedEntityField.getColumnName()
				// + ")\n"
				// + " references "
				// + generatedEntityService.getEntityByEntityName(
				// generatedEntityField.getDataType()).getTable()
				// + " (ID);\n";
			}
		}

		result = result + "insert into PERMISSIONS (name) values ('ROLE_" + buyukHarfEntity.toUpperCase() + "_VIEW'); \n"
				+ "insert into PERMISSIONS (name) values ('ROLE_" + buyukHarfEntity.toUpperCase() + "_ADD'); \n"
				+ "insert into PERMISSIONS (name) values ('ROLE_" + buyukHarfEntity.toUpperCase() + "_EDIT'); \n"
				+ "insert into PERMISSIONS (name) values ('ROLE_" + buyukHarfEntity.toUpperCase() + "_REMOVE'); \n"
				+ "insert into menu(name,link,sira,permission_id,parent_id,version) values ('" + buyukHarfEntity + " List','" + kucukHarfEntity
				+ "List.xhtml',11,(select id from PERMISSIONS where name = 'ROLE_" + buyukHarfEntity.toUpperCase() + "_VIEW'),5,0);\n\n";

		dosyaOlustur(result, kucukHarfEntity, pageName);
	}

	public void generatedEntityListXHtmlOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.LIST_XHTML;
		String result = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
				+ "<ui:composition xmlns= \"http://www.w3.org/1999/xhtml\"" + "	xmlns:ui=\"http://java.sun.com/jsf/facelets\""
				+ "	xmlns:h=\"http://java.sun.com/jsf/html\"" + "	xmlns:f=\"http://java.sun.com/jsf/core\""
				+ "	xmlns:c=\"http://java.sun.com/jsp/jstl/core\"" + "	xmlns:spring=\"http://www.springframework.org/tags\""
				+ "	xmlns:form=\"http://www.springframework.org/tags/form\"" + "	xmlns:sec=\"http://www.springframework.org/security/tags\""
				+ "	xmlns:r=\"http://richfaces.org/rich\" xmlns:a=\"http://richfaces.org/a4j\""
				+ "	xmlns:p=\"http://primefaces.org/ui\" xmlns:gns=\"customtaglib\"" + "	template=\"/basic/template.xhtml\">"
				+ "	<ui:define name=\"content\">" + "		<h:form id=\"main\" class=\"form-horizontal\" role=\"form\">"
				+ "			<h:outputText value=\"#{" + kucukHarfEntity + "Controller.message}\"" + "				rendered=\"#{not empty " + kucukHarfEntity
				+ "Controller.message}\" /><r:messages globalOnly=\"true\" styleClass=\"message\" ajaxRendered=\"true\" /><div class=\"panel-group\">"
				+ "			<ui:decorate template=\"/basic/panel.xhtml\">" + "			<ui:param name=\"panelHeading\" value=\"" + buyukHarfEntity
				+ " List\" />" + "			<ui:param name=\"inputHidden\" value=\"#{" + kucukHarfEntity + "Controller.entity.id}\" />"
				+ "			<ui:param name=\"left\" value=\"true\" />" + "			<ui:param name=\"right\" value=\"true\" />"
				+ "			<ui:define name=\"leftPanel\">" + "				<c:if test=\"${!empty " + kucukHarfEntity + "Controller.entity.id}\">"
				+ "				<ui:decorate template=\"/basic/row.xhtml\">" + "					<ui:param name=\"label\" value=\"Id\" />"
				+ "					<ui:param name=\"id\" value=\"id\" />" + "					<ui:param name=\"inputText\" value=\"#{" + kucukHarfEntity
				+ "Controller.entity.id}\" />" + "					<ui:param name=\"errorPath\" value=\"id\" />" + "				</ui:decorate>"
				+ "				</c:if>	";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			generatedEntityField.setGeneratedEntity(generatedEntity);
			if (getLastPartOfClass(generatedEntityField.getDataType()).equals("String")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Integer")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Long")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("BigDecimal")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Double")) {
				result = result + "						<ui:decorate template=\"/basic/row.xhtml\">" + "					<ui:param name=\"label\" value=\""
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
						+ "					<ui:param name=\"id\" value=\"" + generatedEntityField.getDataName() + "\" />"
						+ "					<ui:param name=\"inputText\"" + "						value=\"#{" + kucukHarfEntity + "Controller.entity."
						+ generatedEntityField.getDataName() + "}\" />" + "					<ui:param name=\"errorPath\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"validatorMessage\""
						+ "						value=\"Bu alanı doldurmak zorundasınız!\" />" + "					</ui:decorate>";
			} else if (getLastPartOfClass(generatedEntityField.getDataType()).equals("Boolean")) {
				result = result + "						<ui:decorate template=\"/basic/rowBoolean.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\"" + "						value=\"#{"
						+ kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />" + "					</ui:decorate>";
			} else if (getLastPartOfClass(generatedEntityField.getDataType()).equals("Date")) {
				result = result + "						<ui:decorate template=\"/basic/rowDate.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\"" + "						value=\"#{"
						+ kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />" + "					</ui:decorate>";
				result = result + "						<ui:decorate template=\"/basic/rowDate.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"ilk " + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\"ilk"
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
						+ "					<ui:param name=\"inputText\"" + "						value=\"#{" + kucukHarfEntity + "Controller.entity.ilk"
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "}\" />"
						+ "					</ui:decorate>";
				result = result + "						<ui:decorate template=\"/basic/rowDate.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"son " + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\"son"
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
						+ "					<ui:param name=\"inputText\"" + "						value=\"#{" + kucukHarfEntity + "Controller.entity.son"
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "}\" />"
						+ "					</ui:decorate>";
			} else {
				if (generatedEntityField.getEnumerated() != null) {
					result = result + "<ui:decorate template=\"/basic/rowSelectOneMenu.xhtml\">" + "<ui:param name=\"label\" value=\""
							+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
							+ "<ui:param name=\"id\" value=\"" + generatedEntityField.getDataName() + "\" />" + "<ui:param name=\"selectOneMenu\""
							+ "	value=\"#{" + kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />"
							+ "<ui:param name=\"selectItems\"" + "	value=\"#{projectEnumAction.get" 
							//+ buyukHarfEntity
							+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "()}\" />"
							+ "<ui:param name=\"validatorMessage\"" + "	value=\"Bu alanı doldurmak zorundasınız!\" />" + "</ui:decorate>";
				} else {
					result = result + "						<ui:decorate template=\"/basic/rowManyToOne.xhtml\">"
							+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
							+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
							+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\""
							+ "						value=\"#{" + kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />"
							+ "					<ui:param name=\"errorPath\" value=\"" + generatedEntityField.getDataName() + "\" />"
							+ "					<ui:param name=\"converter\" value=\"#{" + generatedEntityField.getDataType().substring(0, 1).toLowerCase()
							+ generatedEntityField.getDataType().substring(1) + "Converter}\" />" + "					<ui:param name=\"validatorMessage\""
							+ "						value=\"Bu alanı doldurmak zorundasınız!\" />"
							+ "					<ui:param name=\"controllerMethod\" value=\"add"
							+ generatedEntityField.getDataType().substring(0, 1).toUpperCase() + generatedEntityField.getDataType().substring(1)
							+ "ManyToOne\" />" + "		<ui:param name=\"controller\" value=\"#{" + kucukHarfEntity + "Controller}\" />"
							+ "       <ui:param name=\"controllerMethodArgument\" value=\"" + kucukHarfEntity + "List\" />" + "					</ui:decorate>";

				}
			}
		}
		result = result + "</ui:define>" + "<ui:define name=\"rightPanel\">";

		result = result + "<ui:decorate template=\"/basic/rowTable.xhtml\">" + "<ui:define name=\"table\">" + "	<a:outputPanel ajaxRendered=\"true\">"
				+ "		<r:accordion rendered=\"#{" + kucukHarfEntity + "Controller.entityList.size() > 0}\">" + "			<r:accordionItem header=\""
				+ buyukHarfEntity + " List\">" + "				<h:panelGrid columns=\"1\">" + "					<r:dataTable id=\"" + kucukHarfEntity
				+ "List\" var=\"entity\" class=\"tg\"" + "						rendered=\"#{" + kucukHarfEntity + "Controller.entityList.size() > 0}\""
				+ "						value=\"#{" + kucukHarfEntity + "Controller.entityList}\" width=\"100%\" rows=\"10\""
				+ "						rowKeyVar=\"rkv\">" + "						<r:column sortable=\"true\">"
				+ "							<f:facet name=\"header\">" + "								<h:outputText value=\"Id\" />"
				+ "							</f:facet>" + "							<h:outputText value=\"#{entity.id}\" />"
				+ "						</r:column>";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			result = result + "		<r:column sortable=\"true\">" + "							<f:facet name=\"header\">"
					+ "								<h:outputText value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
					+ generatedEntityField.getDataName().substring(1) + "\" />" + "							</f:facet>"
					+ "							<h:outputText value=\"#{entity." + generatedEntityField.getDataName() + "}\" />"
					+ "						</r:column>";
		}

		result = result + "<sec:authorize access=\"hasAnyRole('ROLE_ADMIN','ROLE_" + kucukHarfEntity.toUpperCase() + "_EDIT')\">"
				+ "						<r:column>" + "							<f:facet name=\"header\">"
				+ "								<h:outputText value=\"Edit\" />" + "							</f:facet>"
				+ "							<h:link outcome=\"" + kucukHarfEntity + "?faces-redirect=true\">"
				+ "								<h:graphicImage alt=\"güncelle\" title=\"güncelle\""
				+ "									name=\"/images/form_edit.png\" />"
				+ "								<f:param name=\"entityId\" value=\"#{entity.id}\" />" + "							</h:link>"
				+ "						</r:column>" + "</sec:authorize>" + "			<sec:authorize access=\"hasAnyRole('ROLE_ADMIN','ROLE_"
				+ kucukHarfEntity.toUpperCase() + "_REMOVE')\">" + "							<r:column>"
				+ "								<f:facet name=\"header\">" + "									<h:outputText value=\"Delete\" />"
				+ "								</f:facet>" + "								<a:commandLink status=\"commonAjaxStatus\""
				+ "									action=\"#{" + kucukHarfEntity + "Controller.remove(rkv)}\">"
				+ "									<h:graphicImage alt=\"sil\" title=\"sil\""
				+ "										name=\"/images/form_delete.png\" />" + "								</a:commandLink>"
				+ "							</r:column>" + "						</sec:authorize>" + "						<r:column rendered=\"#{!empty "
				+ kucukHarfEntity + "Controller.dataBean.parentDataBean}\">" + "							<f:facet name=\"header\">"
				+ "								<h:outputText value=\"Select\" />" + "							</f:facet>"
				+ "							<a:commandLink status=\"commonAjaxStatus\"" + "								action=\"#{" + kucukHarfEntity
				+ "Controller.select(rkv)}\">" + "								<h:graphicImage alt=\"select\" title=\"select\""
				+ "									name=\"/images/form_select.png\" />" + "							</a:commandLink>"
				+ "						</r:column>" + "						<f:facet name=\"footer\">"
				+ "							<r:dataScroller renderIfSinglePage=\"false\"" + "								ajaxSingle=\"true\" />"
				+ "						</f:facet>" + "					</r:dataTable>" + "				</h:panelGrid>" + "			</r:accordionItem>"
				+ "		</r:accordion>" + "	</a:outputPanel>" +

		"</ui:define>" + "</ui:decorate>";

		result = result + "					</ui:define>" + "					<ui:define name=\"buttonPanel\">" + "						<div class=\"row\">"
				+ "							<div class=\"col-sm-2\">" + "								<div class=\"panel panel-default\">"
				+ "									<div class=\"row\">" + "<div class=\"col-xs-6\">"
				+ "<h:commandButton styleClass=\"button\" value=\"Search\"" + "	class=\"form-control\" action=\"#{" + kucukHarfEntity
				+ "Controller.search()}\" />" + "</div>" + "<div class=\"col-xs-6\">" + "<sec:authorize access=\"hasAnyRole('ROLE_ADMIN','ROLE_"
				+ kucukHarfEntity.toUpperCase() + "_ADD')\">" + "	<h:commandButton styleClass=\"button\" value=\"New\""
				+ "		class=\"form-control\" action=\"#{" + kucukHarfEntity + "Controller.newEntity()}\" />" + "</sec:authorize>" + "</div>"

		// + " <div class=\"col-xs-4\"> "
		// + " <h:commandButton styleClass=\"button\" value=\"Clean\" "
		// + " class=\"form-control\" "
		// + " action=\"#{" + kucukHarfEntity + "Controller.clean()}\" />"
		// + " </div>"+

				+ "									</div>" + "								</div>" + "							</div>"
				+ "						</div>" + "					</ui:define>" + "				</ui:decorate>" + "			</div>" + "			<br />"
				+ "			<br />" + "		</h:form>" + "	</ui:define>" + "</ui:composition>";

		dosyaOlustur(result, kucukHarfEntity, pageName);

	}

	public void generatedEntityXHtmlOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.XHTML;
		String result = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
				+ "<ui:composition xmlns= \"http://www.w3.org/1999/xhtml\"" + "	xmlns:ui=\"http://java.sun.com/jsf/facelets\""
				+ "	xmlns:h=\"http://java.sun.com/jsf/html\"" + "	xmlns:f=\"http://java.sun.com/jsf/core\""
				+ "	xmlns:c=\"http://java.sun.com/jsp/jstl/core\"" + "	xmlns:spring=\"http://www.springframework.org/tags\""
				+ "	xmlns:form=\"http://www.springframework.org/tags/form\"" + "	xmlns:sec=\"http://www.springframework.org/security/tags\""
				+ "	xmlns:r=\"http://richfaces.org/rich\" xmlns:a=\"http://richfaces.org/a4j\""
				+ "	xmlns:p=\"http://primefaces.org/ui\" xmlns:gns=\"customtaglib\"" + "	template=\"/basic/template.xhtml\">"
				+ "	<ui:define name=\"content\">" + "		<h:form id=\"main\" class=\"form-horizontal\" role=\"form\">"
				+ "			<h:outputText value=\"#{" + kucukHarfEntity + "Controller.message}\"" + "				rendered=\"#{not empty " + kucukHarfEntity
				+ "Controller.message}\" /><r:messages globalOnly=\"true\" styleClass=\"message\" ajaxRendered=\"true\" /><div class=\"panel-group\">"
				+ "			<ui:decorate template=\"/basic/panel.xhtml\">" + "			<ui:param name=\"panelHeading\" value=\"" + buyukHarfEntity + "\" />"
				+ "			<ui:param name=\"inputHidden\" value=\"#{" + kucukHarfEntity + "Controller.entity.id}\" />"
				+ "			<ui:param name=\"left\" value=\"true\" />" + "			<ui:param name=\"right\" value=\"true\" />"
				+ "			<ui:define name=\"leftPanel\">" + "				<c:if test=\"${!empty " + kucukHarfEntity + "Controller.entity.id}\">"
				+ "				<ui:decorate template=\"/basic/row.xhtml\">" + "					<ui:param name=\"label\" value=\"Id\" />"
				+ "<ui:param name=\"readOnlyMi\" value=\"true\" />" + "					<ui:param name=\"id\" value=\"id\" />"
				+ "					<ui:param name=\"inputText\" value=\"#{" + kucukHarfEntity + "Controller.entity.id}\" />"
				+ "					<ui:param name=\"errorPath\" value=\"id\" />" + "				</ui:decorate>" + "				</c:if>	";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			generatedEntityField.setGeneratedEntity(generatedEntity);
			if (getLastPartOfClass(generatedEntityField.getDataType()).equals("String")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Integer")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Long")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("BigDecimal")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Double")) {
				result = result + "						<ui:decorate template=\"/basic/row.xhtml\">" + "					<ui:param name=\"label\" value=\""
						+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
						+ "					<ui:param name=\"id\" value=\"" + generatedEntityField.getDataName() + "\" />"
						+ "					<ui:param name=\"inputText\"" + "						value=\"#{" + kucukHarfEntity + "Controller.entity."
						+ generatedEntityField.getDataName() + "}\" />" + "					<ui:param name=\"errorPath\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"validatorMessage\""
						+ "						value=\"Bu alanı doldurmak zorundasınız!\" />" + "					</ui:decorate>";
			} else if (getLastPartOfClass(generatedEntityField.getDataType()).equals("Boolean")) {
				result = result + "						<ui:decorate template=\"/basic/rowBoolean.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\"" + "						value=\"#{"
						+ kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />" + "					</ui:decorate>";
			} else if (getLastPartOfClass(generatedEntityField.getDataType()).equals("Date")) {
				result = result + "						<ui:decorate template=\"/basic/rowDate.xhtml\">"
						+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
						+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
						+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\"" + "						value=\"#{"
						+ kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />" + "					</ui:decorate>";
			} else {
				if (generatedEntityField.getEnumerated() != null) {
					result = result + "<ui:decorate template=\"/basic/rowSelectOneMenu.xhtml\">" + "<ui:param name=\"label\" value=\""
							+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "\" />"
							+ "<ui:param name=\"id\" value=\"" + generatedEntityField.getDataName() + "\" />" + "<ui:param name=\"selectOneMenu\""
							+ "	value=\"#{" + kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />"
							+ "<ui:param name=\"selectItems\"" + "	value=\"#{projectEnumAction.get" 
							//+ buyukHarfEntity
							+ generatedEntityField.getDataName().substring(0, 1).toUpperCase() + generatedEntityField.getDataName().substring(1) + "()}\" />"
							+ "<ui:param name=\"validatorMessage\"" + "	value=\"Bu alanı doldurmak zorundasınız!\" />" + "</ui:decorate>";

				} else {
					result = result + "						<ui:decorate template=\"/basic/rowManyToOne.xhtml\">"
							+ "					<ui:param name=\"label\" value=\"" + generatedEntityField.getDataName().substring(0, 1).toUpperCase()
							+ generatedEntityField.getDataName().substring(1) + "\" />" + "					<ui:param name=\"id\" value=\""
							+ generatedEntityField.getDataName() + "\" />" + "					<ui:param name=\"inputText\""
							+ "						value=\"#{" + kucukHarfEntity + "Controller.entity." + generatedEntityField.getDataName() + "}\" />"
							+ "					<ui:param name=\"errorPath\" value=\"" + generatedEntityField.getDataName() + "\" />"
							+ "					<ui:param name=\"converter\" value=\"#{" + generatedEntityField.getDataType().substring(0, 1).toLowerCase()
							+ generatedEntityField.getDataType().substring(1) + "Converter}\" />" + "					<ui:param name=\"validatorMessage\""
							+ "						value=\"Bu alanı doldurmak zorundasınız!\" />"
							+ "					<ui:param name=\"controllerMethod\" value=\"add"
							+ generatedEntityField.getDataType().substring(0, 1).toUpperCase() + generatedEntityField.getDataType().substring(1)
							+ "ManyToOne\" />" + "		<ui:param name=\"controller\" value=\"#{" + kucukHarfEntity + "Controller}\" />"
							+ "       <ui:param name=\"controllerMethodArgument\" value=\"" + kucukHarfEntity + "\" />" + "					</ui:decorate>";

				}
			}
		}
		result = result + "</ui:define>" + "<ui:define name=\"rightPanel\">";

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			for (String oneToManyDataListNameElement : generatedEntityField.getOneToManyDataListName().split(";")) {
				if (!oneToManyDataListNameElement.isEmpty() && generatedEntityField.getOneToManyListExists().equals(Cevap.EVET)) {
					String oneToManyDataListNameElementKucukHarf = oneToManyDataListNameElement.substring(0, 1).toLowerCase()
							+ oneToManyDataListNameElement.substring(1);
					result = result + "					<ui:decorate template=\"/basic/rowComplex.xhtml\">"
							+ "					<ui:param name=\"label\" value=\"Add " + oneToManyDataListNameElementKucukHarf + "\" />"
							+ "					<ui:param name=\"controller\" value=\"#{" + kucukHarfEntity + "Controller}\" />"
							+ "					<ui:param name=\"controllerMethod\" value=\"" + oneToManyDataListNameElementKucukHarf + "EkleOneToMany\" />"
							+ "					<ui:param name=\"controllerMethodArgument\" value=\"" + kucukHarfEntity + "\" />"
							+ "					<ui:define name=\"table\">" + "					<a:outputPanel ajaxRendered=\"true\">"
							+ "					<r:accordion" + "					rendered=\"#{" + kucukHarfEntity + "Controller.entity."
							+ oneToManyDataListNameElementKucukHarf + "List.size() > 0}\">" + "					<r:accordionItem header=\""
							+ oneToManyDataListNameElement + " List\">" + "					<h:panelGrid columns=\"1\">"
							+ "					<r:dataTable id=\"" + oneToManyDataListNameElementKucukHarf + "List\" var=\"entity\" class=\"tg\""
							+ "											rendered=\"#{" + kucukHarfEntity + "Controller.entity."
							+ oneToManyDataListNameElementKucukHarf + "List.size() > 0}\"" + "						value=\"#{" + kucukHarfEntity
							+ "Controller.entity." + oneToManyDataListNameElementKucukHarf + "List}\" width=\"100%\""
							+ "						rows=\"3\" rowKeyVar=\"rkv\">" + "						<r:column sortable=\"true\">"
							+ "							<f:facet name=\"header\">" + "								<h:outputText value=\"Id\" />"
							+ "														</f:facet>"
							+ "							<h:outputText value=\"#{entity.id}\" />" + "						</r:column>";
					int counter = 0; // bu tablodaki eleman sayısını sınırlamak
										// için
					for (GeneratedEntityField oneToManyDataListNameElementGeneratedEntityField : generatedEntityService.getEntityByEntityName(oneToManyDataListNameElement).getGeneratedEntityFieldList()) {
						if (oneToManyDataListNameElementGeneratedEntityField.equals("id")) {

						} else {
							counter++;
						}
						if (counter <= 2) {
							result = result + "						<r:column sortable=\"true\">" + "							<f:facet name=\"header\">"
									+ "								<h:outputText value=\""
									+ oneToManyDataListNameElementGeneratedEntityField.getDataName().substring(0, 1).toUpperCase()
									+ oneToManyDataListNameElementGeneratedEntityField.getDataName().substring(1) + "\" />"
									+ "							</f:facet>" + "							<h:outputText value=\"#{entity."
									+ oneToManyDataListNameElementGeneratedEntityField.getDataName() + "}\" />" + "						</r:column>";
						}
					}

					result = result + "						<sec:authorize access=\"hasRole('ROLE_ADMIN')\">"
							+ "												<r:column>" + "								<f:facet name=\"header\">"
							+ "									<h:outputText value=\"Delete\" />" + "					</f:facet>"
							+ "					<a:commandLink status=\"commonAjaxStatus\"" + "					action=\"#{" + kucukHarfEntity
							+ "Controller.remove" + oneToManyDataListNameElement + "(rkv)}\">" + "					<h:graphicImage alt=\"sil\" title=\"sil\""
							+ "										name=\"/images/form_delete.png\" />" + "								</a:commandLink>"
							+ "							</r:column>" + "						</sec:authorize>"
							+ "						<f:facet name=\"footer\">" + "							<r:dataScroller renderIfSinglePage=\"false\""
							+ "								ajaxSingle=\"true\" />" + "						</f:facet>" + "					</r:dataTable>"
							+ "					</h:panelGrid>" + "										</r:accordionItem>" + "					</r:accordion>"
							+ "					</a:outputPanel>" + "					</ui:define>" + "					</ui:decorate>";
				}
			}
		}

		result = result + "					</ui:define>" + "					<ui:define name=\"buttonPanel\">" + "						<div class=\"row\">"
				+ "							<div class=\"col-sm-2\">" + "								<div class=\"panel panel-default\">"
				+ "									<div class=\"row\">" + "										<div class=\"col-xs-6\">"
				+ "											<h:commandButton styleClass=\"button\" value=\"Save\" id=\"doSave\""
				+ "												class=\"form-control\"" + "												action=\"#{"
				+ kucukHarfEntity + "Controller.save(" + kucukHarfEntity + "Controller.entity.id)}\" />" + "										</div>"
				+ "										<div class=\"col-xs-6\">" + "											<h:link value=\""
				+ buyukHarfEntity + " List\" class=\"form-control\"" + "												outcome=\"" + kucukHarfEntity
				+ "List?faces-redirect=true\" styleClass=\"button\" />" + "										</div>"

		// + " <div class=\"col-xs-4\"> "
		// + " <h:commandButton styleClass=\"button\" value=\"Clean\" "
		// + " class=\"form-control\" "
		// + " action=\"#{" + kucukHarfEntity + "Controller.clean()}\" />"
		// + " </div>"

				+ "									</div>" + "								</div>" + "							</div>"
				+ "						</div>" + "					</ui:define>" + "				</ui:decorate>" + "			</div>" + "			<br />"
				+ "			<br />" + "		</h:form>" + "	</ui:define>" + "</ui:composition>";

		dosyaOlustur(result, kucukHarfEntity, pageName);

	}

	public void generatedEntityIDaoOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.DAO_INTERFACE_JAVA;
		String result = pageName.getPaket() + "import com.entity." + buyukHarfEntity + ";\n\n";
		result = result + "public interface I" + generatedEntity.getEntity() + "Dao extends IBaseDao<" + buyukHarfEntity + ">{\n";
		result = result + "}\n";
		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public void generatedEntityIServiceOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.SERVICE_INTERFACE_JAVA;
		String result = pageName.getPaket() + "import com.entity." + buyukHarfEntity + ";\n\n";
		result = result + "public interface I" + generatedEntity.getEntity() + "Service extends IBaseService<" + buyukHarfEntity + ">{\n";
		result = result + "}\n";
		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public void generatedEntityDaoImplOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.DAO_IMPL_JAVA;
		String result = pageName.getPaket() + "import org.springframework.stereotype.Repository;\n" + "import com.entity." + buyukHarfEntity + ";\n\n";
		result = result + "@Repository\npublic class " + generatedEntity.getEntity() + "DaoImpl extends BaseDaoImpl<" + buyukHarfEntity + "> implements I"
				+ buyukHarfEntity + "Dao {\n";
		result = result + "private static final long serialVersionUID = 1L;\n}\n";
		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public void generatedEntityServiceImplOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.SERVICE_IMPL_JAVA;
		String result = pageName.getPaket() + "import org.springframework.stereotype.Service;\n" + "import com.entity." + buyukHarfEntity + ";\n\n";
		result = result + "@Service\npublic class " + generatedEntity.getEntity() + "ServiceImpl extends BaseServiceImpl<" + buyukHarfEntity + ", I"
				+ buyukHarfEntity + "Dao> implements I" + buyukHarfEntity + "Service {\n";
		result = result + "private static final long serialVersionUID = 1L;\n\n";
		result = result + "\n}\n";
		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public void generatedEntityControllerOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.CONTROLLER_JAVA;
		String result = pageName.getPaket();
		result = result
				+ "import java.io.Serializable;\nimport java.util.ArrayList;\nimport javax.annotation.PostConstruct;\nimport javax.faces.bean.ManagedBean;\nimport javax.faces.bean.ManagedProperty;\nimport javax.faces.bean.ViewScoped;\nimport javax.faces.context.FacesContext;\nimport org.apache.log4j.Logger;\nimport com.dao.I"
				+ buyukHarfEntity + "Service;\nimport com.entity." + buyukHarfEntity
				+ ";\nimport com.enums.ProjectEnum.RelationType;\nimport com.enums.ProjectEnum.AddSelect;\n\n";
		result = result + "@ViewScoped\n@ManagedBean(name = \"" + kucukHarfEntity + "Controller\")\npublic class " + generatedEntity.getEntity()
				+ "Controller extends BaseController<" + buyukHarfEntity + "> implements Serializable" + "{\n";
		result = result + "private static final long serialVersionUID = 1L;\nprivate static final Logger logger = Logger.getLogger(" + buyukHarfEntity
				+ "Controller.class);\n" + "@ManagedProperty(value = \"#{" + kucukHarfEntity + "Service}\")\nprivate I" + buyukHarfEntity + "Service "
				+ kucukHarfEntity + "Service;\n\n";
		result = result + "@Override\npublic void createEntity() {\n" + buyukHarfEntity + " " + kucukHarfEntity + " = new " + buyukHarfEntity
				+ "();\nsetEntity(" + kucukHarfEntity + ");\n}\n\n";
		result = result + "@Override\npublic void createEntityList() {\nsetEntityList(new ArrayList<" + buyukHarfEntity + ">());\n}\n\n";
		result = result + "@Override\npublic void clean() {\nsetEntity(new " + buyukHarfEntity + "());\ngetEntityList().clear();\nsetDataBean(null);\n}\n\n";
		result = result + "@Override\npublic void setEid(Long eid) {\nsetEntity(" + kucukHarfEntity + "Service.getEntityById(eid));\nthis.eid = eid;\n}\n\n";
		result = result + "@PostConstruct\npublic void init() {\ninitBase();\n}\n\n";
		result = result + "public void search() {\nsetMessage(null);\nsetEntityList(this." + kucukHarfEntity + "Service.list(getEntity()));\n}\n\n";
		result = result + "public void save(Long id) {\nif (FacesContext.getCurrentInstance().getMessageList().size()==0) {\ntry {\nif (id != null) {\nthis."
				+ kucukHarfEntity + "Service.update(getEntity());\nsetMessage(\"" + buyukHarfEntity + " is successfully updated\");\nclean();\n} else {\nthis."
				+ kucukHarfEntity + "Service.add(getEntity());\nsetMessage(\"" + buyukHarfEntity
				+ " is successfully created\");\nclean();\n}\n} catch (Exception e) {\nlogger.error(e);\nsetMessage(e.getMessage());\n}\n}\n}\n\n";
		result = result + "public void remove(int row) {\ntry {\nthis." + kucukHarfEntity + "Service.remove(getEntityList().get(row).getId());\nsetMessage(\""
				+ buyukHarfEntity
				+ " with id: \" + getEntityList().get(row).getId()\n+ \" is succesfully deleted\");\ngetEntityList().remove(row);\n} catch (Exception e) {\nsetMessage(e.getMessage());\n}\n}\n\n";
		result = result + "public String edit(int row) {\nsetEntity(this." + kucukHarfEntity
				+ "Service.getEntityById(getEntityList().get(row).getId()));\nreturn \"" + kucukHarfEntity
				+ "?faces-redirect=true&entityId=\" + getEntityList().get(row).getId();\n}\n\n";
		result = result + "public String newEntity() {\nsetMessage(null);\nsetEntity(new " + buyukHarfEntity + "());\nreturn \"" + kucukHarfEntity
				+ "?faces-redirect=true\";\n}\n\n";
		result = result + "public I" + buyukHarfEntity + "Service getPersonService() {\nreturn " + kucukHarfEntity + "Service;\n}\n\npublic void set"
				+ buyukHarfEntity + "Service(I" + buyukHarfEntity + "Service " + kucukHarfEntity + "Service) {\nthis." + kucukHarfEntity + "Service = "
				+ kucukHarfEntity + "Service;\n}\n\n";
		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			buyukHarfEntityField = generatedEntityField.getDataType();
			kucukHarfEntityField = generatedEntityField.getDataType().substring(0, 1).toLowerCase() + generatedEntityField.getDataType().substring(1);
			if (generatedEntityField.getColumnType().equals(AltanKolonColumnType.JOIN_COLUMN)) {

				result = result + "public String add" + buyukHarfEntityField + "ManyToOne(String pageName) {\n" + "DataBean dataBean = new DataBean();\n"
						+ "if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get(\"obj\")!=null){\n"
						+ "		dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get(\"obj\");\n" + "	}\n"
						+ "	dataBean.setObj(getEntity());\n" + "	dataBean.setName(getEntity().getClass().getName());\n" + "	dataBean.setFrom(pageName);\n"
						+ "	dataBean.setRelationType(RelationType.manyToOne);\n" + "	DataBean childDataBean = new DataBean();\n"
						+ "	childDataBean.setFrom(\"" + kucukHarfEntityField + "List\");\n" + "	childDataBean.setName(\"com.entity." + buyukHarfEntityField
						+ "\");\n" + "	childDataBean.setParentDataBean(dataBean);\n" + "	FacesContext.getCurrentInstance().getExternalContext().getFlash()\n"
						+ "			.put(\"obj\", childDataBean);\n" + "	return \"" + kucukHarfEntityField
						+ "List?faces-redirect=true&addSelect=\" + AddSelect.ADD.ordinal();\n" + "}\n";
			}

			if ((generatedEntityField.getOneToManyDataListName() != null && !generatedEntityField.getOneToManyDataListName().isEmpty())
					&& generatedEntityField.getOneToManyListExists().equals(Cevap.EVET)) {
				for (String oneToManyDataListNameElement : generatedEntityField.getOneToManyDataListName().split(";")) {

					result = result + "public String " + oneToManyDataListNameElement.substring(0, 1).toLowerCase() + oneToManyDataListNameElement.substring(1)
							+ "Ekle";

					// if
					// (oneToManyDataListNameElement.contains(buyukHarfEntity)
					// && !oneToManyDataListNameElement.replace(buyukHarfEntity,
					// "").equals("")) {
					// result = result + "ManyToMany";
					// } else {
					result = result + "OneToMany"; // şimdilik böle yaptım sonra
													// sxhtml ler de değişcek
					// }

					result = result + "(String pageName) {\n" + "DataBean dataBean = new DataBean();\n"
							+ "if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get(\"obj\")!=null){\n"
							+ "	dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get(\"obj\");\n" + "}\n"
							+ "dataBean.setObj(getEntity());\n" + "dataBean.setName(getEntity().getClass().getName());\n" + "dataBean.setFrom(pageName);\n"
							+ "dataBean.setRelationType(RelationType." + getRelationTypeOfEntity(buyukHarfEntity, oneToManyDataListNameElement) + ");\n" +

					"DataBean childDataBean = new DataBean();\n" + "childDataBean.setFrom(\"" + oneToManyDataListNameElement.substring(0, 1).toLowerCase()
							+ oneToManyDataListNameElement.substring(1) + "List\");\n" + "childDataBean.setName(\"com.entity." + oneToManyDataListNameElement
							+ "\");\n" + "childDataBean.setParentDataBean(dataBean);\n" +

					"FacesContext.getCurrentInstance().getExternalContext().getFlash().put(\"obj\", childDataBean);\n" + "return \""
							+ oneToManyDataListNameElement.substring(0, 1).toLowerCase() + oneToManyDataListNameElement.substring(1)
							+ "List?faces-redirect=true&addSelect=\" + AddSelect.ADD.ordinal();\n" + "}\n";
				}
			}
		}
		result = result + "}";
		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public String getRelationTypeOfEntity(String entity, String entityField) {
		if (entityField.indexOf(entity) == 0 && sinifVarMi(entityField.split(entity)[1])) {
			return "manyToMany_1";
		} else if (entityField.indexOf(entity) > 0 && sinifVarMi(entityField.split(entity)[0])) {
			return "manyToMany_2";
		} else {
			return "oneToMany";
		}
		// User ve RoleUser
	}

	public boolean sinifVarMi(String className) {
		try {
			Class.forName("com.entity." + className);
			return true;
		} catch (final ClassNotFoundException e) {
			return false;
		}
	}

	public void generatedEntityConverterOlustur(GeneratedEntity generatedEntity) {
		AltanGeneratedPageName pageName = AltanGeneratedPageName.CONVERTER_JAVA;
		String result = pageName.getPaket()
				+ "import java.io.Serializable;\nimport javax.faces.bean.ManagedBean;\nimport javax.faces.bean.ManagedProperty;\nimport javax.faces.bean.RequestScoped;\nimport javax.faces.component.UIComponent;\nimport javax.faces.context.FacesContext;\nimport javax.faces.convert.Converter;\nimport org.apache.log4j.Logger;\nimport com.dao.I"
				+ buyukHarfEntity + "Service;\nimport com.entity." + buyukHarfEntity + ";\n\n";
		result = result + "@ManagedBean(name = \"" + kucukHarfEntity + "Converter\")\n@RequestScoped\npublic class " + buyukHarfEntity
				+ "Converter extends BaseConverter<" + buyukHarfEntity
				+ "> implements Converter, Serializable {\n\nprivate static final long serialVersionUID = 1L;\n\n";
		result = result + "@ManagedProperty(value = \"#{" + kucukHarfEntity + "Service}\")\nprivate I" + buyukHarfEntity + "Service " + kucukHarfEntity
				+ "Service;\n\npublic void set" + buyukHarfEntity + "Service(I" + buyukHarfEntity + "Service " + kucukHarfEntity + "Service) {\nthis."
				+ kucukHarfEntity + "Service =" + kucukHarfEntity + "Service;setEntityService(" + kucukHarfEntity + "Service); \n}\n\npublic I"
				+ buyukHarfEntity + "Service get" + buyukHarfEntity + "Service() {\nreturn " + kucukHarfEntity + "Service;\n}\n}\n";

		dosyaOlustur(result, buyukHarfEntity, pageName);
	}

	public void generatedEntityEntityJavaOlustur(GeneratedEntity generatedEntity) {

		AltanGeneratedPageName pageName = AltanGeneratedPageName.ENTITY_JAVA;
		String result = pageName.getPaket() + IMPORT;
		List<GeneratedEntityField> complexEntityList = new ArrayList<GeneratedEntityField>();

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			generatedEntityField.setGeneratedEntity(generatedEntity);
			if (getLastPartOfClass(generatedEntityField.getDataType()).equals("String")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Integer")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Long")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("BigDecimal")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Date")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Double")
					|| getLastPartOfClass(generatedEntityField.getDataType()).equals("Boolean")) {
			} else {
				if (generatedEntityField.getEnumerated() != null) {
					result = result + "import com.enums.ProjectEnum." + getLastPartOfClass(generatedEntityField.getDataType()) + ";\n"
							+ "import javax.persistence.EnumType;\n" + "import javax.persistence.Enumerated;\n";
				} else {
					// result = result + "import "
					// + generatedEntityField.getDataType() + ";\n\n";
					complexEntityList.add(generatedEntityField);
				}

			}
		}

		result = result + "\n\n" + "/**\n" + " * @version {} " + dateFormat.format(new Date()) + "\n" + " * @author Altan Senel\n" + " * \n" + " */\n\n\n";

		// @Audited
		// @Entity
		// @Table(name = "PERSON", indexes = { @Index(columnList = "sehir_id",
		// name = "IND_PERSON_SEHIR") })
		// @org.hibernate.annotations.Cache(usage =
		// org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
		// // virgül atıp devam eder
		// public class Person extends BaseEntity implements Serializable{
		//
		// private static final long serialVersionUID = 1L;

		result = result + "@Audited\n@Entity\n";
		result = result + "@Table(name = \"" + generatedEntity.getTable() + "\", indexes = { ";
		for (GeneratedEntityField generatedEntityField : complexEntityList) {
			result = result + "@Index(columnList = \"" + generatedEntityField.getColumnName() + "\", name = \"IND_" + generatedEntity.getTable() + "_"
					+ generatedEntityField.getDataType().toUpperCase() + "\"),";
		}
		result = result.substring(0, result.length() - 1);
		result = result + " } )\n";
		result = result + "@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)\n";
		result = result + "public class " + getLastPartOfClass(generatedEntity.getEntity()) + pageName.getAd()
				+ " extends BaseEntity implements Serializable {\n\n";
		result = result + "private static final long serialVersionUID = 1L;\n\n";

		result = datalariOlusturForEntity(result, generatedEntity, pageName);

		dosyaOlustur(result, getLastPartOfClass(generatedEntity.getEntity()), pageName);
	}

	public void dosyaOlustur(String in, String className, AltanGeneratedPageName pageName) {
		FileWriter out = null;
		className = className.replace(NOKTA, TIRE_CHAR);
		className = className.split(TIRE_STRING)[className.split(TIRE_STRING).length - 1];
		if (pageName.getSinifAdiIlkHarfKucukMu()) {
			className = className.substring(0, 1).toLowerCase() + className.substring(1);
		} else {
		}

		String fullFilePath = "";
		if (pageName.getSinifAdiKullaniliyorMu()) {
			fullFilePath = pageName.getDirectoryStart() + className + pageName.getAd() + pageName.getDirectoryEnd();
		} else {
			fullFilePath = pageName.getDirectoryStart() + pageName.getAd() + pageName.getDirectoryEnd();
		}

		try {
			// burada aslında içine eklenen dosyalarda değişiklik yapıldığı için
			// append etmek yerine varolanı ezmek seçeneği kullanıldı
			if (pageName == AltanGeneratedPageName.PUSULA_ENUM || pageName == AltanGeneratedPageName.ENUM_ACTION) {
				String content = readFile(fullFilePath);
				if (content.trim().lastIndexOf("}") == content.trim().length() - 1) {
					in = content.trim().substring(0, content.trim().length() - 1) + in + "}";
				}
			}

			out = new FileWriter(fullFilePath, !pageName.getDosyayiEzipYenidenMiUretsin());

			out.write(in);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public String readFile(String filename) {
		String content = null;
		File file = new File(filename); // for ex foo.txt
		try {
			FileReader reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String datalariOlusturForEntity(String in, GeneratedEntity generatedEntity, AltanGeneratedPageName pageName) {
		String result = in;
		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			result = result + generatedEntityField.getKolonFull();
		}

		for (GeneratedEntityField generatedEntityField : generatedEntity.getGeneratedEntityFieldList()) {
			result = result + generatedEntityField.getKolonGetter(pageName);
			result = result + generatedEntityField.getKolonSetter(pageName);
		}
		result = result + "}";
		return result;
	}

	public String getLastPartOfClass(String className) {
		return className.split(DOT)[className.split(DOT).length - 1];
	}

	public void removeGeneratedEntityField(int row) {
		try {
			getEntity().getGeneratedEntityFieldList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public GeneratedEntityField getGeneratedEntityField() {
		return generatedEntityField;
	}

	public void setGeneratedEntityField(GeneratedEntityField generatedEntityField) {
		this.generatedEntityField = generatedEntityField;
	}

}
