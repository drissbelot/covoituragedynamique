package com.covoiturage.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

	
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;




@PersistenceCapable
public class SimpleTravel implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public Long id;
	@Persistent
	private List<String> steps;
	@Persistent
	private Date date;
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getSteps() {
		return steps;
	}

	@Persistent
	public String passenger;

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public SimpleTravel() {}

	public SimpleTravel(Long id, String passenger, List<String> steps) {

		this.id = id;
		this.passenger=passenger;
		this.steps = steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
		
	}}
