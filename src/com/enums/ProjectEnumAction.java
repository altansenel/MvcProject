package com.enums;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.enums.ProjectEnum.AltanKolonColumnType;
import com.enums.ProjectEnum.AltanKolonEnumerated;
import com.enums.ProjectEnum.AltanKolonFetchMode;
import com.enums.ProjectEnum.Cevap;



//@Name("altanEnumAction")
//@Scope(ScopeType.EVENT)
//@AutoCreate
@SessionScoped
@ManagedBean(name = "projectEnumAction")
public class ProjectEnumAction implements Serializable {
	private static final long serialVersionUID = 9199253256742512778L;
	
	public ProjectEnum.Yon[] getAltanYon() {
		return ProjectEnum.Yon.values();
	}

	public AltanKolonColumnType[] getAltanKolonColumnType() {
		return ProjectEnum.AltanKolonColumnType.values();
	}

	public AltanKolonFetchMode[] getAltanKolonFetchMode() {
		return ProjectEnum.AltanKolonFetchMode.values();
	}

	public AltanKolonEnumerated[] getAltanKolonEnumerated() {
		return ProjectEnum.AltanKolonEnumerated.values();
	}
	
	public Cevap[] getCevap() {
		return Cevap.values();
	}
	
	public ProjectEnum.KitapTuru[] getKitapTuru() {
		return ProjectEnum.KitapTuru.values();
	}

	public ProjectEnum.UygunlukDurumu[] getUygunlukDurumu() {
		return ProjectEnum.UygunlukDurumu.values();
	}

}