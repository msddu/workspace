package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.mapper.CustomerMapper;

@Service
public class CustomerServiceiml implements CustomerService {

	
	@Autowired
	private CustomerMapper mapper;
	
	
	@Override
	public int updateMember(int inputNo, String inputName, int inputTel, String inputAddress) {

		return mapper.updateMember(inputNo,inputName,inputTel,inputAddress);
	}

}
