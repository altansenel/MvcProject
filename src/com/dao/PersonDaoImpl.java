package com.dao;

import org.springframework.stereotype.Repository;

import com.entity.Person;


@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements IPersonDao {
	
	private static final long serialVersionUID = 1L;

}