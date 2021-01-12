/**
 * 
 */
package com.fundtransfer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
/**
 * @author Prashu
 *
 */
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance
@DiscriminatorColumn(name = "BranchType")
@Table(name = "BRANCH_DETAILS")
public class BranchDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Branch_CODE")
	private long branchCode;
	 
	@Column(name = "Branch_name")
	private String branchName;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_id")
	private CustomerDetails customerDetails;
	
}
