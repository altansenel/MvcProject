package com.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

        // beans used by this controller, injected by spring
	private LoginBean loginBean;
	private AuthenticationManager authenticationManager;
	
        /**
	 * the login action called by the view
	 * @return
	 */
	public String login() {
		try{
			logger.info("Login started for User with Name: "+getLoginBean().getUserName());
		
		 // check if userdata is given 
		 if (getLoginBean().getUserName() == null || getLoginBean().getPassword() == null) {
	            FacesMessage facesMsg = new FacesMessage(
	            FacesMessage.SEVERITY_ERROR, "Login not started because userName or Password is empty: "+getLoginBean().getUserName(), "login.failed" );
	            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	            logger.info("Login not started because userName or Password is empty: "+getLoginBean().getUserName());
	            return null;
	        }
	       
		 // authenticate afainst spring security
		 Authentication request = new UsernamePasswordAuthenticationToken(
				 getLoginBean().getUserName(), getLoginBean().getPassword());            
	            
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

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	 
}