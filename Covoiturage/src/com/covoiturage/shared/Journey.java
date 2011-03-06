package com.covoiturage.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

	
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
@SuppressWarnings("serial")
public class Journey implements Serializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long id;
	@Persistent
	public UserInfo driver;
	@Persistent
	public List<UserInfo> passengers;
	@Persistent
	public List<String> steps;
	@Persistent 
	public Date date;


	
	

	public Journey() {}

	public Journey(Long id, UserInfo driver, List<UserInfo> passengers, List<String> steps) {
		super();
		this.id = id;
		this.driver = driver;
		this.passengers = passengers;
		this.steps = steps;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserInfo getDriver() {
		return driver;
	}

	public void setDriver(UserInfo driver) {
		this.driver = driver;
	}

	public List<UserInfo> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<UserInfo> passengers) {
		this.passengers = passengers;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	
}

