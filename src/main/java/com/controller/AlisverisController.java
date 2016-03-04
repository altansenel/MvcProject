package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IAlisverisService;
import com.entity.Alisveris;
import com.enums.ProjectEnum.RelationType;
import com.enums.ProjectEnum.AddSelect;

@ViewScoped
@ManagedBean(name = "alisverisController")
public class AlisverisController extends BaseController<Alisveris> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(AlisverisController.class);
@ManagedProperty(value = "#{alisverisService}")
private IAlisverisService alisverisService;

@Override
public void createEntity() {
Alisveris alisveris = new Alisveris();
setEntity(alisveris);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Alisveris>());
}

@Override
public void clean() {
setEntity(new Alisveris());
getEntityList().clear();
setDataBean(null);
}

@Override
public void setEid(Long eid) {
setEntity(alisverisService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.alisverisService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.alisverisService.update(getEntity());
setMessage("Alisveris is successfully updated");
clean();
} else {
this.alisverisService.add(getEntity());
setMessage("Alisveris is successfully created");
clean();
}
} catch (Exception e) {
logger.error(e);
setMessage(e.getMessage());
}
}
}

public void remove(int row) {
try {
this.alisverisService.remove(getEntityList().get(row).getId());
setMessage("Alisveris with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.alisverisService.getEntityById(getEntityList().get(row).getId()));
return "alisveris?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Alisveris());
return "alisveris?faces-redirect=true";
}

public IAlisverisService getPersonService() {
return alisverisService;
}

public void setAlisverisService(IAlisverisService alisverisService) {
this.alisverisService = alisverisService;
}

public String addKitapManyToOne(String pageName) {
DataBean dataBean = new DataBean();
if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj")!=null){
		dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
	}
	dataBean.setObj(getEntity());
	dataBean.setName(getEntity().getClass().getName());
	dataBean.setFrom(pageName);
	dataBean.setRelationType(RelationType.manyToOne);
	DataBean childDataBean = new DataBean();
	childDataBean.setFrom("kitapList");
	childDataBean.setName("com.entity.Kitap");
	childDataBean.setParentDataBean(dataBean);
	FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.put("obj", childDataBean);
	return "kitapList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
}
public String addOgrenciManyToOne(String pageName) {
DataBean dataBean = new DataBean();
if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj")!=null){
		dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
	}
	dataBean.setObj(getEntity());
	dataBean.setName(getEntity().getClass().getName());
	dataBean.setFrom(pageName);
	dataBean.setRelationType(RelationType.manyToOne);
	DataBean childDataBean = new DataBean();
	childDataBean.setFrom("ogrenciList");
	childDataBean.setName("com.entity.Ogrenci");
	childDataBean.setParentDataBean(dataBean);
	FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.put("obj", childDataBean);
	return "ogrenciList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
}
}