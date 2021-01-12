/**
 * 
 */
package com.fundtransfer.repo;

import javax.transaction.Transactional;

import com.fundtransfer.model.LocalBranchDetails;

/**
 * @author Prashu
 *
 */
@Transactional
public interface LocalBranchDetailsRepository extends BranchDetailsRepository<LocalBranchDetails> {

}
