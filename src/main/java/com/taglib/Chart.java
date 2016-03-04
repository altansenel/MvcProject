package com.taglib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.enums.ProjectEnum.LegendHorizontalAlign;
import com.enums.ProjectEnum.LegendVerticalAlign;

public class Chart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String title;
	Boolean animationEnabled=Boolean.FALSE;
	LegendVerticalAlign legendVerticalAlign;
	LegendHorizontalAlign legendHorizontalAlign;
	private List<ChartData>  chartDataList = new ArrayList<ChartData>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getAnimationEnabled() {
		return animationEnabled;
	}
	public void setAnimationEnabled(Boolean animationEnabled) {
		this.animationEnabled = animationEnabled;
	}
	public List<ChartData> getChartDataList() {
		return chartDataList;
	}
	public void setChartDataList(List<ChartData> chartDataList) {
		this.chartDataList = chartDataList;
	}
	public LegendVerticalAlign getLegendVerticalAlign() {
		return legendVerticalAlign;
	}
	public void setLegendVerticalAlign(LegendVerticalAlign legendVerticalAlign) {
		this.legendVerticalAlign = legendVerticalAlign;
	}
	public LegendHorizontalAlign getLegendHorizontalAlign() {
		return legendHorizontalAlign;
	}
	public void setLegendHorizontalAlign(LegendHorizontalAlign legendHorizontalAlign) {
		this.legendHorizontalAlign = legendHorizontalAlign;
	}
	
 
}
