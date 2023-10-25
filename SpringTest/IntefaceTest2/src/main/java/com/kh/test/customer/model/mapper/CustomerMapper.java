package com.kh.test.customer.model.mapper;

import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import com.kh.test.customer.model.dto.Customer;

@Mapper
public interface CustomerMapper {

	int updateCustomer(Customer customer);


}