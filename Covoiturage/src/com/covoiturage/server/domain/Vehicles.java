package com.covoiturage.server.domain;




import javax.persistence.Entity;




@Entity
public class Vehicles extends DatastoreObject{
	




	private String make;
	private String model;
	private String date;
	private int seats;
	private float fuelMixedDrive;
	private float emissionsCO2;

	

	public Vehicles() {

	}

	public Vehicles( String make, String models, String date,
			int seats) {

		this.make = make;
		this.model = models;
		this.date = date;
		this.seats = seats;

	}


	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	

	public void setFuelMixedDrive(float fuelMixedDrive) {
		this.fuelMixedDrive = fuelMixedDrive;
	}

	public float getFuelMixedDrive() {
		return fuelMixedDrive;
	}

	public void setEmissionsCO2(float emissionsCO2) {
		this.emissionsCO2 = emissionsCO2;
	}

	public float getEmissionsCO2() {
		return emissionsCO2;
	}
}
