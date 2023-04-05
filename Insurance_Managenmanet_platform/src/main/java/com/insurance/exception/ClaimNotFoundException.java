package com.insurance.exception;
public class ClaimNotFoundException extends RuntimeException {
    public ClaimNotFoundException(String message) {
        super(message);
    }
    public ClaimNotFoundException(Long id) {
        super("Could not find claim on this Id : " + id);
    }
}