package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.pojo.Client;
import com.insurance.pojo.InsurancePolicy;
import com.insurance.service.InsuranceService;

@RestController
@RequestMapping("/api/policies")
public class InsuranceController {

	
	@Autowired
	private InsuranceService InsuranceService;
	
	
	 @GetMapping
	   public List<InsurancePolicy> getAllInsurancePolicies() {
	       return InsuranceService.getAllInsurancePolicies();
	   }

	   @GetMapping("/{id}")
	   public InsurancePolicy getInsurancePolicyById(@PathVariable long id) {
	       return InsuranceService.getInsurancePolicyById(id);
	   }

	   @PostMapping
	   public String createInsurancePolicy(@RequestBody InsurancePolicy policy) {
	       return InsuranceService.createInsurancePolicy(policy);
	   }

	   @PutMapping("/{id}")
	   public InsurancePolicy updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
	       return InsuranceService.updateInsurancePolicy(id, policy);
	   }

	   @DeleteMapping("/{id}")
	   public String deleteInsurancePolicy(@PathVariable Long id) {
	       return InsuranceService.deleteInsurancePolicy(id);
}
	  
	   
}