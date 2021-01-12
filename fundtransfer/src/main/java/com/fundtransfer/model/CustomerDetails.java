/**
 * 
 */
package com.fundtransfer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Prashu
 *
 */


@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Customer_details")
public class CustomerDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Customer_id")
	private Long customerId;
	
	@Column(name = "First_Name")
	private String firstName;
	
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "country")
	private String  birthCountry;
	
	@Column(name = "Zip")
	private String  zip;
	
	@Column(name = "Phone_number")
	private String  phoneNumber;
	
	@Column(name = "email")
	private String  email;
	
	@Column(name = "Customer_PASSWORD")
	private String password;
	
	
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Account> account = new HashSet<>();

	
	 @OneToMany(mappedBy = "customerDetails")
	 private Set<Orders> orders = new HashSet<>();
	  
	 @OneToOne(mappedBy = "customerDetails")
	 private BranchDetails branchDetails;
	 
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}


	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the birthCountry
	 */
	public String getBirthCountry() {
		return birthCountry;
	}


	/**
	 * @param birthCountry the birthCountry to set
	 */
	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}


	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}


	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the account
	 */
	public Set<Account> getAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setAccount(Set<Account> account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", birthCountry=" + birthCountry + ", zip=" + zip + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
}
