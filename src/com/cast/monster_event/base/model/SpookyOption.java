package com.cast.monster_event.base.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SPOOKY_OPTIONS")
public class SpookyOption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="option_id")
	private long optionId=0;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="description")
	private String description;
	
	private int price;
	
	@ManyToMany(mappedBy="options")
	@JoinTable(name = "EVENT_OPTIONS")
	private Collection<MonsterEvent> usedAtEvents;

	public SpookyOption() {
		
	}
	
	/**
	 * @param in_title
	 * @param in_description
	 */
	public SpookyOption(String in_title, String in_description) {
		super();
		title = in_title;
		description = in_description;
		price=50;
	}

	/**
	 * @param in_title
	 * @param in_description
	 * @param in_price
	 */
	public SpookyOption(String in_title, String in_description, int in_price) {
		super();
		title = in_title;
		description = in_description;
		price = in_price;
	}

	/**
	 * @return the optionId
	 */
	public long getOptionId() {
		return optionId;
	}

	/**
	 * @param in_optionId the optionId to set
	 */
	public void setOptionId(long in_optionId) {
		optionId = in_optionId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param in_title the title to set
	 */
	public void setTitle(String in_title) {
		title = in_title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param in_description the description to set
	 */
	public void setDescription(String in_description) {
		description = in_description;
	}

	/**
	 * @return the usedAtEvents
	 */
	public Collection<MonsterEvent> getUsedAtEvents() {
		return usedAtEvents;
	}

	/**
	 * @param in_usedAtEvents the usedAtEvents to set
	 */
	public void setUsedAtEvents(Collection<MonsterEvent> in_usedAtEvents) {
		usedAtEvents = in_usedAtEvents;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param in_price the price to set
	 */
	public void setPrice(int in_price) {
		price = in_price;
	}
	
	public String getStringValue() {
		// TODO Auto-generated method stub
		return getTitle();
	}

}
