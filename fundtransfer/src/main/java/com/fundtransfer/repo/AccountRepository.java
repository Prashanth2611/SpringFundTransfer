/**
 * 
 */
package com.fundtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundtransfer.model.Account;
/**
 * @author Prashu
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
