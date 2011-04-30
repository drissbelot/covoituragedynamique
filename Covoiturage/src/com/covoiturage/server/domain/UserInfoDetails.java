package com.covoiturage.server.domain;

import java.util.List;


import javax.persistence.Entity;







import com.google.appengine.api.datastore.Blob;

@Entity
public class UserInfoDetails extends DatastoreObject{


	public String channelId;

	private int countOfJourneys;

	private String countOfPlaces;

	private String firstName;

	private String language;

	private String lastName;

	private String vehicle;


	private List<Long> messages;

	private int rating;

	private String user;

	private String colorOfVehicle;

	private Blob personalPicture;

	private Blob vehiclePicture;

	private int comfort;

	private String mobilePhoneNumber;

	private String homePhoneNumber;

	private String workPhoneNumber;



	public UserInfoDetails() {

	}

	public UserInfoDetails( String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addMessage(Long message) {

		messages.add(message);
	}

	public String getChannelId() {
		return channelId;
	}

	public int getCountOfJourneys() {
		return countOfJourneys;
	}

	public String getCountOfPlaces() {
		return countOfPlaces;
	}

	public String getFirstName() {
		return firstName;
	}



	public String getLanguage() {
		return language;
	}

	public String getLastName() {
		return lastName;
	}

	public String getVehicle() {
		return vehicle;
	}

	public List<Long> getMessages() {
		return messages;
	}

	public int getRating() {
		return rating;
	}

	public String getUser() {
		return user;
	}


	

	public void removeMessage(Long message) {
		messages.remove(message);
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setCountOfJourneys(int countOfJourneys) {
		this.countOfJourneys = countOfJourneys;
	}

	public void setCountOfPlaces(String countOfPlaces) {
		this.countOfPlaces = countOfPlaces;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMessages(List<Long> messages) {
		this.messages = messages;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setColorOfVehicle(String colorOfVehicle) {
		this.colorOfVehicle = colorOfVehicle;
	}

	public String getColorOfVehicle() {
		return colorOfVehicle;
	}

	public void setPersonalPicture(byte[] personalPicture) {
		this.personalPicture = new Blob(personalPicture);
	}

	public byte[] getPersonalPicture() {
		return personalPicture.getBytes();
	}

	public void setVehiclePicture(byte[] vehiclePicture) {
		this.vehiclePicture = new Blob(vehiclePicture);
	}

	public byte[] getVehiclePicture() {
		return vehiclePicture.getBytes();
	}

	public void setComfort(int comfort) {
		this.comfort = comfort;
	}

	public int getComfort() {
		return comfort;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}
