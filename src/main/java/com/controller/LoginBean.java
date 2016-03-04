package com.controller;
import java.io.Serializable;
public class LoginBean  implements Serializable{

	private static final long serialVersionUID = 6175255537226165236L;

	private String userName;
	private String password;
	
	
	public void reset(){
		userName = "";
		password = "";
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

}