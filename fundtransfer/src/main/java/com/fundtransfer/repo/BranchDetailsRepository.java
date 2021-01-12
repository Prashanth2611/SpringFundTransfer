/**
 * 
 */
package com.fundtransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.fundtransfer.model.BranchDetails;

/**
 * @author Prashu
 *
 */
@NoRepositoryBean
public interface BranchDetailsRepository<T extends BranchDetails> extends JpaRepository<T, Long> {

}




