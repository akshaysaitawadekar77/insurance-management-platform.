package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ClaimNotFoundException;
import com.insurance.exception.InsurancePolicyNotFoundException;
import com.insurance.pojo.Claim;
import com.insurance.pojo.InsurancePolicy;
import com.insurance.repo.ClaimRepository;
@Service
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	public List<Claim> getAllIClaims() {
		List<Claim> clm = claimRepository.findAll();
		if(clm.isEmpty()) {
			throw new ClaimNotFoundException("No Any Claim Regitered");
		}
		else {
			return clm;
		}
		
		
	}

	public Claim getClaimById(Long id) {
		 Optional<Claim> getc=claimRepository.findById(id);
		if(getc.isEmpty()) {
			throw new ClaimNotFoundException(id);
		}
		else {
			return getc.get();
		}
		
		
		
	}

	public String createClaim(Claim claim) {
		
		if (claim.getClaimNumber()==null|| claim.getClaimNumber()=="" ) {
			return "Please give claim number....";
		}
		else {
			claimRepository.save(claim);
	 	 return"new Policy added successfully with Id : "+claim.getId();
		}
	}

	public Claim updateClaim(Long id, Claim claim1) {
		Optional<Claim> claim = claimRepository.findById(id);

		if(claim.isPresent()) {
		claim.get().setClaimNumber(claim1.getClaimNumber());
		claim.get().setClaimStatus(claim1.getClaimStatus());
		claim.get().setClaimDate(claim1.getClaimDate());
		claim.get().setDescription(claim1.getDescription());
		claim.get().setId(claim1.getId());
		return claimRepository.save(claim.get());
		}
		else {
			throw new ClaimNotFoundException(id);
		}
	}

	public String deleteIClaim(Long id) {
		
		Optional<Claim> cld=claimRepository.findById(id);
		if(cld.isPresent()) {
			claimRepository.deleteById(id);
			return "Successfully Deleted";
			}
			else
			{
				throw new ClaimNotFoundException(id);
			}	
	}

}
