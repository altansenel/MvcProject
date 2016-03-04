package com.converter;import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import com.dao.IProductService;
import com.entity.Product;

@ManagedBean(name = "productConverter")
@RequestScoped
public class ProductConverter extends BaseConverter<Product> implements Converter, Serializable {

private static final long serialVersionUID = 1L;

@ManagedProperty(value = "#{productService}")
private IProductService productService;

public void setProductService(IProductService productService) {
this.productService =productService;setEntityService(productService); 
}

public IProductService getProductService() {
return productService;
}
}
