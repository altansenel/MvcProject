package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IKitapService;
import com.entity.Kitap;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;

@ViewScoped
@ManagedBean(name = "kitapController")
public class KitapController extends BaseController<Kitap> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(KitapController.class);
	@ManagedProperty(value = "#{kitapService}")
	private IKitapService kitapService;

	@Override
	public void createEntity() {
		Kitap kitap = new Kitap();
		setEntity(kitap);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Kitap>());
	}

	@Override
	public void clean() {
		setEntity(new Kitap());
		getEntityList().clear();
		setDataBean(null);
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(kitapService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.kitapService.list(getEntity()));
	}

	public void save(Long id) {
		if (FacesContext.getCurrentInstance().getMessageList().size() == 0) {
			try {
				if (id != null) {
					this.kitapService.update(getEntity());
					setMessage("Kitap is successfully updated");
					clean();
				} else {
					this.kitapService.add(getEntity());
					setMessage("Kitap is successfully created");
					clean();
				}
			} catch (Exception e) {
				logger.error(e);
				setMessage(e.getMessage());
			}
		}
	}

	public void remove(int row) {
		try {
			this.kitapService.remove(getEntityList().get(row).getId());
			setMessage("Kitap with id: " + getEntityList().get(row).getId() + " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.kitapService.getEntityById(getEntityList().get(row).getId()));
		return "kitap?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Kitap());
		return "kitap?faces-redirect=true";
	}

	public IKitapService getPersonService() {
		return kitapService;
	}

	public void setKitapService(IKitapService kitapService) {
		this.kitapService = kitapService;
	}

	public String addDolapManyToOne(String pageName) {
		DataBean dataBean = new DataBean();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj") != null) {
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("dolapList");
		childDataBean.setName("com.entity.Dolap");
		childDataBean.setParentDataBean(dataBean);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("obj", childDataBean);
		return "dolapList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}
}