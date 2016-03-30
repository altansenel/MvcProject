



package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IWaybillTransStatusHistoryService;
import com.entity.WaybillTransStatusHistory;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "waybillTransStatusHistoryController")
public class WaybillTransStatusHistoryController extends BaseController<WaybillTransStatusHistory>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(WaybillTransStatusHistoryController.class);
	@ManagedProperty(value = "#{waybillTransStatusHistoryService}")
	private IWaybillTransStatusHistoryService waybillTransStatusHistoryService;

	@Override
	public void createEntity() {
		WaybillTransStatusHistory waybillTransStatusHistory = new WaybillTransStatusHistory();
		setEntity(waybillTransStatusHistory);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<WaybillTransStatusHistory>());
	}

	@Override
	public void clean() {
		setEntity(new WaybillTransStatusHistory());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(waybillTransStatusHistoryService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.waybillTransStatusHistoryService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.waybillTransStatusHistoryService.update(getEntity());
				setMessage("WaybillTransStatusHistory is successfully updated");
				clean();
			} else {
				this.waybillTransStatusHistoryService.add(getEntity());
				setMessage("WaybillTransStatusHistory is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.waybillTransStatusHistoryService.remove(getEntityList().get(row).getId());
			setMessage("WaybillTransStatusHistory with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.waybillTransStatusHistoryService.getEntityById(getEntityList()
				.get(row).getId()));
		return "waybillTransStatusHistory?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new WaybillTransStatusHistory());
		return "WaybillTransStatusHistory?faces-redirect=true";
	}

	public IWaybillTransStatusHistoryService getWaybillTransStatusHistoryService() {
		return waybillTransStatusHistoryService;
	}

	public void setWaybillTransStatusHistoryService(IWaybillTransStatusHistoryService waybillTransStatusHistoryService) {
		this.waybillTransStatusHistoryService = waybillTransStatusHistoryService;
	}




}