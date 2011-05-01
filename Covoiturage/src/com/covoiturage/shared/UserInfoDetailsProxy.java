package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.UserInfoDetails;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(value = UserInfoDetails.class, locator = ObjectifyLocator.class)
public interface UserInfoDetailsProxy extends EntityProxy {

	public void setVehicle(String vehicle);

	public String getVehicle();

	public void setCountOfPlaces(String countOfPlaces);

	public String getCountOfPlaces();

	public void setRating(Integer rating);

	public Integer getRating();

	public void setCountOfJourneys(Integer countOfJourneys);

	public Integer getCountOfJourneys();

	public void setFirstName(String firstName);

	public String getFirstName();

	public void setLastName(String lastName);

	public String getLastName();

	public Long getUser();

	public void setUser(Long user);

	public Long getId();

	public String getLanguage();

	public void setLanguage(String language);

	public String getChannelId();

	public void setChannelId(String Id);

	public void setMessages(List<Long> messages);

	public List<Long> getMessages();

	public void setColorOfVehicle(String colorOfVehicle);

	public String getColorOfVehicle();

	public void setPersonalPicture(byte[] personalPicture);

	public byte[] getPersonalPicture();

	public void setVehiclePicture(byte[] vehiclePicture);

	public byte[] getVehiclePicture();

	public void setComfort(Integer comfort);

	public Integer getComfort();

	public void setMobilePhoneNumber(String mobilePhoneNumber);

	public String getMobilePhoneNumber();

	public void setHomePhoneNumber(String homePhoneNumber);

	public String getHomePhoneNumber();

	public void setWorkPhoneNumber(String workPhoneNumber);

	public String getWorkPhoneNumber();

}
