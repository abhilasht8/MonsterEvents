package com.cast.monster_event.base.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MONSTER")
public class Monster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="monster_id")
	private long monsterId=0;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nom_du_scene")
	private String nomDuScene;
	
	@Column(name="title")
	private String title;
	
	@Column(name="age")
	private int age;
	
	@Column(name="height")
	private double height;
	
	@Column(name="max_size")
	private int maxSize;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="scare_factor")
	private int scareFactor;
	
	@Column(name="cuddle_factor")
	private int cuddleFactor;
	
	@Column(name="danger_factor")
	private int dangerFactor;
	
	@Column(name="category")
	private String category;
	
	@Column(name="price_per_hour")
	private int pricePerHour;
	
	@Lob
	@Column(name="image")
	private Byte[] picture;
	
	@ManyToMany(mappedBy="bookedMonsters")
	@JoinTable(name = "MONSTER_BOOKING")
	//@JoinTable(name = "MONSTER_BOOKING") causes Caused by: java.sql.SQLException: Cannot insert the value NULL into column 'participatedEvents_command_id', table 'MONSTER_EVENT.dbo.MONSTER_BOOKING'; column does not allow nulls. INSERT fails.
	private Collection<MonsterEvent> participatedEvents;// = new ArrayList<MonsterEvent>();

	/**
	 * 
	 */
	public Monster() {
		
	}

	/**
	 * @param in_firstName
	 * @param in_lastName
	 * @param in_nomDuScene
	 * @param in_title
	 * @param in_age
	 * @param in_height
	 * @param in_maxSize
	 * @param in_weight
	 * @param in_scareFactor
	 * @param in_cuddleFactor
	 * @param in_dangerFactor
	 * @param in_category
	 * @param in_pricePerHour
	 * @param in_picture
	 */
	public Monster(String in_firstName, String in_lastName,
			String in_nomDuScene, String in_title, int in_age, double in_height,
			int in_maxSize, int in_weight, int in_scareFactor,
			int in_cuddleFactor, int in_dangerFactor, String in_category,
			int in_pricePerHour, Byte[] in_picture) {
		super();
		firstName = in_firstName;
		lastName = in_lastName;
		nomDuScene = in_nomDuScene;
		title = in_title;
		age = in_age;
		height = in_height;
		maxSize = in_maxSize;
		weight = in_weight;
		scareFactor = in_scareFactor;
		cuddleFactor = in_cuddleFactor;
		dangerFactor = in_dangerFactor;
		category = in_category;
		pricePerHour = in_pricePerHour;
		picture = in_picture;
	}

	/**
	 * @param in_firstName
	 * @param in_lastName
	 * @param in_nomDuScene
	 * @param in_title
	 * @param in_age
	 * @param in_height
	 * @param in_maxSize
	 * @param in_weight
	 * @param in_scareFactor
	 * @param in_cuddleFactor
	 * @param in_dangerFactor
	 * @param in_category
	 * @param in_pricePerHour
	 * @param in_picture
	 * @param in_participatedEvents
	 */
	public Monster(String in_firstName, String in_lastName,
			String in_nomDuScene, String in_title, int in_age, double in_height,
			int in_maxSize, int in_weight, int in_scareFactor,
			int in_cuddleFactor, int in_dangerFactor, String in_category,
			int in_pricePerHour, Byte[] in_picture,
			Set<MonsterEvent> in_participatedEvents) {
		super();
		firstName = in_firstName;
		lastName = in_lastName;
		nomDuScene = in_nomDuScene;
		title = in_title;
		age = in_age;
		height = in_height;
		maxSize = in_maxSize;
		weight = in_weight;
		scareFactor = in_scareFactor;
		cuddleFactor = in_cuddleFactor;
		dangerFactor = in_dangerFactor;
		category = in_category;
		pricePerHour = in_pricePerHour;
		picture = in_picture;
		participatedEvents = in_participatedEvents;
	}

	/**
	 * @return the monsterId
	 */
	public long getMonsterId() {
		return monsterId;
	}

	/**
	 * @param in_monsterId the monsterId to set
	 */
	public void setMonsterId(long in_monsterId) {
		monsterId = in_monsterId;
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
	 * @return the nomDuScene
	 */
	public String getNomDuScene() {
		return nomDuScene;
	}

	/**
	 * @param in_nomDuScene the nomDuScene to set
	 */
	public void setNomDuScene(String in_nomDuScene) {
		nomDuScene = in_nomDuScene;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param in_age the age to set
	 */
	public void setAge(int in_age) {
		age = in_age;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param in_height the height to set
	 */
	public void setHeight(double in_height) {
		height = in_height;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param in_maxSize the maxSize to set
	 */
	public void setMaxSize(int in_maxSize) {
		maxSize = in_maxSize;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param in_weight the weight to set
	 */
	public void setWeight(int in_weight) {
		weight = in_weight;
	}

	/**
	 * @return the scareFactor
	 */
	public int getScareFactor() {
		return scareFactor;
	}

	/**
	 * @param in_scareFactor the scareFactor to set
	 */
	public void setScareFactor(int in_scareFactor) {
		scareFactor = in_scareFactor;
	}

	/**
	 * @return the cuddleFactor
	 */
	public int getCuddleFactor() {
		return cuddleFactor;
	}

	/**
	 * @param in_cuddleFactor the cuddleFactor to set
	 */
	public void setCuddleFactor(int in_cuddleFactor) {
		cuddleFactor = in_cuddleFactor;
	}

	/**
	 * @return the dangerFactor
	 */
	public int getDangerFactor() {
		return dangerFactor;
	}

	/**
	 * @param in_dangerFactor the dangerFactor to set
	 */
	public void setDangerFactor(int in_dangerFactor) {
		dangerFactor = in_dangerFactor;
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

	/**
	 * @return the participatedEvents
	 */
	public Collection<MonsterEvent> getParticipatedEvents() {
		return participatedEvents;
	}

	/**
	 * @param in_participatedEvents the participatedEvents to set
	 */
	public void setParticipatedEvents(Collection<MonsterEvent> in_participatedEvents) {
		participatedEvents = in_participatedEvents;
	}

	public String getStringValue() {
		// TODO Auto-generated method stub
		return getFirstName()+" "+getLastName()+" "+getNomDuScene();
	}
	
	//private MonsterComments comments;
}
