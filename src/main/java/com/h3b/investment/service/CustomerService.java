package com.h3b.investment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Customer;
import com.h3b.investment.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> listCustomer(){
		return customerRepository.findAll();
	}
	

	public Customer getCustomerById(String doc) throws ResourceNotFoundException{
		
		Customer customerResponse = customerRepository.findById(doc)
														.orElseThrow(
																()-> new ResourceNotFoundException("Customer not found for document: "+doc)
															
														);
		
		return customerResponse;
		
	}
	

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	

	public Customer updateCustomer(String doc, Customer customerRequest) 
															throws ResourceNotFoundException{
		
		Customer customer = customerRepository.findById(doc)
												.orElseThrow(
														()-> new ResourceNotFoundException("Customer not found for document: "+doc));
		
		customer.setDocument(customerRequest.getDocument());
		customer.setName(customerRequest.getName());
		customer.setPhone(customerRequest.getPhone());
		
		final Customer customerUpdated = customerRepository.save(customer);
		
		return customerUpdated;
	}

}
