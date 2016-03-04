package com.dao;

import org.springframework.stereotype.Service;

import com.entity.Customer;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, ICustomerDao> implements ICustomerService {
	private static final long serialVersionUID = 1L;

}
