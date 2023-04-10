package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.data.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
    public Client findByEmail(String email);
}
