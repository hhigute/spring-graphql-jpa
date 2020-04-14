package com.h3b.investment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3b.investment.model.CustomerBank;
import com.h3b.investment.repository.CustomerBankRepository;

@Service
public class CustomerBankService {

	@Autowired
	CustomerBankRepository customerBankRepository; 
	
	public List<CustomerBank> listCustomerBank(){
		return customerBankRepository.findAll();
	}
	
	public CustomerBank createCustomerBank(CustomerBank customerBank) throws Exception{
	
		return customerBankRepository.save(customerBank);
		
	}
}
