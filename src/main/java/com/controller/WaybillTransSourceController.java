

    
        
                    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IWaybillTransSourceService;
import com.entity.WaybillTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "waybillTransSourceController")
public class WaybillTransSourceController extends BaseController<WaybillTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(WaybillTransSourceController.class);
	@ManagedProperty(value = "#{waybillTransSourceService}")
	private IWaybillTransSourceService waybillTransSourceService;

	@Override
	public void createEntity() {
		WaybillTransSource waybillTransSource = new WaybillTransSource();
		setEntity(waybillTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<WaybillTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new WaybillTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(waybillTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.waybillTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.waybillTransSourceService.update(getEntity());
				setMessage("WaybillTransSource is successfully updated");
				clean();
			} else {
				this.waybillTransSourceService.add(getEntity());
				setMessage("WaybillTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.waybillTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("WaybillTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.waybillTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "waybillTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new WaybillTransSource());
		return "WaybillTransSource?faces-redirect=true";
	}

	public IWaybillTransSourceService getWaybillTransSourceService() {
		return waybillTransSourceService;
	}

	public void setWaybillTransSourceService(IWaybillTransSourceService waybillTransSourceService) {
		this.waybillTransSourceService = waybillTransSourceService;
	}




}