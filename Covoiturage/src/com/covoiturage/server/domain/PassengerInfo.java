package com.covoiturage.server.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PassengerInfo extends UserInfo{
	
	
	
	
	public static long countPassengers() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from PassengerInfo o").getSingleResult()).longValue();
		} finally {
			em.close();
		} 
	}

	@SuppressWarnings("unchecked")
	public static List<PassengerInfo> findAllPassengers() {
		EntityManager em = entityManager();
		try {
			List<PassengerInfo> list = em.createQuery("select o from PassengerInfo o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static PassengerInfo findPassengerInfo(String id) {

		EntityManager em = entityManager();
		try {
			PassengerInfo passenger = em.find(PassengerInfo.class, id);
			return passenger;
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
			PassengerInfo attached = em.find(PassengerInfo.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}


	
	
	
	private int rating;
	private int countOfJourneys;
	private String firstName;
	private String lastName;
	
	public PassengerInfo(){
		
	}
	public PassengerInfo(int rating, int countOfJourneys) {
		super();
		this.rating = rating;
		this.countOfJourneys = countOfJourneys;
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
	
	public static List<String> getPassengers(List<SimpleTravel> travels) {
		List<String> passengers = new ArrayList<String>();
		for (SimpleTravel simpleTravel : travels) {
			passengers.add(simpleTravel.getPassenger());
			
		}
		
		return passengers;
		
		

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
