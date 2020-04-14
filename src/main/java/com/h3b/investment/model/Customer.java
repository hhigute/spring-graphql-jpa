package com.h3b.investment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name = "Customer")
public class Customer {
	
	@Id
	@Column(name =  "Document")
	private String document;
	@Column(name =  "Name")
	private String name;
	@Column(name =  "Phone")
	private String phone;
	
	@JsonIgnoreProperties("customers")
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinTable(name = "CustomerBank",
				joinColumns = {@JoinColumn(name = "CustomerDoc")},
				inverseJoinColumns = {@JoinColumn(name = "CodeBank")})
	private List<Bank> banks = new ArrayList<Bank>();
	
	public Customer() {
		
	}
	
	public Customer(String document, String name, String phone, List<Bank> banks) {
		this.document = document;
		this.name = name;
		this.phone = phone;
		this.banks = banks;
	}
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Bank> getBanks(){
		return banks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banks == null) ? 0 : banks.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Customer other = (Customer) obj;
		if (banks == null) {
			if (other.banks != null)
				return false;
		} else if (!banks.equals(other.banks))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [document=" + document + ", name=" + name + ", phone=" + phone + ", banks=" + banks + "]";
	}
	

}
