package com.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ICustomerService;
import com.entity.Customer;


public class CustomWriter2 implements ItemWriter<Report2> {
	
	@Autowired
	private ICustomerService customerService;

//  @Override
//  public void write(List<? extends Report2> items) throws Exception {
//
//	System.out.println("writer..." + items.size());		
//	for(Report2 item : items){
//		System.out.println(item);
//	}
//
//  }
  
  @Override
  public void write(List<? extends Report2> items) throws Exception
  {
      for( Report2 item : items )
      {
//    		private int refId;
//    		private String name;
//    		private int age;
//    		private Date dob;
//    		private BigDecimal income;
    	  
    	  Customer customer = new Customer();
    	  customer.setCompanyName((item.getName() + "asdsad").substring(0,5));
    	  customerService.add(customer);
      }
  }

}
