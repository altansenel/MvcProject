package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

import com.dao.ISehirService;
import com.entity.Sehir;

@ManagedBean(name = "sehirConverter")
@RequestScoped
//@FacesConverter("sehirConverter")
public class SehirConverter extends BaseConverter<Sehir> implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	//private static final Logger logger = Logger.getLogger(SehirConverter.class);

	@ManagedProperty(value = "#{sehirService}")
	private ISehirService sehirService;
	
	public void setSehirService(ISehirService sehirService) {
		this.sehirService = sehirService;
		setEntityService(sehirService);
	}
	
	public ISehirService getSehirService() {
		return sehirService;
	}
	

//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component,
//			String value) {
//
//		if (value == null || value.length() == 0)
//			return null;
//
//		try {
//			Sehir temp = sehirService.getEntityById(new Long(value));
//			if (temp == null) {
//				// ((FacesMessages)
//				// Component.getInstance(FacesMessages.class)).add("#{messages['tahsilat.mesaj.bankaBulunamadi']}");
//			}
//			return temp;
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			return null;
//		}
//	}

//	@Override
//	public String getAsString(FacesContext context, UIComponent component,
//			Object value) {
//		if (get(value, "id") == null) {
//			return null;
//		} else {
//			return get(value, "id").toString();
//		}
//	}

}
