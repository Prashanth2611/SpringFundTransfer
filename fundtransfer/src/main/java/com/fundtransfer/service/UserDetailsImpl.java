package com.fundtransfer.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fundtransfer.model.CustomerDetails;


public class UserDetailsImpl implements UserDetails {

	@Autowired
	private CustomerDetails customerDetails;
	 
	
	
	public UserDetailsImpl(CustomerDetails customerDetails) {
		super();
		this.customerDetails = customerDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//ROLE TO FOCUSED AUTORITY GIVEN TO ROLE AS USER
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customerDetails.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customerDetails.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
