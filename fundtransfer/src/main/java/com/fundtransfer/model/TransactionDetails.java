/**
 * 
 */
package com.fundtransfer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

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
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "Transaction_details")
@IdClass(OrderDetailsTransactionID.class)
public class TransactionDetails implements Serializable {

	@Id
	@Column(name = "Tx_id")
	private String transactionId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	@NotNull
	private String orderID;

	@Column(name = "To_Tx_Account_id")
	private String toAccountId;

	@Column(name = "Tx_Type")
	@Transient
	private String transactionType;

	@Column(name = "Tx_status")
	private String transactionStatus;

	@Column(name = "Transfered_amount")
	private String transAmount;

	@Column(name = "Tx_Date")
	@Temporal(TemporalType.DATE)
	private java.util.Date transDate;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * @return the transAmount
	 */
	public String getTransAmount() {
		return transAmount;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transAmount the transAmount to set
	 */
	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the toAccountId
	 */
	public String getToAccountId() {
		return toAccountId;
	}

	/**
	 * @param toAccountId the toAccountId to set
	 */
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @return the transDate
	 */
	public java.util.Date getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate the transDate to set
	 */
	public void setTransDate(java.util.Date transDate) {
		this.transDate = transDate;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public void setTransactionId(String string) {
		// TODO Auto-generated method stub

	}

}
