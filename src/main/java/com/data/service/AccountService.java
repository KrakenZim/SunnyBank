package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.data.model.Account;
import com.data.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
    private AccountRepository repo;

	public List<Account> listAll() {
		return repo.findAll();
	}
	public void save(Account account) {
		repo.save(account);
	}
	public Account get(int id) {
		return repo.findById(id).get();
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}