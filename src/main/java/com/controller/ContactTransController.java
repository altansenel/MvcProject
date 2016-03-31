

    
        
                    
        
                                
        
                                            
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IContactTransService;
import com.entity.ContactTrans;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "contactTransController")
public class ContactTransController extends BaseController<ContactTrans>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ContactTransController.class);
	@ManagedProperty(value = "#{contactTransService}")
	private IContactTransService contactTransService;

	@Override
	public void createEntity() {
		ContactTrans contactTrans = new ContactTrans();
		setEntity(contactTrans);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<ContactTrans>());
	}

	@Override
	public void clean() {
		setEntity(new ContactTrans());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(contactTransService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.contactTransService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.contactTransService.update(getEntity());
				setMessage("ContactTrans is successfully updated");
				clean();
			} else {
				this.contactTransService.add(getEntity());
				setMessage("ContactTrans is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.contactTransService.remove(getEntityList().get(row).getId());
			setMessage("ContactTrans with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.contactTransService.getEntityById(getEntityList()
				.get(row).getId()));
		return "ContactTrans?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new ContactTrans());
		return "ContactTrans?faces-redirect=true";
	}

	public IContactTransService getContactTransService() {
		return contactTransService;
	}

	public void setContactTransService(IContactTransService contactTransService) {
		this.contactTransService = contactTransService;
	}




	public String addContactTransSource(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("ContactTransSourceList");
		childDataBean.setName("org.demo.bean.yeni.ContactTransSource");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "ContactTransSourceList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addGlobalPrivateCode(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("GlobalPrivateCodeList");
		childDataBean.setName("org.demo.bean.yeni.GlobalPrivateCode");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "GlobalPrivateCodeList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addContact(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("ContactList");
		childDataBean.setName("org.demo.bean.yeni.Contact");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "ContactList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addGlobalTransPoint(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("GlobalTransPointList");
		childDataBean.setName("org.demo.bean.yeni.GlobalTransPoint");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "GlobalTransPointList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}