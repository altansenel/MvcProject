package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdamService;
import com.entity.Adam;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "adamController")
public class AdamController extends BaseController<Adam> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdamController.class);
	@ManagedProperty(value = "#{adamService}")
	private IAdamService adamService;

	@Override
	public void createEntity() {
		Adam adam = new Adam();
		setEntity(adam);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Adam>());
	}

	@Override
	public void clean() {
		setEntity(new Adam());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adamService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adamService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.adamService.update(getEntity());
				setMessage("Adam is successfully updated");
				clean();
			} else {
				this.adamService.add(getEntity());
				setMessage("Adam is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adamService.remove(getEntityList().get(row).getId());
			setMessage("Adam with id: " + getEntityList().get(row).getId() + " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adamService.getEntityById(getEntityList().get(row).getId()));
		return "adam?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Adam());
		return "adam?faces-redirect=true";
	}

	public IAdamService getPersonService() {
		return adamService;
	}

	public void setAdamService(IAdamService adamService) {
		this.adamService = adamService;
	}

	public String addSehir(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", dataBean);
		return "sehirList?faces-redirect=true&from=" + pageName + "&relationType=" + RelationType.manyToOne.ordinal();
	}

}