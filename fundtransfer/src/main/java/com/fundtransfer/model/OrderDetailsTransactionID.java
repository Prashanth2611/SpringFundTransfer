package com.fundtransfer.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class OrderDetailsTransactionID implements Serializable{
	
	
	private String transactionId;
	

	private String orderID;
	
	
	public OrderDetailsTransactionID() {
		super();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsTransactionID other = (OrderDetailsTransactionID) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}


	/**
	 * @param transactionId
	 * @param orderID
	 */
	public OrderDetailsTransactionID(String transactionId, String orderID) {
		super();
		this.transactionId = transactionId;
		this.orderID = orderID;
	}


	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}


	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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


	
	
}
