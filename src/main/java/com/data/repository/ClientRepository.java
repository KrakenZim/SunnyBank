package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.data.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query("SELECT c FROM Client c WHERE c.email = ?1")
    public Client findByEmail(String email);
}
