package com.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;



//@ViewScoped
//@ManagedBean(name = "loginController")
//burayı kasten spring bean olarak bıraktım ve app-contexte singleton olarak tanımladım
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(LoginController.class);
	
	private String message;
	private String username;
	private String password;
	
	//@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager;
	
	public String login() {
		try{
			logger.info("Login started for User with Name: "+getUsername());
		
		 // check if userdata is given 
		 if (getUsername() == null || getPassword() == null) {
	            FacesMessage facesMsg = new FacesMessage(
	            FacesMessage.SEVERITY_ERROR, "Login not started because userName or Password is empty: "+getUsername(), "login.failed" );
	            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	            logger.info("Login not started because userName or Password is empty: "+getUsername());
	            return null;
	        }
	       
		 // authenticate afainst spring security
		 Authentication request = new UsernamePasswordAuthenticationToken(
				 getUsername(), getPassword());            
	            
	        Authentication result = authenticationManager.authenticate(request);
	        SecurityContextHolder.getContext().setAuthentication(result);
	 
	    } catch (AuthenticationException e) {
	    	logger.info("Login failed: " + e.getMessage());
	        FacesMessage facesMsg = new FacesMessage(
	            FacesMessage.SEVERITY_ERROR, "Login Failed!!", "login.failed") ;
	        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	            
	        return null;
	    }
	    return "main?faces-redirect=true";
		
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
