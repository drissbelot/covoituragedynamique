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





@Entity
public class UserInfoDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    public String id;
	public String channelId;
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}





	@Version
	@Column(name = "version")
	private Integer version = 0;
	public static final EntityManager entityManager() {
		
		return EMF.get().createEntityManager();
		
	}
	public static long countUserInfoDetails() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from UserInfoDetails o").getSingleResult()).longValue();
		} finally {
			em.close();
		} 
	}

	@SuppressWarnings("unchecked")
	public static List<UserInfoDetails> findAllUserInfoDetails() {
		EntityManager em = entityManager();
		try {
			List<UserInfoDetails> list = em.createQuery("select o from UserInfoDetails o").getResultList();

			list.size();
			return list;
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
	@SuppressWarnings("unchecked")
	public static UserInfoDetails findDetailsFromUser(String id){
		EntityManager em = entityManager();
		try {
			Query query= em.createQuery("select o from UserInfoDetails o where o.user=:user");
			query.setParameter("user", id);
			List<UserInfoDetails> list =query.getResultList();
			list.get(0).getMessages();
			return list.get(0);
		} finally {
			em.close();
		}
		
	}
	@SuppressWarnings("unchecked")
	public static UserInfoDetails channel(String id){
		EntityManager em = entityManager();
		UserInfoDetails userDetails = new UserInfoDetails();
		try {
			Query query= em.createQuery("select o from UserInfoDetails o where o.user=:user");
			query.setParameter("user", id);
			List<UserInfoDetails> list =query.getResultList();
			
			userDetails=list.get(0);
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
	public static UserInfoDetails modifyUserInfoDetails(String id,String firstName, String lastName, String language){
		UserInfoDetails user = new UserInfoDetails();
		EntityManager em = entityManager();
		
		Query query= em.createQuery("select o from UserInfoDetails o where o.user = :idParam ");
		query.setParameter("idParam",id);

		try
		{

			@SuppressWarnings("unchecked")
			List<UserInfoDetails> results =query.getResultList();
	
			if(results.size()==0){
				return null;
			}
			else 
			{
				
				user= results.get(0);

				em.getTransaction().begin();
				
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLanguage(language);

				em.getTransaction().commit();
				
		}
		}
		finally
		{
			em.close();
		}



		
		return user;
		
	}
	public static List<UserInfoDetails> getPassengerList(List<String> passengers){
		EntityManager em = entityManager();
		List<UserInfoDetails> result = new ArrayList<UserInfoDetails>();
		for (String string : passengers) {
			result.add(em.find(UserInfoDetails.class, string));
		}
		return result;
		
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


	public UserInfoDetails(){
	
	}
	
	
	public UserInfoDetails(String makeOfvehicle, String modelOfvehicle,
			String countOfPlaces, int rating, int countOfJourneys,
			String firstName, String lastName, String language, List<String> messages) {
		super();
		this.makeOfvehicle = makeOfvehicle;
		this.modelOfvehicle = modelOfvehicle;
		this.countOfPlaces = countOfPlaces;
		this.rating = rating;
		this.countOfJourneys = countOfJourneys;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language=language;
		this.messages=messages;
	}





	public String getMakeOfvehicle() {
		return makeOfvehicle;
	}

	public void setMakeOfvehicle(String makeOfvehicle) {
		this.makeOfvehicle = makeOfvehicle;
	}

	public String getModelOfvehicle() {
		return modelOfvehicle;
	}

	public void setModelOfvehicle(String modelOfvehicle) {
		this.modelOfvehicle = modelOfvehicle;
	}





	private String makeOfvehicle;
	private String modelOfvehicle;
	private String countOfPlaces;
	private int rating;
	private int countOfJourneys;
	private String firstName;
	private String lastName;
	private String user;
	private String language;
	private List<String> messages; 



	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setCountOfPlaces(String countOfPlaces) {
		this.countOfPlaces = countOfPlaces;
	}
	public String getCountOfPlaces() {
		return countOfPlaces;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setCountOfJourneys(int countOfJourneys) {
		this.countOfJourneys = countOfJourneys;
	}
	public int getCountOfJourneys() {
		return countOfJourneys;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addMessage(String message) {
		
			messages.add(message);
		
		
		
	}
	
	
	

}
