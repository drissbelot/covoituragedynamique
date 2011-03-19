package com.covoiturage.server.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DriverInfo extends UserInfo{
	
	public static long countDrivers() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from DriverInfo o").getSingleResult()).longValue();
		} finally {
			em.close();
		} 
	}

	@SuppressWarnings("unchecked")
	public static List<DriverInfo> findAllDrivers() {
		EntityManager em = entityManager();
		try {
			List<DriverInfo> list = em.createQuery("select o from DriverInfo o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static DriverInfo findDriverInfo(String id) {

		EntityManager em = entityManager();
		try {
			DriverInfo driver = em.find(DriverInfo.class, id);
			return driver;
		} finally {
			em.close();
		}
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
			DriverInfo attached = em.find(DriverInfo.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}


	public DriverInfo(){
	
	}
	
	
	public DriverInfo(String makeOfvehicle, String modelOfvehicle,
			String countOfPlaces, int rating, int countOfJourneys,
			String firstName, String lastName) {
		super();
		this.makeOfvehicle = makeOfvehicle;
		this.modelOfvehicle = modelOfvehicle;
		this.countOfPlaces = countOfPlaces;
		this.rating = rating;
		this.countOfJourneys = countOfJourneys;
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	
	

}
