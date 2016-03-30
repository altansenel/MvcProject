

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IBankTransSourceService;
import com.entity.BankTransSource;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "bankTransSourceController")
public class BankTransSourceController extends BaseController<BankTransSource>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(BankTransSourceController.class);
	@ManagedProperty(value = "#{bankTransSourceService}")
	private IBankTransSourceService bankTransSourceService;

	@Override
	public void createEntity() {
		BankTransSource bankTransSource = new BankTransSource();
		setEntity(bankTransSource);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<BankTransSource>());
	}

	@Override
	public void clean() {
		setEntity(new BankTransSource());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(bankTransSourceService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.bankTransSourceService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.bankTransSourceService.update(getEntity());
				setMessage("BankTransSource is successfully updated");
				clean();
			} else {
				this.bankTransSourceService.add(getEntity());
				setMessage("BankTransSource is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.bankTransSourceService.remove(getEntityList().get(row).getId());
			setMessage("BankTransSource with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.bankTransSourceService.getEntityById(getEntityList()
				.get(row).getId()));
		return "bankTransSource?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new BankTransSource());
		return "BankTransSource?faces-redirect=true";
	}

	public IBankTransSourceService getBankTransSourceService() {
		return bankTransSourceService;
	}

	public void setBankTransSourceService(IBankTransSourceService bankTransSourceService) {
		this.bankTransSourceService = bankTransSourceService;
	}




}