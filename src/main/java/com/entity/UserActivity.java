package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.enums.ProjectEnum.UserActivityAction;

@Entity
@Table(name = "USER_ACTIVITY", indexes = { @Index(columnList = "user_id", name = "IND_USER_ACTIVITY_USER") })
public class UserActivity extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "ip")
	private String ip;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ACTIVITY_USER"))
	private User user;
	
	@Column(name = "action")
	private UserActivityAction action;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "TARIH")
	private Date tarih;
	
	@Column(name = "class")
	private String className;
	
	@Column(name = "objectid")
	private Integer objectid; //bunu da integer yaptım!!

	
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserActivityAction getAction() {
		return action;
	}

	public void setAction(UserActivityAction action) {
		this.action = action;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getObjectid() {
		return objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}
	

}
