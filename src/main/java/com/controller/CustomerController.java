package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.dao.ICustomerService;
import com.dao.IHerHangiBirService;
import com.entity.Customer;
import com.mail.MailUtil;
import com.scheduler.ScheduledJobDemo;

@ViewScoped
@ManagedBean(name = "customerController")
public class CustomerController extends BaseController<Customer> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	@ManagedProperty(value = "#{customerService}")
	private ICustomerService customerService;

	@ManagedProperty(value = "#{scheduledJobDemo}")
	private ScheduledJobDemo scheduledJobDemo;
	
	@ManagedProperty(value = "#{mailUtil}")
	private MailUtil mailUtil;
	
	@ManagedProperty(value = "#{herHangiBirService}")
	private IHerHangiBirService herHangiBirService;
	

	public void yeniBatchDemo() {	
		scheduledJobDemo.demoServiceMethod();
	}

	@Override
	public void createEntity() {
		Customer customer = new Customer();
		setEntity(customer);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Customer>());
	}

	@Override
	public void clean() {
		setEntity(new Customer());
		getEntityList().clear();
	}

	@Override
	public void setEid(Integer eid) {
		setEntity(customerService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		yeniBatchDemo();
		herHangiBirService.HerHangiBirIslem();
		mailUtil.sendMail("altan.senel@gunessigorta.com.tr", "altansenel@gmail.com",  "asdsadsa", "fgfhghghghgf");
		setMessage(null);
		setEntityList(this.customerService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.customerService.update(getEntity());
				setMessage("Customer is successfully updated");
				clean();
			} else {
				this.customerService.add(getEntity());
				setMessage("Customer is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.customerService.remove(getEntityList().get(row).getId());
			setMessage("Customer with id: " + getEntityList().get(row).getId() + " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.customerService.getEntityById(getEntityList().get(row).getId()));
		return "customer?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Customer());
		return "customer?faces-redirect=true";
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public ScheduledJobDemo getScheduledJobDemo() {
		return scheduledJobDemo;
	}

	public void setScheduledJobDemo(ScheduledJobDemo scheduledJobDemo) {
		this.scheduledJobDemo = scheduledJobDemo;
	}

	public MailUtil getMailUtil() {
		return mailUtil;
	}

	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	public IHerHangiBirService getHerHangiBirService() {
		return herHangiBirService;
	}

	public void setHerHangiBirService(IHerHangiBirService herHangiBirService) {
		this.herHangiBirService = herHangiBirService;
	}
	
}