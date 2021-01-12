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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private String orderid;

	@Column(name = "order_Name")
	private String orderName;

	@Column(name = "order_Date")
	private java.util.Date orderDate;

	@ManyToOne
	@JoinColumn(name = "Customer_id")
	private CustomerDetails customerDetails;

}
