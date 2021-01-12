/**
 * 
 */
package com.fundtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundtransfer.model.OrderDetailsTransactionID;
import com.fundtransfer.model.TransactionDetails;

/**
 * @author Prashu
 *
 */


	@Repository
	public interface TransactionRepository extends JpaRepository<TransactionDetails, OrderDetailsTransactionID> {

}
