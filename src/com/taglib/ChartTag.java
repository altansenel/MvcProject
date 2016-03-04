package com.taglib;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;


@FacesComponent(value = "chartTag")
public class ChartTag extends UIComponentBase {

	@Override
	public String getFamily() {
		return "chartTag";
	}

	public ChartTag() {

	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		Chart chart = (Chart) getAttributes().get("value");
		String id = (String) getAttributes().get("id");
		String style = (String) getAttributes().get("style");

		if (id != null && chart != null) {

			ResponseWriter writer = context.getResponseWriter();
			String result = "<div id=\"" + id + "\" ";
			if (style != null) {
				result += "style=\"" + style + "\"";
			} else {
			}
			result += "></div> \n" + "<script type=\"text/javascript\"> \n"					
					+ " function renderChart"+id+"() { \n"
					+ "var chart = new CanvasJS.Chart(\"" + id + "\", { \n"
					+ "title : { \n" + "	text : \"" + chart.getTitle()
					+ "\" \n" + "},";

			if (chart.getAnimationEnabled() != null) {
				result += " animationEnabled: "
						+ chart.getAnimationEnabled().toString().toLowerCase()
						+ ", backgroundColor: \"#F8F8F8\", \n";
			} else {
			}
			if (chart.getLegendVerticalAlign() != null
					|| chart.getLegendHorizontalAlign() != null) {

				result += "legend:{ \n";
				if (chart.getLegendVerticalAlign() != null) {
					result += "	verticalAlign: \""
							+ chart.getLegendVerticalAlign().getKod() + "\", \n";
				} else {
				}
				if (chart.getLegendHorizontalAlign() != null) {
					result += "	horizontalAlign: \""
							+ chart.getLegendHorizontalAlign().getKod() + "\" \n";
				} else {
				}
				result += "}, \n \n";
			} else {
			}
			
			
			result += "data : [ ";

			for (ChartData chartData : chart.getChartDataList()) {
				
			
			result += "{ \n" + "	type : \""
					+ chartData.getType() + "\", \n"
					+ "		showInLegend : " + chartData.getShowInLegend()+", \n"
					+ "     legendText: \""+chartData.getLegendText()+"\",\n"
					+ "	indexLabelFontSize: " 
					+ chartData.getIndexLabelFontSize() + ", \n"
					+ "			indexLabelFontFamily: \"" 
					+ chartData.getIndexLabelFontFamily() + "\",    \n"
					+ "			indexLabelFontColor: \"" 
					+ chartData.getIndexLabelFontColor() + "\",  \n"
					+ "			indexLabelLineColor: \"" 
					+ chartData.getIndexLabelLineColor() + "\",    \n"
					+ "			indexLabelPlacement: \"" 
					+ chartData.getIndexLabelPlacement() + "\",   \n";
			if (chartData.getToolTipContent() != null) {
				result += " toolTipContent: \"" 
					+ chartData.getToolTipContent()+ "\", \n";
			} else {
			}

			result += "		dataPoints : [ ";
			for (DataPoint dataPoint : chartData.getDataPointList()) {

				result += "{ \n" + "		";
				if ( dataPoint.getX() != null) {
					result +=  "	x : " + dataPoint.getX() + ",";
				} else {
				}
				if (dataPoint.getY() != null) {
					result += "	y : " + dataPoint.getY() + ",";
				} else {
				}
				if (dataPoint.getLabel() != null) {
					result += "	label : \"" + dataPoint.getLabel() + "\",";
				} else {
				}
				if (dataPoint.getLegendText() != null) {
					result +=  " legendText : \"" + dataPoint.getLegendText()
							+ "\",";
				} else {
				}
				if (dataPoint.getIndexLabel() != null) {
					result +=  						 " indexLabel : \""
							+ dataPoint.getIndexLabel() + "\",";								
				} else {
				}				

				result = result.substring(0, result.length() - 1);	
				result += "  \n" 	+  "},";

			}

			result = result.substring(0, result.length() - 1);

			result += " ] \n" + "	},";
			}
			
			result = result.substring(0, result.length() - 1);

			result += " ] \n" + "}); \n" +

			"chart.render(); \n" + "} \n" + "</script> \n";

			writer.write(result);
		}

	}
	
}
