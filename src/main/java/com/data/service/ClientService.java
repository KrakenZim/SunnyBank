package com.data.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.model.Client;
import com.data.repository.ClientRepository;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public List<Client> listAll() {
		return repo.findAll();
	}
	public void save(Client client) {
		repo.save(client);
	}
	public Client get(int id) {
		return repo.findById(id).get();
	}
	
	public Client getByEmail(String email) {
		return repo.findByEmail(email);
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}

