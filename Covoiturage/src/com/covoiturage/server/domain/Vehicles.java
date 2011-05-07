/*
 * 
 */
package com.covoiturage.server.domain;




import javax.persistence.Entity;




// TODO: Auto-generated Javadoc
/**
 * The Class Vehicles.
 */
@Entity
public class Vehicles extends DatastoreObject{
	




	/** The make. */
	private String make;
	
	/** The model. */
	private String model;
	
	/** The date. */
	private String date;
	
	/** The seats. */
	private int seats;
	
	/** The fuel mixed drive. */
	private float fuelMixedDrive;
	
	/** The emissions c o2. */
	private float emissionsCO2;

	

	/**
	 * Instantiates a new vehicles.
	 */
	public Vehicles() {

	}

	/**
	 * Instantiates a new vehicles.
	 *
	 * @param make the make
	 * @param models the models
	 * @param date the date
	 * @param seats the seats
	 */
	public Vehicles( String make, String models, String date,
			int seats) {

		this.make = make;
		this.model = models;
		this.date = date;
		this.seats = seats;

	}


	/**
	 * Gets the make.
	 *
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the make.
	 *
	 * @param make the new make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	

	/**
	 * Sets the fuel mixed drive.
	 *
	 * @param fuelMixedDrive the new fuel mixed drive
	 */
	public void setFuelMixedDrive(float fuelMixedDrive) {
		this.fuelMixedDrive = fuelMixedDrive;
	}

	/**
	 * Gets the fuel mixed drive.
	 *
	 * @return the fuel mixed drive
	 */
	public float getFuelMixedDrive() {
		return fuelMixedDrive;
	}

	/**
	 * Sets the emissions c o2.
	 *
	 * @param emissionsCO2 the new emissions c o2
	 */
	public void setEmissionsCO2(float emissionsCO2) {
		this.emissionsCO2 = emissionsCO2;
	}

	/**
	 * Gets the emissions c o2.
	 *
	 * @return the emissions c o2
	 */
	public float getEmissionsCO2() {
		return emissionsCO2;
	}
}
