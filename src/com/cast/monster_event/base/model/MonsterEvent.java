package com.cast.monster_event.base.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "SPOOKY_EVENT")
public class MonsterEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "command_id")
	private long eventId = 0;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	// @ManyToMany(mappedBy = "participatedEvents")
	@ManyToMany
	@JoinTable(name = "MONSTER_BOOKING", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "monster_id"))
	private Collection<Monster> bookedMonsters = new ArrayList<Monster>();

	@ManyToOne
	@JoinColumn(name = "place_id")
	private SpookyPlace location;

	@Column(name = "planned_start")
	private Date plannedStart;

	@Column(name = "planned_end")
	private Date plannedEnd;

	@Column(name = "participants")
	private int nrOfParticipants;

	@Column(name = "status")
	private EventStatus status;

	@Column(name = "actual_start")
	private Date actualStart;

	@Column(name = "actual_end")
	private Date actualEnd;

	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(name = "EVENT_OPTIONS", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
	private Collection<SpookyOption> options;

	public MonsterEvent() {		
	}
	
	/**
	 * @param in_customer
	 * @param in_bookedMonsters
	 * @param in_location
	 * @param in_plannedStart
	 * @param in_plannedEnd
	 * @param in_nrOfParticipants
	 * @param in_status
	 * @param in_actualStart
	 * @param in_actualEnd
	 * @param in_options
	 */
	public MonsterEvent(Customer in_customer,
			Collection<Monster> in_bookedMonsters, SpookyPlace in_location,
			Date in_plannedStart, Date in_plannedEnd, int in_nrOfParticipants,
			EventStatus in_status, Date in_actualStart, Date in_actualEnd,
			Collection<SpookyOption> in_options) {
		super();
		customer = in_customer;
		bookedMonsters = in_bookedMonsters;
		location = in_location;
		plannedStart = in_plannedStart;
		plannedEnd = in_plannedEnd;
		nrOfParticipants = in_nrOfParticipants;
		status = in_status;
		actualStart = in_actualStart;
		actualEnd = in_actualEnd;
		options = in_options;
	}

	/**
	 * @return the commandId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * @param in_commandId
	 *            the commandId to set
	 */
	public void setEventId(long in_commandId) {
		eventId = in_commandId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param in_customer
	 *            the customer to set
	 */
	public void setCustomer(Customer in_customer) {
		customer = in_customer;
	}

	/**
	 * @return the bookedMonsters
	 */
	public Collection<Monster> getBookedMonsters() {
		return bookedMonsters;
	}

	/**
	 * @param in_bookedMonsters
	 *            the bookedMonsters to set
	 */
	public void setBookedMonsters(Collection<Monster> in_bookedMonsters) {
		bookedMonsters = in_bookedMonsters;
	}

	/**
	 * @return the location
	 */
	public SpookyPlace getLocation() {
		return location;
	}

	/**
	 * @param in_location
	 *            the location to set
	 */
	public void setLocation(SpookyPlace in_location) {
		location = in_location;
	}

	/**
	 * @return the plannedStart
	 */
	public Date getPlannedStart() {
		return plannedStart;
	}

	/**
	 * @param in_plannedStart
	 *            the plannedStart to set
	 */
	public void setPlannedStart(Date in_plannedStart) {
		plannedStart = in_plannedStart;
	}

	/**
	 * @return the plannedEnd
	 */
	public Date getPlannedEnd() {
		return plannedEnd;
	}

	/**
	 * @param in_plannedEnd
	 *            the plannedEnd to set
	 */
	public void setPlannedEnd(Date in_plannedEnd) {
		plannedEnd = in_plannedEnd;
	}

	/**
	 * @return the nrOfParticipants
	 */
	public int getNrOfParticipants() {
		return nrOfParticipants;
	}

	/**
	 * @param in_nrOfParticipants
	 *            the nrOfParticipants to set
	 */
	public void setNrOfParticipants(int in_nrOfParticipants) {
		nrOfParticipants = in_nrOfParticipants;
	}

	/**
	 * @return the status
	 */
	public EventStatus getStatus() {
		return status;
	}

	/**
	 * @param in_status
	 *            the status to set
	 */
	public void setStatus(EventStatus in_status) {
		status = in_status;
	}

	/**
	 * @return the actualStart
	 */
	public Date getActualStart() {
		return actualStart;
	}

	/**
	 * @param in_actualStart
	 *            the actualStart to set
	 */
	public void setActualStart(Date in_actualStart) {
		actualStart = in_actualStart;
	}

	/**
	 * @return the actualEnd
	 */
	public Date getActualEnd() {
		return actualEnd;
	}

	/**
	 * @param in_actualEnd
	 *            the actualEnd to set
	 */
	public void setActualEnd(Date in_actualEnd) {
		actualEnd = in_actualEnd;
	}

	/**
	 * @return the options
	 */
	public Collection<SpookyOption> getOptions() {
		return options;
	}

	/**
	 * @param in_options
	 *            the options to set
	 */
	public void setOptions(Collection<SpookyOption> in_options) {
		options = in_options;
	}

	public void addOption(SpookyOption in_newOption) {
		this.getOptions().add(in_newOption);
		
	}

	public void addMonster(Monster in_newMonster) {
		this.getBookedMonsters().add(in_newMonster);
		
	}

	public String getStringValue() {
		// TODO Auto-generated method stub
		return getCustomer().getStringValue() + " at " + getLocation().getStringValue() +" on the date "+getPlannedStart().toString();
	}
	

}
