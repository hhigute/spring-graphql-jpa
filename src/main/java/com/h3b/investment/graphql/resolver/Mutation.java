package com.h3b.investment.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h3b.investment.model.Bank;
import com.h3b.investment.model.Customer;
import com.h3b.investment.repository.BankRepository;
import com.h3b.investment.repository.CustomerRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {

	private CustomerRepository customerRepository;

	private BankRepository bankRepository;

	@Autowired
	public Mutation(CustomerRepository customerRepository, BankRepository bankRepository) {
		this.customerRepository = customerRepository;
		this.bankRepository = bankRepository;
	}

	public Customer createCustomer(String document, String name, String phone) {
		Customer customer = new Customer();
		customer.setDocument(document);
		customer.setName(name);
		customer.setPhone(phone);
		customerRepository.save(customer);

		return customer;
	}

	public Bank createBank(String code, String contactName, String contactPhone, String name) {
		Bank bank = new Bank();
		bank.setCode(code);
		bank.setContactName(contactName);
		bank.setContactPhone(contactPhone);
		bank.setName(name);

		bankRepository.save(bank);

		return bank;
	}

	public Bank updateBank(String code, String contactName, String contactPhone, String name) throws NotFoundException {
		Optional<Bank> optBank = bankRepository.findById(code);

		if (optBank.isPresent()) {
			Bank bank = optBank.get();

			if (contactName != null)
				bank.setContactName(contactName);

			if (contactPhone != null)
				bank.setContactPhone(contactPhone);

			if (name != null)
				bank.setName(name);

			bankRepository.save(bank);
			return bank;
		}

		throw new NotFoundException("Not found Bank to update!");
	}

}