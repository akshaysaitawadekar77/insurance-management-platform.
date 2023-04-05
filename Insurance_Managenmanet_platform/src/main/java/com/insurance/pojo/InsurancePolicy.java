package com.insurance.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Long id;

   private String policyNumber;

   private String type;

   private Double coverageAmount;

   private Double premium;

   private LocalDate startDate;

   private LocalDate endDate;
  
   
   
   
@OneToMany(targetEntity = Claim.class,cascade = CascadeType.ALL)
   @JoinColumn(name="ip_fk ",referencedColumnName = "id")
   private List<Claim> claims = new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPolicyNumber() {
	return policyNumber;
}

public void setPolicyNumber(String policyNumber) {
	this.policyNumber = policyNumber;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Double getCoverageAmount() {
	return coverageAmount;
}

public void setCoverageAmount(Double coverageAmount) {
	this.coverageAmount = coverageAmount;
}

public Double getPremium() {
	return premium;
}

public void setPremium(Double premium) {
	this.premium = premium;
}

public LocalDate getStartDate() {
	return startDate;
}

public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

public LocalDate getEndDate() {
	return endDate;
}

public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}


public List<Claim> getClaims() {
	return claims;
}

public void setClaims(List<Claim> claims) {
	this.claims = claims;
}


public InsurancePolicy() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "InsurancePolicy [id=" + id + ", policyNumber=" + policyNumber + ", type=" + type + ", coverageAmount="
			+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
			+ ", claims=" + claims + "]";
}

public InsurancePolicy(Long id, String policyNumber, String type, Double coverageAmount, Double premium,
		LocalDate startDate, LocalDate endDate, List<Claim> claims) {
	super();
	this.id = id;
	this.policyNumber = policyNumber;
	this.type = type;
	this.coverageAmount = coverageAmount;
	this.premium = premium;
	this.startDate = startDate;
	this.endDate = endDate;
	this.claims = claims;
}




   
}
