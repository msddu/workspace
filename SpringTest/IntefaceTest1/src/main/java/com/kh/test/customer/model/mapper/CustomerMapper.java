package com.kh.test.customer.model.mapper;

import java.lang.reflect.Member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

	int updateMember(String customer_name, String customer_tel, String customer_address);

	
	
	
	
	
}
