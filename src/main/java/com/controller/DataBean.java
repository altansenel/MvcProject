package com.controller;

import java.io.Serializable;

import com.enums.ProjectEnum.RelationType;


public class DataBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Object obj;
	private DataBean parentDataBean;
	private String from;
	private RelationType relationType;
	private String fieldName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public DataBean getParentDataBean() {
		return parentDataBean;
	}
	public void setParentDataBean(DataBean parentDataBean) {
		this.parentDataBean = parentDataBean;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public RelationType getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	

}
