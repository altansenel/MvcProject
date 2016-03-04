package com.taglib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ChartData implements Serializable {


	private static final long serialVersionUID = 1L;
	private String type;
	private String legendText;
	private Boolean showInLegend;
	private List<DataPoint> dataPointList = new ArrayList<DataPoint>();
	private String indexLabelFontSize;
	private String indexLabelFontFamily;
	private String indexLabelFontColor;
	private String indexLabelLineColor;
	private String indexLabelPlacement;
	private String toolTipContent;

	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLegendText() {
		return legendText;
	}
	public void setLegendText(String legendText) {
		this.legendText = legendText;
	}
	public Boolean getShowInLegend() {
		return showInLegend;
	}
	public void setShowInLegend(Boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	public List<DataPoint> getDataPointList() {
		return dataPointList;
	}
	public void setDataPointList(List<DataPoint> dataPointList) {
		this.dataPointList = dataPointList;
	}
	public String getIndexLabelFontSize() {
		return indexLabelFontSize;
	}
	public void setIndexLabelFontSize(String indexLabelFontSize) {
		this.indexLabelFontSize = indexLabelFontSize;
	}
	public String getIndexLabelFontFamily() {
		return indexLabelFontFamily;
	}
	public void setIndexLabelFontFamily(String indexLabelFontFamily) {
		this.indexLabelFontFamily = indexLabelFontFamily;
	}
	public String getIndexLabelFontColor() {
		return indexLabelFontColor;
	}
	public void setIndexLabelFontColor(String indexLabelFontColor) {
		this.indexLabelFontColor = indexLabelFontColor;
	}
	public String getIndexLabelLineColor() {
		return indexLabelLineColor;
	}
	public void setIndexLabelLineColor(String indexLabelLineColor) {
		this.indexLabelLineColor = indexLabelLineColor;
	}
	public String getIndexLabelPlacement() {
		return indexLabelPlacement;
	}
	public void setIndexLabelPlacement(String indexLabelPlacement) {
		this.indexLabelPlacement = indexLabelPlacement;
	}
	public String getToolTipContent() {
		return toolTipContent;
	}
	public void setToolTipContent(String toolTipContent) {
		this.toolTipContent = toolTipContent;
	}
	
	


}
