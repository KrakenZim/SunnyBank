package com.data;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.data.model.Admin;

public class CustomAdminDetails implements UserDetails{

	private Admin admin;
	
	public CustomAdminDetails(Admin admin) {
		this.admin = admin;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		return admin.getPassword();
	}
	
	public int getId() {
		return admin.getId();
	}

	@Override
	public String getUsername() {
		return admin.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public String getFullName() {
		return admin.getName();
	}
}

