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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
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

	public Goal(Long id, User user, String name, String description, String picture, LocalDate targetDate,
			double targetAmount, double currentlySavedAmount) {
		super();
		this.id = id;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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