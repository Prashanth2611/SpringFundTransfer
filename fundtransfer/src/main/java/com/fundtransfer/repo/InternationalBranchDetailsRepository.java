/**
 * 
 */
package com.fundtransfer.repo;

import javax.transaction.Transactional;

import com.fundtransfer.model.InternationalBranchDetails;

/**
 * @author Prashu
 *
 */
@Transactional
public interface InternationalBranchDetailsRepository extends BranchDetailsRepository<InternationalBranchDetails> {

}