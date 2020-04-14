package com.h3b.investment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.h3b.investment.model.contraint.CustomerBankPrimaryKey;

@Entity(name = "CustomerBank")
@IdClass(CustomerBankPrimaryKey.class)
public class CustomerBank {

	@Id
	@Column(name = "CustomerDoc")
	private String customerDoc;

	@Id
	@Column(name = "CodeBank")
	private String codeBank;

	@Column(name = "BranchCode")
	private String branchCode;

	@Column(name = "AccountNumber")
	private String accountNumber;

	public String getCustomerDoc() {
		return customerDoc;
	}

	public void setCustomerDoc(String customerDoc) {
		this.customerDoc = customerDoc;
	}

	public String getCodeBank() {
		return codeBank;
	}

	public void setCodeBank(String codeBank) {
		this.codeBank = codeBank;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((codeBank == null) ? 0 : codeBank.hashCode());
		result = prime * result + ((customerDoc == null) ? 0 : customerDoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBank other = (CustomerBank) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (branchCode == null) {
			if (other.branchCode != null)
				return false;
		} else if (!branchCode.equals(other.branchCode))
			return false;
		if (codeBank == null) {
			if (other.codeBank != null)
				return false;
		} else if (!codeBank.equals(other.codeBank))
			return false;
		if (customerDoc == null) {
			if (other.customerDoc != null)
				return false;
		} else if (!customerDoc.equals(other.customerDoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerBank [customerDoc=" + customerDoc + ", codeBank=" + codeBank + ", branchCode=" + branchCode
				+ ", accountNumber=" + accountNumber + "]";
	}

}
