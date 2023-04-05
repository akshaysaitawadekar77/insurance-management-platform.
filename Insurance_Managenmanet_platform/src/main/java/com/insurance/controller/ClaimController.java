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

import com.insurance.pojo.Claim;
import com.insurance.pojo.InsurancePolicy;
import com.insurance.service.ClaimService;
@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	 @GetMapping
	   public List<Claim> getAllIClaims() {
	       return claimService.getAllIClaims();
	   }

	   @GetMapping("/{id}")
	   public Claim getClaimById(@PathVariable long id) {
	       return claimService.getClaimById(id);
	   }

	   @PostMapping
	   public String createClaim(@RequestBody Claim Claim) {
	       return claimService.createClaim(Claim);
	   }

	   @PutMapping("/{id}")
	   public Claim updateClaim(@PathVariable Long id, @RequestBody Claim Claim) {
	       return claimService.updateClaim(id, Claim);
	   }

	   @DeleteMapping("/{id}")
	   public String deleteInsurancePolicy(@PathVariable Long id) {
	       return claimService.deleteIClaim(id);
}
}
