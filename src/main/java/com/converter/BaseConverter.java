package com.converter;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import com.dao.IBaseService;

public abstract class BaseConverter<E> implements Serializable, Converter {

	private static final long serialVersionUID = 1L;
	private static final String DOT = "\\.";
	private static final Logger logger = Logger.getLogger(BaseConverter.class);

	private IBaseService<E> entityService;

	public IBaseService<E> getEntityService() {
		return entityService;
	}

	public void setEntityService(IBaseService<E> entityService) {
		this.entityService = entityService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || value.length() == 0)
			return null;

		try {
			E temp = entityService.getEntityById(new Integer(value));
			if (temp == null) {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Component "
						+ entityService.getClass().getInterfaces()[0].getName().toString().split(DOT)[2].split("Service")[0].substring(1) + " with id: "
						+ value + " is not found!", "login.failed");
				context.addMessage(null, facesMsg);
			}
			return temp;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (get(value, "id") == null) {
			//E obj = (E) convertInstanceOfObject(value,value.getClass());
			return null;
		} else {
			return get(value, "id").toString();
		}
	}
	
	public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
	    try {
	        return clazz.cast(o);
	    } catch(ClassCastException e) {
	        return null;
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
