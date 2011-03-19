package com.covoiturage.shared;



import com.covoiturage.server.domain.DriverInfo;
import com.google.gwt.requestfactory.shared.EntityProxy;

import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(DriverInfo.class)
public interface DriverInfoProxy extends EntityProxy, UserInfoProxy{
	
	public void setMakeOfvehicle(String makeOfvehicle);
	public String getMakeOfvehicle();
	public void setModelOfvehicle(String modelOfvehicle);
	public String getModelOfvehicle();
	public void setCountOfPlaces(String countOfPlaces);
	public String getCountOfPlaces();
	public void setRating(int rating);
	public int getRating();
	public void setCountOfJourneys(int countOfJourneys);
	public int getCountOfJourneys();
	public void setFirstName(String firstName);

	public String getFirstName();

	public void setLastName(String lastName);

	public String getLastName();

	
}
