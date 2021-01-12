/**
 * 
 */
package com.fundtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fundtransfer.model.CustomerDetails;

/**
 * @author Prashu
 *
 */

	@Repository
	public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

		@Query(value="select  cd.* from Customer_details cd where cd.email=?1",nativeQuery = true)
		public CustomerDetails findbyUsercred(String email);
		
}
