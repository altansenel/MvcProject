package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISehirService;
import com.entity.Sehir;
import com.enums.ProjectEnum.RelationType;


@ViewScoped
@ManagedBean(name = "sehirController")
public class SehirController extends BaseController<Sehir> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SehirController.class);

	@ManagedProperty(value = "#{sehirService}")
	private ISehirService sehirService;

	
	@Override
	public void createEntity() {
		setEntity(new Sehir());		
	}
	
	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Sehir>());	
	}
	
	@Override
	public void clean() {
		setEntity(new Sehir());
		getEntityList().clear();
	}
	
	@Override
	public void setEid(Long eid) {
		setEntity(sehirService.getEntityById(eid));
		this.eid = eid; 
	}
	
	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.sehirService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.sehirService.update(getEntity());
				setMessage("Sehir is successfully updated");
				clean();
			} else {
				this.sehirService.add(getEntity());
				setMessage("Sehir is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.sehirService.remove(getEntityList().get(row).getId());
			setMessage("Sehir with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}
	
	public String edit(int row) {
		setEntity(this.sehirService.getEntityById(getEntityList().get(row).getId()));
		return "sehir?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Sehir());
		return "sehir?faces-redirect=true";
	}
	
	public String addUlke(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName("sehir");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "ulkeList?faces-redirect=true&from=" + pageName +"&relationType=" + RelationType.manyToOne.ordinal();
	}

	public ISehirService getSehirService() {
		return sehirService;
	}

	public void setSehirService(ISehirService sehirService) {
		this.sehirService = sehirService;
	}


}