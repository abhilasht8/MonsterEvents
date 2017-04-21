package com.cast.monster_event.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SPOOKY_PLACE")
public class SpookyPlace {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="place_id")
	private long placeId;
	
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="phone_number")
	private String phoneNumber;

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

	@Column(name="floor_area")
	private int floorArea;
	
	@Column(name="ceiling_height")
	private double ceilingHeight;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price_per_hour")
	private int pricePerHour;
	
	@Lob
	@Column(name="image")
	private Byte[] picture;

	public SpookyPlace() {
		
	}
	
	
	/**
	 * @param in_name
	 * @param in_description
	 * @param in_phoneNumber
	 * @param in_address
	 * @param in_zipCode
	 * @param in_city
	 * @param in_state
	 * @param in_country
	 * @param in_floorArea
	 * @param in_ceilingHeight
	 * @param in_category
	 * @param in_pricePerHour
	 * @param in_picture
	 */
	public SpookyPlace(String in_name, String in_description, String in_phoneNumber,
			String in_address, int in_zipCode, String in_city, String in_state,
			String in_country, int in_floorArea, Integer in_ceilingHeight,
			String in_category, int in_pricePerHour, Byte[] in_picture) {
		super();
		name= in_name;
		description = in_description;
		phoneNumber = in_phoneNumber;
		address = in_address;
		zipCode = in_zipCode;
		city = in_city;
		state = in_state;
		country = in_country;
		floorArea = in_floorArea;
		ceilingHeight = in_ceilingHeight;
		category = in_category;
		pricePerHour = in_pricePerHour;
		picture = in_picture;
	}

	/**
	 * @return the placeId
	 */
	public long getPlaceId() {
		return placeId;
	}

	/**
	 * @param in_placeId the placeId to set
	 */
	public void setPlaceId(long in_placeId) {
		placeId = in_placeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param in_name the name to set
	 */
	public void setName(String in_name) {
		name = in_name;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param in_phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String in_phoneNumber) {
		phoneNumber = in_phoneNumber;
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

	/**
	 * @return the floorArea
	 */
	public int getFloorArea() {
		return floorArea;
	}

	/**
	 * @param in_floorArea the floorArea to set
	 */
	public void setFloorArea(int in_floorArea) {
		floorArea = in_floorArea;
	}

	/**
	 * @return the ceilingHeight
	 */
	public double getCeilingHeight() {
		return ceilingHeight;
	}

	/**
	 * @param in_Height the ceilingHeight to set
	 */
	public void setCeilingHeight(double in_Height) {
		ceilingHeight = in_Height;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param in_category the category to set
	 */
	public void setCategory(String in_category) {
		category = in_category;
	}

	/**
	 * @return the pricePerHour
	 */
	public int getPricePerHour() {
		return pricePerHour;
	}

	/**
	 * @param in_pricePerHour the pricePerHour to set
	 */
	public void setPricePerHour(int in_pricePerHour) {
		pricePerHour = in_pricePerHour;
	}

	/**
	 * @return the picture
	 */
	public Byte[] getPicture() {
		return picture;
	}

	/**
	 * @param in_picture the picture to set
	 */
	public void setPicture(Byte[] in_picture) {
		picture = in_picture;
	}
	
	public String getStringValue() {
		return getName()+" "+getCity()+" "+getCategory();
	}
}
