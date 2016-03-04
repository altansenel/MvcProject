package com.batch;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dao.IUserService;


public class AuthenticationUtil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IUserService userService;
	
 
    public void clearAuthentication() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
 
    public void configureAuthentication(String role) {
    	
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(role);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
        		userService.getUserByUsername("altan").getUsername(),
                role,
                authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}