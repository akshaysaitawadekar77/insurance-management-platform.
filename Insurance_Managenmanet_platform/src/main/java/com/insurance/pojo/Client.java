package com.insurance.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @NotBlank(message = "name is required")
   private String name;

   
   private LocalDate dateOfBirth;

   @NotNull
   @NotEmpty(message = "Address is required")
   private String address;

   @Pattern(regexp = "^(91)[6-9][0-9]{9}$", message = "Please enter a valid Indian mobile number")

   private String contactInfo;
   
   
   @OneToMany(targetEntity = InsurancePolicy.class,cascade = CascadeType.ALL)
   @JoinColumn(name="cp_fk",referencedColumnName = "id")
   
   private List<InsurancePolicy> policies = new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getContactInfo() {
	return contactInfo;
}

public void setContactInfo(String contactInfo) {
	this.contactInfo = contactInfo;
}

public List<InsurancePolicy> getPolicies() {
	return policies;
}

public void setPolicies(List<InsurancePolicy> policies) {
	this.policies = policies;
}

@Override
public String toString() {
	return "Client [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
			+ ", contactInfo=" + contactInfo + ", policies=" + policies + "]";
}

public Client(Long id, String name, LocalDate dateOfBirth, String address, String contactInfo,
		List<InsurancePolicy> policies) {
	super();
	this.id = id;
	this.name = name;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.contactInfo = contactInfo;
	this.policies = policies;
}

public Client() {
	super();
	// TODO Auto-generated constructor stub
}

   
}
