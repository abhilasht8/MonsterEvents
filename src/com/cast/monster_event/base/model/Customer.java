package com.cast.monster_event.base.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.hql.ast.tree.IsNullLogicOperatorNode;

@Entity
@Table(name="SPOOKED_CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private long customerId = 0;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
    private String lastName;
    
	@Column(name="organization")
    private String organization;
    
	@Column(name="email")
    private String emailAddress;
    
	@Column(name="mobile")
    private String mobileNumber;
    
	@Column(name="home_number")
    private String homeNumber;
    
	@Column(name="address")
    private String address;
    
	@Column(name="zip")
    private int zipCode;
    
	@Column(name="city")
    private String city;
    
	@Column(name="state")
    private String state;
    
	@Column(name="country")
    private String country;
	
	/*
	 
	private Collection<MonsterEvent> orderedEvents;
*/

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param in_firstName
	 * @param in_lastName
	 * @param in_organization
	 * @param in_emailAddress
	 * @param in_mobileNumber
	 * @param in_homeNumber
	 * @param in_address
	 * @param in_zipCode
	 * @param in_city
	 * @param in_state
	 * @param in_country
	 */
	public Customer(String in_firstName, String in_lastName,
			String in_organization, String in_emailAddress,
			String in_mobileNumber, String in_homeNumber, String in_address,
			int in_zipCode, String in_city, String in_state, String in_country) {
		super();
		firstName = in_firstName;
		lastName = in_lastName;
		organization = in_organization;
		emailAddress = in_emailAddress;
		mobileNumber = in_mobileNumber;
		homeNumber = in_homeNumber;
		address = in_address;
		zipCode = in_zipCode;
		city = in_city;
		state = in_state;
		country = in_country;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param in_customerId the customerId to set
	 */
	public void setCustomerId(long in_customerId) {
		customerId = in_customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param in_firstName the firstName to set
	 */
	public void setFirstName(String in_firstName) {
		firstName = in_firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param in_lastName the lastName to set
	 */
	public void setLastName(String in_lastName) {
		lastName = in_lastName;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param in_organization the organization to set
	 */
	public void setOrganization(String in_organization) {
		organization = in_organization;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param in_emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String in_emailAddress) {
		emailAddress = in_emailAddress;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param in_mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String in_mobileNumber) {
		mobileNumber = in_mobileNumber;
	}

	/**
	 * @return the homeNumber
	 */
	public String getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param in_homeNumber the homeNumber to set
	 */
	public void setHomeNumber(String in_homeNumber) {
		homeNumber = in_homeNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param in_address the address to set
	 */
	public void setAddress(String in_address) {
		address = in_address;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param in_zipCode the zipCode to set
	 */
	public void setZipCode(int in_zipCode) {
		zipCode = in_zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param in_city the city to set
	 */
	public void setCity(String in_city) {
		city = in_city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param in_state the state to set
	 */
	public void setState(String in_state) {
		state = in_state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param in_country the country to set
	 */
	public void setCountry(String in_country) {
		country = in_country;
	}
	
	public String getStringValue() {
			return getFirstName()+" "+getLastName()+" "+getOrganization(); 
	}
}
