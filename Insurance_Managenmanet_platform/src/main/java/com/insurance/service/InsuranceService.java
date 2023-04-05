package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ClientNotFoundException;
import com.insurance.exception.InsurancePolicyNotFoundException;
import com.insurance.pojo.Client;
import com.insurance.pojo.InsurancePolicy;
import com.insurance.repo.InsurancePolicyRepository;

@Service
public class InsuranceService {

	@Autowired
	private InsurancePolicyRepository insRepository;

	public List<InsurancePolicy> getAllInsurancePolicies() {
		
		
		
		List<InsurancePolicy> ip=insRepository.findAll();
		
		if(ip.isEmpty()) {
			throw new InsurancePolicyNotFoundException("No Any policies Regitered");
		}
		else {
			return ip;
		}

	}

	public InsurancePolicy getInsurancePolicyById(Long id) {
		
		Optional<InsurancePolicy> inpo=insRepository.findById(id);
		if(inpo.isEmpty()) {
			throw new InsurancePolicyNotFoundException(id);
		}
		else {
			return inpo.get();
		}
	}

	public String createInsurancePolicy(InsurancePolicy policy) {
		

		if (policy.getPolicyNumber()==null|| policy.getPolicyNumber()=="" ) {
			return "Please give policy number....";
		}
		else {
			insRepository.save(policy);
	 	 return"new Policy added successfully with Id : "+policy.getId();
		}
	}

	public InsurancePolicy updateInsurancePolicy(Long id, InsurancePolicy policy1) {
		Optional<InsurancePolicy> policy = insRepository.findById(id);

		if(policy.isPresent()) {
		policy.get().setPolicyNumber(policy1.getPolicyNumber());
		policy.get().setType(policy1.getType());
		policy.get().setCoverageAmount(policy1.getCoverageAmount());
		policy.get().setPremium(policy1.getPremium());
		policy.get().setStartDate(policy1.getStartDate());
		policy.get().setEndDate(policy1.getEndDate());
		//policy.setClient(policy1.getClient());
		policy.get().setClaims(policy1.getClaims());
		return insRepository.save(policy.get());
		}
		else {
			throw new InsurancePolicyNotFoundException(id);
		}
	}

	public String deleteInsurancePolicy(Long id) {
		
		Optional<InsurancePolicy> lpd =	insRepository.findById(id);
		
		if(lpd.isPresent()) {
			insRepository.deleteById(id);
			return "Successfully Deleted";
			}
			else
			{
				throw new InsurancePolicyNotFoundException(id);
			}
		

	}
	

}
