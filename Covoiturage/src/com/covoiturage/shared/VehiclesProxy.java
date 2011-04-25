package com.covoiturage.shared;

import com.covoiturage.server.domain.Vehicles;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Vehicles.class)
public interface VehiclesProxy extends EntityProxy {
	@Override
	EntityProxyId<VehiclesProxy> stableId();

	public String getId();

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
