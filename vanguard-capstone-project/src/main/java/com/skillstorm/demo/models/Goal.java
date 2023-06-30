package com.skillstorm.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Goal.
 */
@Entity
@Table(name = "goals")
public class Goal {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * The Sub
     * 
     * An identifier for the user, unique among all Google accounts and never reused. 
     * A Google account can have multiple email addresses at different points in time, 
     * but the sub value is never changed. Use sub within your application as the 
     * unique-identifier key for the user. Maximum length of 255 case-sensitive ASCII 
     * characters.
     * 
     * https://developers.google.com/identity/openid-connect/openid-connect
     */
    @Column(nullable = false)
    private String sub;
    
    /** The name. */
    @Column(nullable = false)
    private String name;

    /** The description. */
    @Column(nullable = false)
    private String description;

    /** The picture. */
    @Column(nullable = false)
    private String picture;

    /** The target date. */
    @Column(nullable = false)
    private LocalDate targetDate;

    /** The target amount. */
    @Column(nullable = false)
    private double targetAmount;

    /** The currently saved amount. */
    @Column(nullable = false)
    private double currentlySavedAmount;

    /**
     * Instantiates a new goal.
     */
    public Goal() {
    	
    }

	/**
	 * Instantiates a new goal.
	 *
	 * @param id the id
	 * @param sub the sub
	 * @param name the name
	 * @param description the description
	 * @param picture the picture
	 * @param targetDate the target date
	 * @param targetAmount the target amount
	 * @param currentlySavedAmount the currently saved amount
	 */
	public Goal(Long id, String sub, String name, String description, String picture, LocalDate targetDate,
			double targetAmount, double currentlySavedAmount) {
		super();
		this.id = id;
		this.sub = sub;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.targetDate = targetDate;
		this.targetAmount = targetAmount;
		this.currentlySavedAmount = currentlySavedAmount;
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the sub.
	 *
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * Sets the sub.
	 *
	 * @param sub the new sub
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the picture.
	 *
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * Sets the picture.
	 *
	 * @param picture the new picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * Gets the target date.
	 *
	 * @return the target date
	 */
	public LocalDate getTargetDate() {
		return targetDate;
	}

	/**
	 * Sets the target date.
	 *
	 * @param targetDate the new target date
	 */
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * Gets the target amount.
	 *
	 * @return the target amount
	 */
	public double getTargetAmount() {
		return targetAmount;
	}

	/**
	 * Sets the target amount.
	 *
	 * @param targetAmount the new target amount
	 */
	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	/**
	 * Gets the currently saved amount.
	 *
	 * @return the currently saved amount
	 */
	public double getCurrentlySavedAmount() {
		return currentlySavedAmount;
	}

	/**
	 * Sets the currently saved amount.
	 *
	 * @param currentlySavedAmount the new currently saved amount
	 */
	public void setCurrentlySavedAmount(double currentlySavedAmount) {
		this.currentlySavedAmount = currentlySavedAmount;
	}
    
	
}