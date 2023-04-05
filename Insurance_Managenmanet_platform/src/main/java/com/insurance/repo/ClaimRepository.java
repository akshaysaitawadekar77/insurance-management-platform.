package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.pojo.Claim;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}