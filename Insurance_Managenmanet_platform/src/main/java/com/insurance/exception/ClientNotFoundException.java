package com.insurance.exception;
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long clientId) {
        super("Client with ID " + clientId + " not found.");
    }
    
    public ClientNotFoundException() {
        super("There is no any Client Records...");
    }
    
    

	public ClientNotFoundException(Long cientId,Long policyId) {
        super("Policy with ID " + policyId + " not found.");
    }
}