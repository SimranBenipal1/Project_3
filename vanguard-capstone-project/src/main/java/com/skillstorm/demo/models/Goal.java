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

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
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
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private LocalDate targetDate;

    @Column(nullable = false)
    private double targetAmount;

    @Column(nullable = false)
    private double currentlySavedAmount;

    public Goal() {
    	
    }

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



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public double getCurrentlySavedAmount() {
		return currentlySavedAmount;
	}

	public void setCurrentlySavedAmount(double currentlySavedAmount) {
		this.currentlySavedAmount = currentlySavedAmount;
	}
    
	
}