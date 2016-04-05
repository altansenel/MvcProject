package com.controller;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.context.FacesContext;

import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

public abstract class BaseController<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static final String ADD_SELECT = "addSelect";
	protected static final String STORED_OBJECT_NAME = "storedObjectName";
	protected static final String FROM = "from";
	protected static final String RELATION_TYPE = "relationType";
	private static final String DOT = "\\.";
	private static final String ARRAY_LIST_CLASS_NAME = "java.util.ArrayList";
	private static final String PERSISTENT_BAG_CLASS_NAME = "org.hibernate.collection.internal.PersistentBag";
	private static final String OBJECT_CLASS_NAME = "java.lang.Object";

	protected Integer eid;
	private String message;
	private DataBean dataBean;
	private String from;
	private RelationType relationType;
	private E entity;
	private List<E> entityList;
	private Boolean disableValidation;

	public abstract void createEntity();

	public abstract void createEntityList();

	public abstract void clean();

	@SuppressWarnings("unchecked")
	public void initBase() {
		setDataBean((DataBean) FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().get("obj"));
		if (getDataBean()!=null) {
			setFrom(getDataBean().getFrom());
			setRelationType(getDataBean().getRelationType());
			setEntity((E)getDataBean().getObj());
		}
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("entityId") != null) {
			setEid(Integer.valueOf(FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap()
					.get("entityId")));
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

	public Boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(object, fieldValue);
				return true;
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return false;
	}
	
	
	public Boolean invoke(Object object, String methodName, Object param) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Class<?> paramClass;
				if (clazz.getName().equals(ARRAY_LIST_CLASS_NAME) || clazz.getName().equals(PERSISTENT_BAG_CLASS_NAME)) {
					paramClass = Class.forName(OBJECT_CLASS_NAME);
				} else {
					paramClass = param.getClass();
				}
				Method method = clazz.getMethod(methodName,paramClass);
				method.setAccessible(true);
				method.invoke(object, param);
				return true;
			} catch (NoSuchMethodException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return false;
	}

	public String newEntity() {
		setMessage(null);
		clean();
		return entity.getClass().getName().split(DOT)[entity.getClass()
				.getName().split(DOT).length - 1].toLowerCase()
				+ "?faces-redirect=true";
	}

	public String select(int row) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (getDataBean().getParentDataBean()!=null) {
			if (getDataBean().getParentDataBean().getRelationType().equals(RelationType.manyToOne)) {
				set(getDataBean().getParentDataBean().getObj(),
						getDataBean().getFieldName(),
//						getEntity().getClass().getName().split(DOT)[getEntity()
//								.getClass().getName().split(DOT).length - 1].substring(0,1).toLowerCase() + getEntity().getClass().getName().split(DOT)[getEntity().getClass().getName().split(DOT).length - 1].substring(1),
						getEntityList().get(row));
				setDataBean(getDataBean().getParentDataBean());
				FacesContext.getCurrentInstance().getExternalContext().getFlash()
						.put("obj", getDataBean());
				return getDataBean().getFrom() + "?faces-redirect=true&addSelect=" + AddSelect.SELECT.ordinal();
			} else if (getDataBean().getParentDataBean().getRelationType().equals(RelationType.manyToMany_1)) {  //roleuser için role den user a giderse
				Class<?> c = Class.forName(getDataBean().getParentDataBean().getName() + noktadanSonrasiniAl(getDataBean().getName()));
				Object obj = c.newInstance(); //RoleUser objesi
				set(obj,basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getName())), getEntityList().get(row)); //user
				set(obj,basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getParentDataBean().getName())), getDataBean().getParentDataBean().getObj()); //user
				invoke(get(getDataBean().getParentDataBean().getObj(),basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getParentDataBean().getName()) + noktadanSonrasiniAl(getDataBean().getName())+"List")),"add",obj);
				setDataBean(getDataBean().getParentDataBean());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", getDataBean());
				return getDataBean().getFrom() + "?faces-redirect=true&addSelect=" + AddSelect.SELECT.ordinal();
			} else if (getDataBean().getParentDataBean().getRelationType().equals(RelationType.manyToMany_2)) {  //roleuser için user dan role e giderse
				Class<?> c = Class.forName(getDataBean().getName() + noktadanSonrasiniAl(getDataBean().getParentDataBean().getName()));
				Object obj = c.newInstance(); //RoleUser objesi
				set(obj,basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getName())), getEntityList().get(row)); //role
				set(obj,basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getParentDataBean().getName())), getDataBean().getParentDataBean().getObj()); //user
				invoke(get(getDataBean().getParentDataBean().getObj(),basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getName()) + noktadanSonrasiniAl(getDataBean().getParentDataBean().getName())+"List")),"add",obj);
				setDataBean(getDataBean().getParentDataBean());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", getDataBean());
				return getDataBean().getFrom() + "?faces-redirect=true&addSelect=" + AddSelect.SELECT.ordinal();
			}
			else if(getDataBean().getParentDataBean().getRelationType().equals(RelationType.oneToMany)){		
				Class<?> c = Class.forName(getDataBean().getName()); 
				Object obj = c.newInstance(); 
				obj = getEntityList().get(row);
				invoke(obj,"set" + noktadanSonrasiniAl(getDataBean().getParentDataBean().getName()),getDataBean().getParentDataBean().getObj());
			    invoke(get(getDataBean().getParentDataBean().getObj(),
			    		basiniKucukharfYap(noktadanSonrasiniAl(getDataBean().getName())) + "List"),"add",obj);
			    setDataBean(getDataBean().getParentDataBean());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", getDataBean());
				return getDataBean().getFrom() + "?faces-redirect=true&addSelect=" + AddSelect.SELECT.ordinal();			
			} 
			else {
				return null;
			}
		}else{
			return null;
		}
	}
	
	public void dataBeanOlustur(String pageName, RelationType relationType){
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(relationType);
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean.setParentDataBean((DataBean) FacesContext.getCurrentInstance()
					.getExternalContext().getFlash().get("obj")); 
		}
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
		.put("obj", dataBean);	
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataBean getDataBean() {
		return dataBean;
	}

	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public E getEntity() {
		if (entity == null) {
			createEntity();
		}
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public List<E> getEntityList() {
		if (entityList == null) {
			createEntityList();
		}
		return entityList;
	}

	public void setEntityList(List<E> entityList) {
		this.entityList = entityList;
	}

	public Boolean getDisableValidation() {
		return disableValidation;
	}

	public void setDisableValidation(Boolean disableValidation) {
		this.disableValidation = disableValidation;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
	
	public String noktadanSonrasiniAl(String entityName) {
		return entityName.split(DOT)[entityName.split(DOT).length-1];
	}

	public String basiniKucukharfYap(String entityName) {
		return entityName.substring(0,1).toLowerCase() + entityName.substring(1);
	}
}
