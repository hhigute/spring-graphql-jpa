package com.h3b.investment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Bank;
import com.h3b.investment.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;
	

	public List<Bank> listBanks(){
		return bankRepository.findAll();
	}
	
	public Bank getBankByCode(String code) throws ResourceNotFoundException{
		Bank bankResponse = bankRepository.findById(code)
											.orElseThrow(
												()-> new ResourceNotFoundException("Bank not found for code: "+code));
		return bankResponse;
	}
		
	public Bank createBank(Bank bank){
		return bankRepository.save(bank);
	}
}
