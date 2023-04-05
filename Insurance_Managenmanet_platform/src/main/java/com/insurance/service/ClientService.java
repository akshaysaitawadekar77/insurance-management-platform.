package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.ClientNotFoundException;
import com.insurance.pojo.Claim;
import com.insurance.pojo.Client;
import com.insurance.pojo.InsurancePolicy;
import com.insurance.repo.ClaimRepository;
import com.insurance.repo.ClientRepository;
import com.insurance.repo.InsurancePolicyRepository;
@Service
public class ClientService {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	
	public List<Client> getAllClients() {
		
		List<Client> cli= clientRepository.findAll();
		if(cli.isEmpty()) {
			throw new ClientNotFoundException();
		}
		else {
			return cli;
		}
	}

	public Client getClientById(Long id) {
		
		Optional<Client> clg= clientRepository.findById(id);
            if (clg.isEmpty()) {
            	throw new ClientNotFoundException(id);
            }
            else {
            	return clg.get();
            }
	}

	public String createClient(Client client) {
		
		if (client.getName()==null || client.getName()=="" ) {
			return "plase provide Name....";
		}
		else {
	 	 clientRepository.save(client);
	 	 return"new client added successfully with Id : "+client.getId();
		}
	}

	public Client updateClient(Long id, Client client1) {
		
		
		Optional<Client> client = clientRepository.findById(id);
		if(client.isPresent()) {
		client.get().setName(client1.getName());
        client.get().setDateOfBirth(client1.getDateOfBirth());
        client.get().setAddress(client1.getAddress());
        client.get().setContactInfo(client1.getContactInfo());
        client.get().setPolicies(client1.getPolicies());
         return clientRepository.save(client.get());
		}
		else {
			throw new ClientNotFoundException(id);
		}
	}

	public String deleteClient(Long id) {
	Optional<Client> cl =	clientRepository.findById(id);
	if(cl.isPresent()) {
	clientRepository.deleteById(id);
		return "Successfully Deleted";
	}
	else
	{
		throw new ClientNotFoundException(id);
	}

}
}
