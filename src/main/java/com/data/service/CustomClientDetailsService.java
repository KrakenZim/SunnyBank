package com.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.data.CustomClientDetails;
import com.data.model.Client;
import com.data.repository.ClientRepository;

public class CustomClientDetailsService implements UserDetailsService {
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepo.findByEmail(username);
		if (client == null) {
			throw new UsernameNotFoundException("Client not found");
		}
		return new CustomClientDetails(client);
	}
}

