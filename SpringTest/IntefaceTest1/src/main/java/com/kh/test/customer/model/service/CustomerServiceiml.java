package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.customer.model.mapper.CustomerMapper;

@Service
@Transactional
public class CustomerServiceiml implements CustomerService {

	
	@Autowired
	private CustomerMapper mapper;
	
	
	
	@Override
	public int updateMember(String customer_name, String customer_tel, String customer_address) {
		
		return mapper.updateMember(customer_name,customer_tel,customer_address);
	}
		
	
	
	

}
