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
@DiscriminatorValue(value = "LOC")
@Table(name = "LOC_BRANCH_DETAILS")
public class LocalBranchDetails extends BranchDetails {

	@Column(name = "District_code")
	private String districtCode;
	
}
