package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.appengine.api.datastore.Blob;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserInfoDetails.class)
public interface UserInfoDetailsProxy extends EntityProxy {

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

	public String getLanguage();

	public void setLanguage(String language);

	public String getChannelId();

	public void setChannelId(String Id);

	public void setMessages(List<String> messages);

	public List<String> getMessages();

	public void setColorOfVehicle(String colorOfVehicle);

	public String getColorOfVehicle();

	public void setPersonalPicture(Blob personalPicture);

	public Blob getPersonalPicture();

	public void setVehiclePicture(Blob vehiclePicture);

	public Blob getVehiclePicture();

	public void setComfort(int comfort);

	public int getComfort();

	public void setMobilePhoneNumber(String mobilePhoneNumber);

	public String getMobilePhoneNumber();

	public void setHomePhoneNumber(String homePhoneNumber);

	public String getHomePhoneNumber();

	public void setWorkPhoneNumber(String workPhoneNumber);

	public String getWorkPhoneNumber();

}
