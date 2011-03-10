package com.covoiturage.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

	
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Extension;

@PersistenceCapable
@SuppressWarnings("serial")
public class Journey implements Serializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	public String id;
	@Persistent
	public String driver;
	@Persistent
	public List<String> passengers;
	@Persistent
	public List<String> steps;
	@Persistent 
	public Date date;


	
	

	public Journey() {}

	public Journey(String id, String driver, List<String> passengers, List<String> steps) {
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

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public List<String> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<String> passengers) {
		this.passengers = passengers;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	
}

