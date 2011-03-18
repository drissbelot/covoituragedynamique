package com.covoiturage.server.domain;

import javax.persistence.Entity;



@Entity
public class DriverInfo extends UserInfo{

	public DriverInfo(String typeOfVehicule, String countOfPlaces, int rating,
			int countOfJourneys) {
		super();
		this.typeOfVehicule = typeOfVehicule;
		this.countOfPlaces = countOfPlaces;
		this.rating = rating;
		this.countOfJourneys = countOfJourneys;
	}
	private String typeOfVehicule;
	private String countOfPlaces;
	private int rating;
	private int countOfJourneys;
	public void setTypeOfVehicule(String typeOfVehicule) {
		this.typeOfVehicule = typeOfVehicule;
	}
	public String getTypeOfVehicule() {
		return typeOfVehicule;
	}
	public void setCountOfPlaces(String countOfPlaces) {
		this.countOfPlaces = countOfPlaces;
	}
	public String getCountOfPlaces() {
		return countOfPlaces;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setCountOfJourneys(int countOfJourneys) {
		this.countOfJourneys = countOfJourneys;
	}
	public int getCountOfJourneys() {
		return countOfJourneys;
	}
	
	
	

}
