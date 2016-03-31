

    
        
                    
        
                                
        
                                            
        
                                                        
        
                                                                    
        
                                                                                
        
                                                                                            
        
                                                                                                        
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISaleSellerService;
import com.entity.SaleSeller;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "saleSellerController")
public class SaleSellerController extends BaseController<SaleSeller>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SaleSellerController.class);
	@ManagedProperty(value = "#{saleSellerService}")
	private ISaleSellerService saleSellerService;

	@Override
	public void createEntity() {
		SaleSeller saleSeller = new SaleSeller();
		setEntity(saleSeller);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<SaleSeller>());
	}

	@Override
	public void clean() {
		setEntity(new SaleSeller());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(saleSellerService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.saleSellerService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.saleSellerService.update(getEntity());
				setMessage("SaleSeller is successfully updated");
				clean();
			} else {
				this.saleSellerService.add(getEntity());
				setMessage("SaleSeller is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.saleSellerService.remove(getEntityList().get(row).getId());
			setMessage("SaleSeller with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.saleSellerService.getEntityById(getEntityList()
				.get(row).getId()));
		return "SaleSeller?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new SaleSeller());
		return "SaleSeller?faces-redirect=true";
	}

	public ISaleSellerService getSaleSellerService() {
		return saleSellerService;
	}

	public void setSaleSellerService(ISaleSellerService saleSellerService) {
		this.saleSellerService = saleSellerService;
	}




}