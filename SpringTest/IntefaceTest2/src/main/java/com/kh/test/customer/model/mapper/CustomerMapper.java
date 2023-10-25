package com.kh.test.customer.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

	int updateMember(int inputNo, String inputName, int inputTel, String inputAddress);

	


}