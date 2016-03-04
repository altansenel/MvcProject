package com.converter;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import com.dao.IUlkeService;
import com.entity.Ulke;

@ManagedBean(name = "ulkeConverter")
@RequestScoped
public class UlkeConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UlkeConverter.class);

	@ManagedProperty(value = "#{ulkeService}")
	private IUlkeService ulkeService;
	
	public IUlkeService getUlkeService() {
		return ulkeService;
	}

	public void setUlkeService(IUlkeService ulkeService) {
		this.ulkeService = ulkeService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value == null || value.length() == 0)
			return null;

		try {
			Ulke temp = ulkeService.getEntityById(new Long(value));
			if (temp == null) {
				// ((FacesMessages)
				// Component.getInstance(FacesMessages.class)).add("#{messages['tahsilat.mesaj.bankaBulunamadi']}");
			}
			return temp;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (get(value, "id") == null) {
			return null;
		} else {
			return get(value, "id").toString();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Object object, String fieldName) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return (T) field.get(object);
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

}
