/**
 * 
 */
package com.fundtransfer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Prashu
 *
 */

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_details")
public class Account implements Serializable {

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", createDate=" + createDate + ", customerDetails=" + customerDetails + ", transactionDetails="
				+ transactionDetails + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	@NotNull
	private Long accountId;

	@Column(name = "type")
	private String accountType;

	@Column(name = "balance")
	private Integer balance;

	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date createDate;

	@ManyToOne
	@JoinColumn(name = "Customer_id")
	private CustomerDetails customerDetails;

	@OneToMany(mappedBy = "account")
	private Set<TransactionDetails> transactionDetails = new HashSet<>();

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	/**
	 * @return the createDate
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the customerDetails
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	/**
	 * @return the transactionDetails
	 */
	public Set<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	/**
	 * @param transactionDetails the transactionDetails to set
	 */
	public void setTransactionDetails(Set<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
