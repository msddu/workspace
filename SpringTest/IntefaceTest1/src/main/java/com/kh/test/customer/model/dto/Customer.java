package com.kh.test.customer.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	

	private int Customer_No;
	private String Customer_Name;
	private String Customer_Tel;
	private String Customer_Address;
}
