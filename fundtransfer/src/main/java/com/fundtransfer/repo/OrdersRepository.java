
package com.fundtransfer.repo;
  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fundtransfer.model.Orders;
  
 /**
	 * @author Prashu
	 *
	 */
		  
@Repository 
public interface OrdersRepository extends JpaRepository<Orders, Long> {
		  
		  }
		 