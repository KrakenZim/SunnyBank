package com.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.data.CustomAdminDetails;
import com.data.model.Admin;
import com.data.repository.AdminRepository;

public class CustomAdminDetailsService implements UserDetailsService{

		@Autowired
		private AdminRepository adminRepo;
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			Admin admin = adminRepo.findByEmail(email);
			if (admin == null) {
				throw new UsernameNotFoundException("Admin is not found");
			}
			return new CustomAdminDetails(admin);
		}
	}

