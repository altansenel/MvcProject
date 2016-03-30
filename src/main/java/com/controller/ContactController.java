

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
                                                                                
        
                                        
    
                                                                                            
        
                                                                                                        
        
                                        
    
                                        
    
                                                                                                                    
        
                                                                                                                                
        
                                                                                                                                            
        
                                        
    
                                                                                                                                                        
        
                                        
    
                                        
    
                                        
    
                                                                                                                                                                    
        
                                                                                                                                                                                
        
                                        
    
                                                                                                                                                                                            
        
                                        
    
                                                                                                                                                                                                        
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IContactService;
import com.entity.Contact;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "contactController")
public class ContactController extends BaseController<Contact>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ContactController.class);
	@ManagedProperty(value = "#{contactService}")
	private IContactService contactService;

	@Override
	public void createEntity() {
		Contact contact = new Contact();
		setEntity(contact);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Contact>());
	}

	@Override
	public void clean() {
		setEntity(new Contact());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(contactService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.contactService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.contactService.update(getEntity());
				setMessage("Contact is successfully updated");
				clean();
			} else {
				this.contactService.add(getEntity());
				setMessage("Contact is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.contactService.remove(getEntityList().get(row).getId());
			setMessage("Contact with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.contactService.getEntityById(getEntityList()
				.get(row).getId()));
		return "contact?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Contact());
		return "Contact?faces-redirect=true";
	}

	public IContactService getContactService() {
		return contactService;
	}

	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}




	public String addContactCategory(String pageName) {
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
		childDataBean.setFrom("contactCategoryList");
		childDataBean.setName("org.demo.bean.yeni.ContactCategory");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "contactCategoryList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addContactExtraFields(String pageName) {
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
		childDataBean.setFrom("contactExtraFieldsList");
		childDataBean.setName("org.demo.bean.yeni.ContactExtraFields");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "contactExtraFieldsList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addSaleSeller(String pageName) {
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
		childDataBean.setFrom("saleSellerList");
		childDataBean.setName("org.demo.bean.yeni.SaleSeller");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "saleSellerList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



	public String addStockPriceList(String pageName) {
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
		childDataBean.setFrom("stockPriceListList");
		childDataBean.setName("org.demo.bean.yeni.StockPriceList");
		childDataBean.setParentDataBean(dataBean);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", childDataBean);
		return "stockPriceListList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
	}



}