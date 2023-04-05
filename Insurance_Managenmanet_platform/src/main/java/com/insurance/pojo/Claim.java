package com.insurance.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "claims")
public class Claim implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String claimNumber;

   private String description;

   private LocalDate claimDate;

   private String claimStatus;

 
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getClaimNumber() {
	return claimNumber;
}

public void setClaimNumber(String claimNumber) {
	this.claimNumber = claimNumber;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDate getClaimDate() {
	return claimDate;
}

public void setClaimDate(LocalDate claimDate) {
	this.claimDate = claimDate;
}

public String getClaimStatus() {
	return claimStatus;
}

public void setClaimStatus(String claimStatus) {
	this.claimStatus = claimStatus;
}
/*
public InsurancePolicy getPolicy() {
	return policy;
}

public void setPolicy(InsurancePolicy policy) {
	this.policy = policy;
}

*/

public Claim() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Claim [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description + ", claimDate="
			+ claimDate + ", claimStatus=" + claimStatus + "]";
}

public Claim(Long id, String claimNumber, String description, LocalDate claimDate, String claimStatus) {
	super();
	this.id = id;
	this.claimNumber = claimNumber;
	this.description = description;
	this.claimDate = claimDate;
	this.claimStatus = claimStatus;
}



}
