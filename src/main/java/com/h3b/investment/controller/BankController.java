package com.h3b.investment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h3b.investment.exception.ResourceNotFoundException;
import com.h3b.investment.model.Bank;
import com.h3b.investment.service.BankService;


@RestController
@RequestMapping(value = "/api/v1", produces = {"application/json"})
public class BankController {

	@Autowired
	BankService bankService;
	
	@GetMapping("/bank")
	public List<Bank> listBanks(){
		return bankService.listBanks();
	}
	
	@GetMapping("/bank/{code}")
	public ResponseEntity<Bank> getBankByCode(@PathVariable("code") String code) throws ResourceNotFoundException{
		Bank bankResponse = bankService.getBankByCode(code);
		return ResponseEntity.ok().body(bankResponse);
	}
	
	
	@PostMapping("/bank")
	public Bank createBank(@Valid @RequestBody Bank bank){
		return bankService.createBank(bank);
	}
	
}
