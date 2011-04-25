package com.covoiturage.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Version;

import org.datanucleus.jpa.annotations.Extension;

import com.covoiturage.server.ChannelServer;
import com.covoiturage.server.EMF;
import com.google.appengine.api.datastore.Blob;

@Entity
public class UserInfoDetails {
	public static UserInfoDetails addMessageToUser(String id, String messageId) {
		UserInfoDetails user = findUserInfoDetails(id);
		EntityManager em = entityManager();
		try {

			user.addMessage(messageId);
			em.merge(user);

			return user;
		} finally {
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public static UserInfoDetails channel(String id) {
		EntityManager em = entityManager();
		UserInfoDetails userDetails = new UserInfoDetails();
		try {
			Query query = em
					.createQuery("select o from UserInfoDetails o where o.user=:user");
			query.setParameter("user", id);
			List<UserInfoDetails> list = query.getResultList();

			userDetails = list.get(0);
			em.getTransaction().begin();
			String channelId = ChannelServer.createChannel(userDetails.getId());
			userDetails.setChannelId(channelId);
			userDetails.getMessages();
			em.getTransaction().commit();
			return userDetails;
		} finally {
			em.close();
		}
	}

	public static long countUserInfoDetails() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery(
					"select count(o) from UserInfoDetails o").getSingleResult())
					.longValue();
		} finally {
			em.close();
		}
	}

	public static UserInfoDetails deleteMessage(String id, String messageId) {
		UserInfoDetails user = findUserInfoDetails(id);
		EntityManager em = entityManager();
		try {

			user.removeMessage(messageId);
			em.merge(user);

			return user;
		} finally {
			em.close();
		}
	}

	public static final EntityManager entityManager() {

		return EMF.get().createEntityManager();

	}

	@SuppressWarnings("unchecked")
	public static List<UserInfoDetails> findAllUserInfoDetails() {
		EntityManager em = entityManager();
		try {
			List<UserInfoDetails> list = em.createQuery(
					"select o from UserInfoDetails o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static UserInfoDetails findDetailsFromUser(String id) {
		EntityManager em = entityManager();
		try {
			Query query = em
					.createQuery("select o from UserInfoDetails o where o.user=:user");
			query.setParameter("user", id);
			List<UserInfoDetails> list = query.getResultList();
			list.get(0).getMessages();
			return list.get(0);
		} finally {
			em.close();
		}

	}

	public static UserInfoDetails findUserInfoDetails(String id) {

		EntityManager em = entityManager();
		try {
			UserInfoDetails driver = em.find(UserInfoDetails.class, id);
			driver.getMessages();
			return driver;
		} finally {

			em.close();
		}
	}

	public static List<UserInfoDetails> getPassengerList(List<String> passengers) {
		EntityManager em = entityManager();
		List<UserInfoDetails> result = new ArrayList<UserInfoDetails>();
		for (String string : passengers) {
			result.add(em.find(UserInfoDetails.class, string));
		}
		return result;

	}

	public static UserInfoDetails modifyUserInfoDetails(String id,
			String firstName, String lastName, String language) {
		UserInfoDetails user = new UserInfoDetails();
		EntityManager em = entityManager();

		Query query = em
				.createQuery("select o from UserInfoDetails o where o.user = :idParam ");
		query.setParameter("idParam", id);

		try {

			@SuppressWarnings("unchecked")
			List<UserInfoDetails> results = query.getResultList();

			if (results.size() == 0) {
				return null;
			} else {

				user = results.get(0);

				em.getTransaction().begin();

				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLanguage(language);

				em.getTransaction().commit();

			}
		} finally {
			em.close();
		}

		return user;

	}

	public String channelId;

	private int countOfJourneys;

	private String countOfPlaces;

	private String firstName;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String id;

	private String language;

	private String lastName;

	private String vehicle;

	private List<String> messages;

	private int rating;

	private String user;

	private String colorOfVehicle;

	private Blob personalPicture;

	private Blob vehiclePicture;

	private int comfort;

	private String mobilePhoneNumber;

	private String homePhoneNumber;

	private String workPhoneNumber;

	@Version
	@Column(name = "version")
	private final Integer version = 0;

	public UserInfoDetails() {

	}

	public UserInfoDetails(String vehicle, String countOfPlaces, int rating,
			int countOfJourneys, String firstName, String lastName,
			String language, List<String> messages, String colorOfVehicle,
			int comfort) {
		super();
		this.vehicle = vehicle;
		this.countOfPlaces = countOfPlaces;
		this.rating = rating;
		this.countOfJourneys = countOfJourneys;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.messages = messages;
		this.setColorOfVehicle(colorOfVehicle);
		this.setComfort(comfort);
	}

	protected void addMessage(String message) {

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

	public String getId() {
		return id;
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

	public List<String> getMessages() {
		return messages;
	}

	public int getRating() {
		return rating;
	}

	public String getUser() {
		return user;
	}

	public Integer getVersion() {
		return version;
	}

	public void persist() {
		EntityManager em = entityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
	}

	public void remove() {
		EntityManager em = entityManager();
		try {
			UserInfoDetails attached = em.find(UserInfoDetails.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}

	protected void removeMessage(String message) {
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

	public void setMessages(List<String> messages) {
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
