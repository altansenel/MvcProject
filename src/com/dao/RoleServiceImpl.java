package com.dao;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.entity.Role;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, IRoleDao> implements IRoleService,Serializable {
	


	private static final long serialVersionUID = 1L;

}
