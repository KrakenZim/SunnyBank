package com.data;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.data.model.Client;


public class CustomClientDetails implements UserDetails {
	private Client client;
	
	public CustomClientDetails(Client client) {
		this.client = client;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getPassword() {
		return client.getPassword();
	}
	
	public int getId() {
		return client.getId();
	}

	@Override
	public String getUsername() {
		return client.getEmail();
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
		return client.getName();
	}
}

