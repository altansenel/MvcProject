package com.dao;import org.springframework.stereotype.Service;
import com.entity.Employee;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, IEmployeeDao> implements IEmployeeService {
private static final long serialVersionUID = 1L;


}
