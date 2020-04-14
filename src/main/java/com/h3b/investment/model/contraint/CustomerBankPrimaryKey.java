package com.h3b.investment.model.contraint;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerBankPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CustomerDoc")
	private String customerDoc;


	@Column(name = "CodeBank")
	private String codeBank;
	
	
	
}
