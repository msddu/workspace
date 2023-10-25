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
	
	private int customerNo;
	private String customerName;
	private int customerTel;
	private String customerAddress;
}
