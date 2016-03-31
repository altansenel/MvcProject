

    
        
    

package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.ISafeExpenseService;
import com.entity.SafeExpense;
import com.enums.ProjectEnum.AddSelect;
import com.enums.ProjectEnum.RelationType;



@ViewScoped
@ManagedBean(name = "safeExpenseController")
public class SafeExpenseController extends BaseController<SafeExpense>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SafeExpenseController.class);
	@ManagedProperty(value = "#{safeExpenseService}")
	private ISafeExpenseService safeExpenseService;

	@Override
	public void createEntity() {
		SafeExpense safeExpense = new SafeExpense();
		setEntity(safeExpense);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<SafeExpense>());
	}

	@Override
	public void clean() {
		setEntity(new SafeExpense());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(safeExpenseService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.safeExpenseService.list(getEntity()));
	}

	public void save(Integer id) {
		try {
			if (id != null) {
				this.safeExpenseService.update(getEntity());
				setMessage("SafeExpense is successfully updated");
				clean();
			} else {
				this.safeExpenseService.add(getEntity());
				setMessage("SafeExpense is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.safeExpenseService.remove(getEntityList().get(row).getId());
			setMessage("SafeExpense with id: "
					+ getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.safeExpenseService.getEntityById(getEntityList()
				.get(row).getId()));
		return "SafeExpense?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new SafeExpense());
		return "SafeExpense?faces-redirect=true";
	}

	public ISafeExpenseService getSafeExpenseService() {
		return safeExpenseService;
	}

	public void setSafeExpenseService(ISafeExpenseService safeExpenseService) {
		this.safeExpenseService = safeExpenseService;
	}




}