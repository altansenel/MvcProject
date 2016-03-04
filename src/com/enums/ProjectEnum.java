package com.enums;

public class ProjectEnum {
	
	public enum UserActivityAction {
		ADD,
		UPDATE,
		REMOVE

	}
	
	public enum LegendVerticalAlign {
		TOP("top"),
		CENTER("center"),
		BOTTOM("bottom");
		
		private String kod;

		public String getKod() {
			return this.kod;
		}

		private LegendVerticalAlign(String kod) {
			this.kod = kod;
		}
	}
	
	public enum LegendHorizontalAlign {
		LEFT("left"),
		CENTER("center"),
		RIGHT("right");
		
		private String kod;

		public String getKod() {
			return this.kod;
		}

		private LegendHorizontalAlign(String kod) {
			this.kod = kod;
		}
	}
	
	public enum RelationType {
		manyToOne,
		manyToMany_1,
		manyToMany_2, //roleuser da 2. entity olan userdan başlayıp role e giderse bu kullanılır
		oneToMany 
	}
	
	public enum AddSelect {
		ADD,
		SELECT
	}
	
	
	public enum Cevap {
		HAYIR,
		EVET;
	}
	
	public enum AltanKolonColumnType {
		JOIN_COLUMN("JoinColumn"), COLUMN("Column");

		private final String ad;

		private AltanKolonColumnType(String ad) {
			this.ad = ad;
		}

		public String getAd() {
			return ad;
		}

	}

	public enum AltanKolonFetchMode {
		SELECT, JOIN, SUBSELECT

	}

	public enum AltanKolonEnumerated {
		ORDINAL, STRING

	}

	public enum AltanGeneratedPageName {
		ENTITY_JAVA(   
				"",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\entity\\",
				"package com.entity;\n", ".java", true,
				false, true), DAO_INTERFACE_JAVA(
				"Dao",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\dao\\I",
				"package com.dao;\n", ".java", true,
				false, true), SERVICE_INTERFACE_JAVA(
				"Service",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\dao\\I",
				"package com.dao;\n", ".java", true, false,
				true), DAO_IMPL_JAVA(
				"DaoImpl",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\dao\\",
				"package com.dao;\n", ".java", true, false,
				true), SERVICE_IMPL_JAVA("ServiceImpl",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\dao\\",
				"package com.dao;", ".java", true, false, true), CONTROLLER_JAVA("Controller",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\controller\\",
				"package com.controller;", ".java", true, false, true), CONVERTER_JAVA(
				"Converter",
				"D:\\dev\\workspace\\MvcProject\\src\\com\\converter\\",
				"package com.converter;", ".java", true, false, true), XHTML("",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\",
				"", ".xhtml", true, true, true), LIST_XHTML("List",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\",
				"", ".xhtml", true, true, true), APPLICATION_TXT(
				"",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\generatedEntityMekanizasyonu\\",
				"", "applicationConfig.xml", false, false, false),SECURITY_TXT(
						"",
						"D:\\dev\\workspace\\MvcProject\\WebContent\\generatedEntityMekanizasyonu\\",
						"", "securityConfig.xml", false, false, false),  SCRIPT_TXT("",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\generatedEntityMekanizasyonu\\", "",
				"script.txt", false, false, false), PUSULA_ENUM(
				"",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\generatedEntityMekanizasyonu\\",
				"", "projectEnum.java", false, false, false), ENUM_ACTION(
				"",
				"D:\\dev\\workspace\\MvcProject\\WebContent\\generatedEntityMekanizasyonu\\",
				"", "projectEnumAction.java", false, false, false), 
				
				REPORT_JAVA(
				"",
				"D:\\dev\\workspace\\gunessigorta\\src\\action\\com\\filika\\sigorta\\tahsilat\\",
				"", ".java", true, false, true), REPORT_XHTML("",
				"D:\\dev\\workspace\\gunessigorta\\view\\modul\\tahsilat\\",
				"", ".xhtml", true, true, true), REPORT_PAGE("",
				"D:\\dev\\workspace\\gunessigorta\\view\\modul\\tahsilat\\",
				"", ".page.xml", true, true, true), REPORT_JRXML("",
				"D:\\dev\\workspace\\gunessigorta\\jasper\\tahsilat\\", "",
				".jrxml", true, true, true);

		private final String ad;
		private final String directoryStart;
		private final String paket;
		private final String directoryEnd;
		private final Boolean sinifAdiKullaniliyorMu;
		private final Boolean sinifAdiIlkHarfKucukMu;
		private final Boolean dosyayiEzipYenidenMiUretsin;

		private AltanGeneratedPageName(String ad, String directoryStart,
				String paket, String directoryEnd,
				Boolean sinifAdiKullaniliyorMu, Boolean sinifAdiIlkHarfKucukMu,
				Boolean dosyayiEzipYenidenMiUretsin) {
			this.ad = ad;
			this.directoryStart = directoryStart;
			this.paket = paket;
			this.directoryEnd = directoryEnd;
			this.sinifAdiKullaniliyorMu = sinifAdiKullaniliyorMu;
			this.sinifAdiIlkHarfKucukMu = sinifAdiIlkHarfKucukMu;
			this.dosyayiEzipYenidenMiUretsin = dosyayiEzipYenidenMiUretsin;
		}

		public String getDirectoryStart() {
			return directoryStart;
		}

		public String getAd() {
			return ad;
		}

		public String getPaket() {
			return paket;
		}

		public String getDirectoryEnd() {
			return directoryEnd;
		}

		public Boolean getSinifAdiKullaniliyorMu() {
			return sinifAdiKullaniliyorMu;
		}

		public Boolean getSinifAdiIlkHarfKucukMu() {
			return sinifAdiIlkHarfKucukMu;
		}

		public Boolean getDosyayiEzipYenidenMiUretsin() {
			return dosyayiEzipYenidenMiUretsin;
		}

	}
	
	public enum Yon {
		KUZEY,GUNEY,DOGU,BATI
	}
	
	public enum KitapTuru {
		ROMAN,OYKU, MAKALE,DENEME,ARASTIRMA
	}

	public enum UygunlukDurumu {
		UYGUN,BASKASINDA, KAYIP
	}
}
