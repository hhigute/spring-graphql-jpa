package com.h3b.investment.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h3b.investment.model.Bank;
import com.h3b.investment.model.Customer;
import com.h3b.investment.repository.BankRepository;
import com.h3b.investment.repository.CustomerRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{

	private CustomerRepository customerRepository;

	private BankRepository bankRepository;

	@Autowired
	public Query(CustomerRepository customerRepository, BankRepository bankRepository) {
		this.customerRepository = customerRepository;
		this.bankRepository = bankRepository;
	}

	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	public Iterable<Bank> findAllBanks() {
		return bankRepository.findAll();
	}

	public long countCustomers() {
		return customerRepository.count();
	}

	public long countBanks() {
		return bankRepository.count();
	}

}