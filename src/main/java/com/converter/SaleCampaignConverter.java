
package com.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;
import com.dao.ISaleCampaignService;

import org.apache.log4j.Logger;



@ManagedBean(name = "saleCampaignConverter")
@RequestScoped
public class SaleCampaignConverter extends BaseConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SaleCampaignConverter.class);

	@ManagedProperty(value = "#{saleCampaignService}")
	private ISaleCampaignService saleCampaignService;

	public void setSaleCampaignService(ISaleCampaignService saleCampaignService) {
		this.saleCampaignService = saleCampaignService;
		setEntityService(saleCampaignService);
	}

	public ISaleCampaignService getSaleCampaignService() {
		return saleCampaignService;
	}
}
