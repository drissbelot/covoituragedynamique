package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserInfoDetails.class)
public interface UserInfoDetailsProxy extends EntityProxy {
	@Override
	EntityProxyId<UserInfoDetailsProxy> stableId();

	public void setVehicle(String vehicle);

	public String getVehicle();

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

	public void setPersonalPicture(byte[] personalPicture);

	public byte[] getPersonalPicture();

	public void setVehiclePicture(byte[] vehiclePicture);

	public byte[] getVehiclePicture();

	public void setComfort(int comfort);

	public int getComfort();

	public void setMobilePhoneNumber(String mobilePhoneNumber);

	public String getMobilePhoneNumber();

	public void setHomePhoneNumber(String homePhoneNumber);

	public String getHomePhoneNumber();

	public void setWorkPhoneNumber(String workPhoneNumber);

	public String getWorkPhoneNumber();

}
