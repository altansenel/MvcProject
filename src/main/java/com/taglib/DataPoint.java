package com.taglib;

import java.io.Serializable;

public class DataPoint implements Serializable{

	

	private static final long serialVersionUID = 1L;
	private Object x;
	private Object y;
	private String label;
	private String legendText;
	private String indexLabel;
	

	public Object getX() {
		return x;
	}
	public void setX(Object x) {
		this.x = x;
	}
	public Object getY() {
		return y;
	}
	public void setY(Object y) {
		this.y = y;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLegendText() {
		return legendText;
	}
	public void setLegendText(String legendText) {
		this.legendText = legendText;
	}
	public String getIndexLabel() {
		return indexLabel;
	}
	public void setIndexLabel(String indexLabel) {
		this.indexLabel = indexLabel;
	}

	
}
