package com.covoiturage.shared;



import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.requestfactory.shared.EntityProxy;

import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserInfoDetails.class)
public interface UserInfoDetailsProxy extends EntityProxy{
	
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
	
	public String getUser();
	public void setUser(String user);
	public String getId();

	
}
