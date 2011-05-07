/*
 * 
 */
package com.covoiturage.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.google.appengine.api.datastore.Blob;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInfoDetails.
 */
@Entity
public class UserInfoDetails extends DatastoreObject {

	/** The channel id. */
	public String channelId;

	/** The count of journeys. */
	private Integer countOfJourneys;

	/** The count of places. */
	private Integer countOfPlaces = 4;

	/** The first name. */
	private String firstName;

	/** The language. */
	private String language;

	/** The last name. */
	private String lastName;

	/** The vehicle. */
	private String vehicle;

	/** The messages. */
	private List<Long> messages = new ArrayList<Long>();

	/** The rating. */
	private Integer rating;

	/** The user. */
	private Long user;

	/** The color of vehicle. */
	private String colorOfVehicle;

	/** The personal picture. */
	private Blob personalPicture;

	/** The vehicle picture. */
	private Blob vehiclePicture;

	/** The comfort. */
	private Integer comfort;

	/** The mobile phone number. */
	private String mobilePhoneNumber;

	/** The home phone number. */
	private String homePhoneNumber;

	/** The work phone number. */
	private String workPhoneNumber;

	/**
	 * Instantiates a new user info details.
	 */
	public UserInfoDetails() {

	}

	/**
	 * Instantiates a new user info details.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public UserInfoDetails(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Adds the message.
	 *
	 * @param message the message
	 */
	public void addMessage(Long message) {

		messages.add(message);
	}

	/**
	 * Gets the channel id.
	 *
	 * @return the channel id
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * Gets the count of journeys.
	 *
	 * @return the count of journeys
	 */
	public Integer getCountOfJourneys() {
		return countOfJourneys;
	}

	/**
	 * Gets the count of places.
	 *
	 * @return the count of places
	 */
	public Integer getCountOfPlaces() {
		return countOfPlaces;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<Long> getMessages() {
		return messages;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Long getUser() {
		return user;
	}

	/**
	 * Removes the message.
	 *
	 * @param message the message
	 */
	public void removeMessage(Long message) {
		messages.remove(message);
	}

	/**
	 * Sets the channel id.
	 *
	 * @param channelId the new channel id
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * Sets the count of journeys.
	 *
	 * @param countOfJourneys the new count of journeys
	 */
	public void setCountOfJourneys(Integer countOfJourneys) {
		this.countOfJourneys = countOfJourneys;
	}

	/**
	 * Sets the count of places.
	 *
	 * @param countOfPlaces the new count of places
	 */
	public void setCountOfPlaces(Integer countOfPlaces) {
		this.countOfPlaces = countOfPlaces;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<Long> messages) {
		this.messages = messages;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Long user) {
		this.user = user;
	}

	/**
	 * Sets the color of vehicle.
	 *
	 * @param colorOfVehicle the new color of vehicle
	 */
	public void setColorOfVehicle(String colorOfVehicle) {
		this.colorOfVehicle = colorOfVehicle;
	}

	/**
	 * Gets the color of vehicle.
	 *
	 * @return the color of vehicle
	 */
	public String getColorOfVehicle() {
		return colorOfVehicle;
	}

	/**
	 * Sets the personal picture.
	 *
	 * @param personalPicture the new personal picture
	 */
	public void setPersonalPicture(byte[] personalPicture) {
		this.personalPicture = new Blob(personalPicture);
	}

	/**
	 * Gets the personal picture.
	 *
	 * @return the personal picture
	 */
	public byte[] getPersonalPicture() {
		return personalPicture.getBytes();
	}

	/**
	 * Sets the vehicle picture.
	 *
	 * @param vehiclePicture the new vehicle picture
	 */
	public void setVehiclePicture(byte[] vehiclePicture) {
		this.vehiclePicture = new Blob(vehiclePicture);
	}

	/**
	 * Gets the vehicle picture.
	 *
	 * @return the vehicle picture
	 */
	public byte[] getVehiclePicture() {
		return vehiclePicture.getBytes();
	}

	/**
	 * Sets the comfort.
	 *
	 * @param comfort the new comfort
	 */
	public void setComfort(Integer comfort) {
		this.comfort = comfort;
	}

	/**
	 * Gets the comfort.
	 *
	 * @return the comfort
	 */
	public Integer getComfort() {
		return comfort;
	}

	/**
	 * Sets the mobile phone number.
	 *
	 * @param mobilePhoneNumber the new mobile phone number
	 */
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	/**
	 * Gets the mobile phone number.
	 *
	 * @return the mobile phone number
	 */
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * Sets the home phone number.
	 *
	 * @param homePhoneNumber the new home phone number
	 */
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	/**
	 * Gets the home phone number.
	 *
	 * @return the home phone number
	 */
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	/**
	 * Sets the work phone number.
	 *
	 * @param workPhoneNumber the new work phone number
	 */
	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	/**
	 * Gets the work phone number.
	 *
	 * @return the work phone number
	 */
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}
