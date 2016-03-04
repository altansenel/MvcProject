package com.taglib;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value = "multipleChartTag")
public class MultipleChartTag  extends UIComponentBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getFamily() {
		return "multipleChartTag";
	}

	public MultipleChartTag() {

	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		String[] chartIdArray =  ((String)getAttributes().get("value")).split(",");

		if (chartIdArray != null && chartIdArray.length != 0) {
			ResponseWriter writer = context.getResponseWriter();
			String result =  "<script type=\"text/javascript\"> window.onload = function () {\n";
			for (String chartId : chartIdArray) {
				result +=  " renderChart"+chartId+"();\n";
				
			}	        
            result +=  "\n" +
			" \n" + "} \n" + "</script> \n";

			writer.write(result);
		}

	}
}
