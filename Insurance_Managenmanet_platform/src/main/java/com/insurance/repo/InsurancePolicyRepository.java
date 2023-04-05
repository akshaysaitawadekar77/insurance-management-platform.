package com.insurance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.pojo.Client;
import com.insurance.pojo.InsurancePolicy;
@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
	
}