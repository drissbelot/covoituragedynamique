package com.covoiturage.shared;

import com.covoiturage.server.domain.Vehicles;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.gwt.requestfactory.shared.EntityProxy;

import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(value=Vehicles.class,locator=ObjectifyLocator.class)
public interface VehiclesProxy extends EntityProxy {

	public Long getId();

	public String getMake();

	public void setMake(String make);

	public String getModel();

	public void setModel(String model);

	public String getDate();

	public void setDate(String date);

	public int getSeats();

	public void setSeats(int seats);

	public void setFuelMixedDrive(float fuelMixedDrive);

	public float getFuelMixedDrive();

	public void setEmissionsCO2(float emissionsCO2);

	public float getEmissionsCO2();
}
