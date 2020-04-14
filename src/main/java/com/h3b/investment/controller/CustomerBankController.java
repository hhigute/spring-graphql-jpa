package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.model.CustomerBank;
import com.h3b.investment.service.CustomerBankService;


@RestController
@RequestMapping(value="/api/v1" , produces = {"application/json"})
public class CustomerBankController {

	
	@Autowired
	CustomerBankService customerBankService; 
	
	
	@GetMapping("/customerBank")
	public List<CustomerBank> listCustomerBank(){
		return customerBankService.listCustomerBank();
	}
	
	@PostMapping("/customerBank")
	public CustomerBank createCustomerBank(@Valid @RequestBody CustomerBank customerBank) throws Exception{
	
		return customerBankService.createCustomerBank(customerBank);
		
	}
	
}
