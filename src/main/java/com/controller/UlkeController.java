package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.dao.IUlkeService;
import com.entity.Ulke;


@ViewScoped
@ManagedBean(name = "ulkeController")
public class UlkeController extends BaseController<Ulke> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UlkeController.class);

	@ManagedProperty(value = "#{ulkeService}")
	private IUlkeService ulkeService;

	
	@Override
	public void createEntity() {
		setEntity(new Ulke());		
	}
	
	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Ulke>());	
	}
	
	@Override
	public void clean() {
		setEntity(new Ulke());
		getEntityList().clear();
	}
	
	@Override
	public void setEid(Integer eid) {
		setEntity(ulkeService.getEntityById(eid));
		this.eid = eid; 
	}
	
	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.ulkeService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.ulkeService.update(getEntity());
				setMessage("Ulke is successfully updated");
				clean();
			} else {
				this.ulkeService.add(getEntity());
				setMessage("Ulke is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.ulkeService.remove(getEntityList().get(row).getId());
			setMessage("Ulke with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}
	
//	public String select(int row) {// parametrik yapman lazım gelen yere göre değişsin ayrıca burdan listeye de gidebilirsin
//		Sehir sehir = (Sehir)getDataBean().getObj();
//		sehir.setUlke(getEntityList().get(row));
//		getDataBean().setObj(sehir);
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", getDataBean());
//		return getFrom() + "?faces-redirect=true&" + STORED_OBJECT_NAME +"=" + sehir.getClass().getName();
//	}
	
	public String edit(int row) {
		setEntity(this.ulkeService.getEntityById(getEntityList().get(row).getId()));
		return "ulke?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Ulke());
		return "ulke?faces-redirect=true";
	}

	public IUlkeService getUlkeService() {
		return ulkeService;
	}

	public void setUlkeService(IUlkeService ulkeService) {
		this.ulkeService = ulkeService;
	}


}