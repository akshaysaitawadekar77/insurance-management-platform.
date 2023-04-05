package com.insurance.exception;
public class InsurancePolicyNotFoundException extends RuntimeException {
   
	
	public InsurancePolicyNotFoundException(Long policyId) {
        super("Policy with PolicyId : " +policyId+ " not found.");
    }
    public InsurancePolicyNotFoundException(String message) {
        super(message);
    }
    
}