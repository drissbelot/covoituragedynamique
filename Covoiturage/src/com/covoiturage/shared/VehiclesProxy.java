/*
 * 
 */
package com.covoiturage.shared;

import com.covoiturage.server.domain.Vehicles;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehiclesProxy.
 */
@ProxyFor(value = Vehicles.class, locator = ObjectifyLocator.class)
public interface VehiclesProxy extends EntityProxy {

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId();

	/**
	 * Gets the make.
	 *
	 * @return the make
	 */
	public String getMake();

	/**
	 * Sets the make.
	 *
	 * @param make the new make
	 */
	public void setMake(String make);

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel();

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model);

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate();

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date);

	/**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
	public int getSeats();

	/**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
	public void setSeats(int seats);

	/**
	 * Sets the fuel mixed drive.
	 *
	 * @param fuelMixedDrive the new fuel mixed drive
	 */
	public void setFuelMixedDrive(float fuelMixedDrive);

	/**
	 * Gets the fuel mixed drive.
	 *
	 * @return the fuel mixed drive
	 */
	public float getFuelMixedDrive();

	/**
	 * Sets the emissions c o2.
	 *
	 * @param emissionsCO2 the new emissions c o2
	 */
	public void setEmissionsCO2(float emissionsCO2);

	/**
	 * Gets the emissions c o2.
	 *
	 * @return the emissions c o2
	 */
	public float getEmissionsCO2();
}
