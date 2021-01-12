/**
 * 
 */
package com.fundtransfer.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorValue(value = "INT")
@Table(name = "INT_BRANCH_DETAILS")
public class InternationalBranchDetails extends BranchDetails {

	@Column(name = "CNTRY_CODE")
	private String countryCode;
	
	@Column(name = "CNTRY_NAME")
	private String countryName;
}
