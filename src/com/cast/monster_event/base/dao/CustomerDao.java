package com.cast.monster_event.base.dao;

import java.util.Collection;

import com.cast.monster_event.base.model.Customer;
import com.cast.monster_event.base.model.MonsterEvent;

/**
 * @author BGA
 * @created 30 juin 2010 Description :
 * 
 */

public class CustomerDao extends JPAResourceDao {
	// private JPAResourceDao dao;

	public CustomerDao() {
		super();
	}

	// Finds a Customer by its Id
	public Customer findById(long in_id) {
		return (Customer) getEm().createQuery(
				"select t From Customer t where customerId=?1").setParameter(1, in_id)
				.getSingleResult();
	}

	// Finds a Customer by its name
	public Customer findByName(String in_firstName, String in_lastName,
			String in_organization) {
		return (Customer) getEm()
				.createQuery(
						"From Customer where firstName=?1 and lastName=?2 and organization=?3 ")
				.setParameter(1, in_firstName).setParameter(2, in_lastName)
				.setParameter(3, in_organization).getSingleResult();
	}

	// Returns all the Customers
	public Collection<Customer> findAllCustomers() {
		return getEm().createQuery("From Customer").getResultList();
	}

	// returns alll events belonging to a Customer
	@SuppressWarnings("unchecked")
	public Collection<MonsterEvent> findEvents(Customer in_Customer) {
		Collection<MonsterEvent> l_eventList =
				getEm().createQuery(
						"From MonsterEvent where customer.customerId=?1")
						.setParameter(1, in_Customer.getCustomerId())
						.getResultList();
		return l_eventList;

	}

	// creates a Customer
	public Customer createCustomer(Customer in_Customer) {
		beginTransaction();
		getEm().persist(in_Customer);
		commitTransaction();
		return in_Customer;
	}

	
	/* public Customer createAccountNative(Customer in_Customer) {

		beginTransaction();
		getEm()
				.createNativeQuery(
						"INSERT INTO SPOOKED_CUSTOMER(first_name,last_name,organization,email,mobile,home_number,address,zip,city,state,country) values (?,?,?,?,?,?,?,?,?,?,?)")
				.setParameter(1, in_Customer.getFirstName()).setParameter(2,
						in_Customer.getLastName()).setParameter(3,
						in_Customer.getOrganization()).setParameter(4,
						in_Customer.getEmailAddress()).setParameter(5,
						in_Customer.getMobileNumber()).setParameter(6,
						in_Customer.getHomeNumber()).setParameter(7,
						in_Customer.getAddress()).setParameter(8,
						in_Customer.getZipCode()).setParameter(9,
						in_Customer.getCity()).setParameter(10,
						in_Customer.getState()).setParameter(11,
						in_Customer.getCountry()).executeUpdate();
		commitTransaction();

		return findByName(in_Customer.getFirstName(),
				in_Customer.getLastName(), in_Customer.getOrganization());
	} */

	public void updateCustomer(Customer in_Customer) {
		beginTransaction();
		getEm().persist(in_Customer);
		commitTransaction();
	}

	public void deleteCustomer(Customer in_Customer) {
		beginTransaction();
		getEm().remove(in_Customer);
		commitTransaction();

	}

}
