package com.dao;
import org.springframework.stereotype.Repository;
import com.entity.Employee;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements IEmployeeDao {
private static final long serialVersionUID = 1L;
}
