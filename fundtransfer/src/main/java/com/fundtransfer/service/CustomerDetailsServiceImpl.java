/**
 * 
 */
package com.fundtransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fundtransfer.dao.CustomerDao;
import com.fundtransfer.model.CustomerDetails;

@Service("userDetailsService")
public class CustomerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		CustomerDetails customerDetails = customerDao.fetchAllUserDetails(username);
		if (customerDetails == null) {
			throw new UsernameNotFoundException("Email" + username + "not found");
		}

		return new UserDetailsImpl(customerDetails);
	}

}
