package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.insurance.pojo.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	
	
}