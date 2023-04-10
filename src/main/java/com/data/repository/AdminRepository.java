package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.data.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    public Admin findByEmail(String email);
}

