package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IIlService;
import com.entity.Il;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "ilController")
public class IlController extends BaseController<Il> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(IlController.class);
	@ManagedProperty(value = "#{ilService}")
	private IIlService ilService;

	@Override
	public void createEntity() {
		Il il = new Il();
		setEntity(il);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Il>());
	}

	@Override
	public void clean() {
		setEntity(new Il());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(ilService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.ilService.list(getEntity()));
	}
	
	public void save(Long id) {
		try {
			if (id != null) {
				this.ilService.update(getEntity());
				setMessage("Il is successfully updated");
				clean();
			} else {
				this.ilService.add(getEntity());
				setMessage("Il is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.ilService.remove(getEntityList().get(row).getId());
			setMessage("Il with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.ilService
				.getEntityById(getEntityList().get(row).getId()));
		return "il?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Il());
		return "il?faces-redirect=true";
	}

	public IIlService getPersonService() {
		return ilService;
	}

	public void setIlService(IIlService ilService) {
		this.ilService = ilService;
	}

	public String addUlke(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "ulkeList?faces-redirect=true&from=" + pageName
				+ "&relationType=" + RelationType.manyToOne.ordinal();
	}

}