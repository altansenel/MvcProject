

    
        
                            
    
                            
    
                            
    
                            
    
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IAdminDocumentFieldService;
import com.entity.AdminDocumentField;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "adminDocumentFieldController")
public class AdminDocumentFieldController extends BaseController<AdminDocumentField>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminDocumentFieldController.class);
	@ManagedProperty(value = "#{adminDocumentFieldService}")
	private IAdminDocumentFieldService adminDocumentFieldService;

	@Override
	public void createEntity() {
		AdminDocumentField adminDocumentField = new AdminDocumentField();
		setEntity(adminDocumentField);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<AdminDocumentField>());
	}

	@Override
	public void clean() {
		setEntity(new AdminDocumentField());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(adminDocumentFieldService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.adminDocumentFieldService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.adminDocumentFieldService.update(getEntity());
				setMessage("AdminDocumentField is successfully updated");
				clean();
			} else {
				this.adminDocumentFieldService.add(getEntity());
				setMessage("AdminDocumentField is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.adminDocumentFieldService.remove(getEntityList().get(row).getId());
			setMessage("AdminDocumentField with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.adminDocumentFieldService.getEntityById(getEntityList()
				.get(row).getId()));
		return "AdminDocumentField?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new AdminDocumentField());
		return "AdminDocumentField?faces-redirect=true";
	}

	public IAdminDocumentFieldService getAdminDocumentFieldService() {
		return adminDocumentFieldService;
	}

	public void setAdminDocumentFieldService(IAdminDocumentFieldService adminDocumentFieldService) {
		this.adminDocumentFieldService = adminDocumentFieldService;
	}




	public String addAdminDocument(String pageName) {
		DataBean dataBean = new DataBean();
		if(FacesContext.getCurrentInstance()
		.getExternalContext().getFlash().get("obj")!=null){
			dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
		}
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());
		dataBean.setFrom(pageName.split(",")[0]);
		dataBean.setRelationType(RelationType.manyToOne);
		
		DataBean childDataBean = new DataBean();
		childDataBean.setFrom("AdminDocumentList");
		childDataBean.setName("org.demo.bean.yeni.AdminDocument");
		childDataBean.setParentDataBean(dataBean);
		childDataBean.setFieldName(pageName.split(",")[1]);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "AdminDocumentList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}