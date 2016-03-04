package com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.dao.IProductService;
import com.entity.Product;

@ViewScoped
@ManagedBean(name = "productController")
public class ProductController extends BaseController<Product> implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ProductController.class);
	@ManagedProperty(value = "#{productService}")
	private IProductService productService;

	@Override
	public void createEntity() {
		Product product = new Product();
		setEntity(product);
	}

	@Override
	public void createEntityList() {
		setEntityList(new ArrayList<Product>());
	}

	@Override
	public void clean() {
		setEntity(new Product());
		getEntityList().clear();
	}

	@Override
	public void setEid(Long eid) {
		setEntity(productService.getEntityById(eid));
		this.eid = eid;
	}

	@PostConstruct
	public void init() {
		initBase();
	}

	public void search() {
		setMessage(null);
		setEntityList(this.productService.list(getEntity()));
	}

	public void save(Long id) {
		try {
			if (id != null) {
				this.productService.update(getEntity());
				setMessage("Product is successfully updated");
				clean();
			} else {
				this.productService.add(getEntity());
				setMessage("Product is successfully created");
				clean();
			}
		} catch (Exception e) {
			logger.error(e);
			setMessage(e.getMessage());
		}
	}

	public void remove(int row) {
		try {
			this.productService.remove(getEntityList().get(row).getId());
			setMessage("Product with id: " + getEntityList().get(row).getId()
					+ " is succesfully deleted");
			getEntityList().remove(row);
		} catch (Exception e) {
			setMessage(e.getMessage());
		}
	}

	public String edit(int row) {
		setEntity(this.productService.getEntityById(getEntityList().get(row)
				.getId()));
		return "product?faces-redirect=true&entityId="
				+ getEntityList().get(row).getId();
	}

	public String newEntity() {
		setMessage(null);
		setEntity(new Product());
		return "product?faces-redirect=true";
	}

	public IProductService getPersonService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

}