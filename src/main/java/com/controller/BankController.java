

    
        
                    
        
                                
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IBankService;
import com.entity.Bank;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "bankController")
public class BankController extends BaseController<Bank>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(BankController.class);
	@ManagedProperty(value = "#{bankService}")
	private IBankService bankService;

	@Override
	public void createEntity() {
		Bank bank = new Bank();
		setEntity(bank);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Bank>());
	}

	@Override
	public void clean() {
		setEntity(new Bank());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(bankService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.bankService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.bankService.update(getEntity());
				setMessage("Bank is successfully updated");
				clean();
			} else {
				this.bankService.add(getEntity());
				setMessage("Bank is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.bankService.remove(getEntityList().get(row).getId());
			setMessage("Bank with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.bankService.getEntityById(getEntityList()
				.get(row).getId()));
		return "Bank?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Bank());
		return "Bank?faces-redirect=true";
	}

	public IBankService getBankService() {
		return bankService;
	}

	public void setBankService(IBankService bankService) {
		this.bankService = bankService;
	}




}