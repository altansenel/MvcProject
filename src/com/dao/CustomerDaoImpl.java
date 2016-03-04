package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.Customer;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao {
private static final long serialVersionUID = 1L;
}
