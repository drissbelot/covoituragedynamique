/*
 * 
 */
package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.UserInfoDetails;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInfoDetailsProxy.
 */
@ProxyFor(value = UserInfoDetails.class, locator = ObjectifyLocator.class)
public interface UserInfoDetailsProxy extends EntityProxy {

	/**
	 * Sets the vehicle.
	 * 
	 * @param vehicle
	 *            the new vehicle
	 */
	public void setVehicle(String vehicle);

	/**
	 * Gets the vehicle.
	 * 
	 * @return the vehicle
	 */
	public String getVehicle();

	/**
	 * Sets the count of places.
	 * 
	 * @param countOfPlaces
	 *            the new count of places
	 */
	public void setCountOfPlaces(Integer countOfPlaces);

	/**
	 * Gets the count of places.
	 * 
	 * @return the count of places
	 */
	public Integer getCountOfPlaces();

	/**
	 * Sets the rating.
	 * 
	 * @param rating
	 *            the new rating
	 */
	public void setRating(Integer rating);

	/**
	 * Gets the rating.
	 * 
	 * @return the rating
	 */
	public Integer getRating();

	/**
	 * Sets the count of journeys.
	 * 
	 * @param countOfJourneys
	 *            the new count of journeys
	 */
	public void setCountOfJourneys(Integer countOfJourneys);

	/**
	 * Gets the count of journeys.
	 * 
	 * @return the count of journeys
	 */
	public Integer getCountOfJourneys();

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName);

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName();

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName);

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName();

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public Long getUser();

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(Long user);

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId();

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage();

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language);

	/**
	 * Gets the channel id.
	 * 
	 * @return the channel id
	 */
	public String getChannelId();

	/**
	 * Sets the channel id.
	 * 
	 * @param Id
	 *            the new channel id
	 */
	public void setChannelId(String Id);

	/**
	 * Sets the messages.
	 * 
	 * @param messages
	 *            the new messages
	 */
	public void setMessages(List<Long> messages);

	/**
	 * Gets the messages.
	 * 
	 * @return the messages
	 */
	public List<Long> getMessages();

	/**
	 * Sets the color of vehicle.
	 * 
	 * @param colorOfVehicle
	 *            the new color of vehicle
	 */
	public void setColorOfVehicle(String colorOfVehicle);

	/**
	 * Gets the color of vehicle.
	 * 
	 * @return the color of vehicle
	 */
	public String getColorOfVehicle();

	/**
	 * Sets the personal picture.
	 * 
	 * @param personalPicture
	 *            the new personal picture
	 */
	public void setPersonalPicture(byte[] personalPicture);

	/**
	 * Gets the personal picture.
	 * 
	 * @return the personal picture
	 */
	public byte[] getPersonalPicture();

	/**
	 * Sets the vehicle picture.
	 * 
	 * @param vehiclePicture
	 *            the new vehicle picture
	 */
	public void setVehiclePicture(byte[] vehiclePicture);

	/**
	 * Gets the vehicle picture.
	 * 
	 * @return the vehicle picture
	 */
	public byte[] getVehiclePicture();

	/**
	 * Sets the comfort.
	 * 
	 * @param comfort
	 *            the new comfort
	 */
	public void setComfort(Integer comfort);

	/**
	 * Gets the comfort.
	 * 
	 * @return the comfort
	 */
	public Integer getComfort();

	/**
	 * Sets the mobile phone number.
	 * 
	 * @param mobilePhoneNumber
	 *            the new mobile phone number
	 */
	public void setMobilePhoneNumber(String mobilePhoneNumber);

	/**
	 * Gets the mobile phone number.
	 * 
	 * @return the mobile phone number
	 */
	public String getMobilePhoneNumber();

	/**
	 * Sets the home phone number.
	 * 
	 * @param homePhoneNumber
	 *            the new home phone number
	 */
	public void setHomePhoneNumber(String homePhoneNumber);

	/**
	 * Gets the home phone number.
	 * 
	 * @return the home phone number
	 */
	public String getHomePhoneNumber();

	/**
	 * Sets the work phone number.
	 * 
	 * @param workPhoneNumber
	 *            the new work phone number
	 */
	public void setWorkPhoneNumber(String workPhoneNumber);

	/**
	 * Gets the work phone number.
	 * 
	 * @return the work phone number
	 */
	public String getWorkPhoneNumber();

	public void setPersonalPictureType(String personalPictureType);

	public String getPersonalPictureType();

}
