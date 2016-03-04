package com.controller;import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import com.dao.IOgrenciService;
import com.entity.Ogrenci;
import com.enums.ProjectEnum.RelationType;
import com.enums.ProjectEnum.AddSelect;

@ViewScoped
@ManagedBean(name = "ogrenciController")
public class OgrenciController extends BaseController<Ogrenci> implements Serializable{
private static final long serialVersionUID = 1L;
private static final Logger logger = Logger.getLogger(OgrenciController.class);
@ManagedProperty(value = "#{ogrenciService}")
private IOgrenciService ogrenciService;

@Override
public void createEntity() {
Ogrenci ogrenci = new Ogrenci();
setEntity(ogrenci);
}

@Override
public void createEntityList() {
setEntityList(new ArrayList<Ogrenci>());
}

@Override
public void clean() {
setEntity(new Ogrenci());
getEntityList().clear();
setDataBean(null);
}

@Override
public void setEid(Long eid) {
setEntity(ogrenciService.getEntityById(eid));
this.eid = eid;
}

@PostConstruct
public void init() {
initBase();
}

public void search() {
setMessage(null);
setEntityList(this.ogrenciService.list(getEntity()));
}

public void save(Long id) {
if (FacesContext.getCurrentInstance().getMessageList().size()==0) {
try {
if (id != null) {
this.ogrenciService.update(getEntity());
setMessage("Ogrenci is successfully updated");
clean();
} else {
this.ogrenciService.add(getEntity());
setMessage("Ogrenci is successfully created");
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
this.ogrenciService.remove(getEntityList().get(row).getId());
setMessage("Ogrenci with id: " + getEntityList().get(row).getId()
+ " is succesfully deleted");
getEntityList().remove(row);
} catch (Exception e) {
setMessage(e.getMessage());
}
}

public String edit(int row) {
setEntity(this.ogrenciService.getEntityById(getEntityList().get(row).getId()));
return "ogrenci?faces-redirect=true&entityId=" + getEntityList().get(row).getId();
}

public String newEntity() {
setMessage(null);
setEntity(new Ogrenci());
return "ogrenci?faces-redirect=true";
}

public IOgrenciService getPersonService() {
return ogrenciService;
}

public void setOgrenciService(IOgrenciService ogrenciService) {
this.ogrenciService = ogrenciService;
}

public String addSinifManyToOne(String pageName) {
DataBean dataBean = new DataBean();
if(FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj")!=null){
		dataBean = (DataBean) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("obj");
	}
	dataBean.setObj(getEntity());
	dataBean.setName(getEntity().getClass().getName());
	dataBean.setFrom(pageName);
	dataBean.setRelationType(RelationType.manyToOne);
	DataBean childDataBean = new DataBean();
	childDataBean.setFrom("sinifList");
	childDataBean.setName("com.entity.Sinif");
	childDataBean.setParentDataBean(dataBean);
	FacesContext.getCurrentInstance().getExternalContext().getFlash()
			.put("obj", childDataBean);
	return "sinifList?faces-redirect=true&addSelect=" + AddSelect.ADD.ordinal();
}
}