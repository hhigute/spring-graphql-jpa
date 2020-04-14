package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Customer;
import com.h3b.investment.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1", produces = {"application/json"})
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer" )
	public List<Customer> listCustomer(){
		return customerService.listCustomer();
	}
	
	
	@GetMapping("/customer/{doc}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "doc") String doc) throws ResourceNotFoundException{
		Customer customerResponse = customerService.getCustomerById(doc);
		return ResponseEntity.ok().body(customerResponse);
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	
	@PutMapping("/customer/{doc}")
	public ResponseEntity<Customer> updateCustomer(	@PathVariable(name="doc") String doc,
													@Valid @RequestBody Customer customerRequest) 
															throws ResourceNotFoundException{
		
		Customer customer = customerService.updateCustomer(doc, customerRequest);
		
		return ResponseEntity.ok().body(customer);
	}
	
}
