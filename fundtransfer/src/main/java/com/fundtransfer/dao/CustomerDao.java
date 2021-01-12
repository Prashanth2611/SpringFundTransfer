/**
 * 
 */
package com.fundtransfer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundtransfer.model.CustomerDetails;
import com.fundtransfer.model.TransactionDetails;
import com.fundtransfer.repo.CustomerRepository;
import com.fundtransfer.repo.TransactionRepository;

/**
 * @author Prashu
 *
 */
@Service
public class CustomerDao {

	/*
	 * @Autowired AccountRepository accRepo;
	 */

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	TransactionRepository txnRepo;

	TransactionDetails txndetails = new TransactionDetails();
	
	/**
	 * @param username
	 * @return
	 */
	public CustomerDetails fetchAllUserDetails(String username) {
		CustomerDetails customerDetails= custRepo.findbyUsercred(username);
		return customerDetails;
	}
	
	

}
