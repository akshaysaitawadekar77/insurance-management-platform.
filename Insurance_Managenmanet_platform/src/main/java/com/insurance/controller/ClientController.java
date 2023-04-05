package com.insurance.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.pojo.Client;

import com.insurance.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

   @Autowired
   private ClientService clientService;
   

   

   @GetMapping
   public List<Client> getAllClients() {
       return clientService.getAllClients();
   }

   @GetMapping("/{id}")
   public Client getClientById(@PathVariable long id){
	
       return clientService.getClientById(id);
   }

   @PostMapping
   public String createClient(@RequestBody Client client) {
       return clientService.createClient(client);
   }

   @PutMapping("/{id}")
   public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
       return clientService.updateClient(id, client);
   }

   @DeleteMapping("/{id}")
   public String deleteClient(@PathVariable Long id) {
       return clientService.deleteClient(id);
   }
}