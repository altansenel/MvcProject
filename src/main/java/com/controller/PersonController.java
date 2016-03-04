package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.dao.IPersonService;
import com.entity.Person;
import com.enums.ProjectEnum.RelationType;


@ViewScoped
@ManagedBean(name = "personController")
public class PersonController extends BaseController<Person> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PersonController.class);

	@ManagedProperty(value = "#{personService}")
	private IPersonService personService;
	//private IPersonService personService = new PersonServiceImpl(new PersonDaoImpl());


	
	@Override
	public void createEntity() {
		Person person = new Person();
		//person.setSehir(new Sehir());
		setEntity(person);		
	}
	
	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Person>());	
	}
	
	@Override
	public void clean() {
		setEntity(new Person());
		getEntityList().clear();
	}
	
	@Override
	public void setEid(Long eid) {
		setEntity(personService.getEntityById(eid));
		this.eid = eid; 
	}
	
	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.personService.list(getEntity()));
	}

//	public void doSave(Long id) {
//		try {
//			if (id != null) {
//				this.personService.update(getEntity());
//				setMessage("Person is successfully updated");
//				clean();
//			} else {
//				this.personService.add(getEntity());
//				setMessage("Person is successfully created");
//				clean();
//			}
//		} catch (Exception e) {
//			logger.error(e);
//			setMessage(e.getMessage());
//		}
//	}
	public void save(Long id) {
		try {
			if (id != null) {
				this.personService.update(getEntity());
				setMessage("Person is successfully updated");
				clean();
			} else {
				this.personService.add(getEntity());
				setMessage("Person is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}
	
	public void remove(int row) {
		try {
			this.personService.remove(getEntityList().get(row).getId());
			setMessage("Person with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}
	
	public String edit(int row) {
		setEntity(this.personService.getEntityById(getEntityList().get(row).getId()));
		return "person?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Person());
		return "person?faces-redirect=true";
	}
	
	public String addSehir(String pageName) {
		DataBean dataBean = new DataBean();
		dataBean.setObj(getEntity());
		dataBean.setName(getEntity().getClass().getName());//daha önce person idi
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("obj", dataBean);
		return "sehirList?faces-redirect=true&from=" + pageName +"&relationType=" + RelationType.manyToOne.ordinal();
	}

	public IPersonService getPersonService() {
		return personService;
	}

	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}


}