package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.data.model.Account;



public interface AccountRepository extends JpaRepository<Account, Integer>{
}

