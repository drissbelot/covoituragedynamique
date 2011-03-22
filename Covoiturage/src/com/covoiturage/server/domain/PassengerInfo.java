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

import com.covoiturage.server.EMF;

@Entity
public class PassengerInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String id;
	@Version
	@Column(name = "version")
	private final Integer version = 0;

	public Integer getVersion() {
		return version;
	}

	public String getId() {
		return id;
	}

	public static long countPassengers() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery(
					"select count(o) from PassengerInfo o").getSingleResult())
					.longValue();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<PassengerInfo> findAllPassengers() {
		EntityManager em = entityManager();
		try {
			List<PassengerInfo> list = em.createQuery(
					"select o from PassengerInfo o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static PassengerInfo findPassengerFromUser(String id) {
		EntityManager em = entityManager();
		Query query = em
				.createQuery("select o from PassengerInfo o where o.user=:idParam");
		List<PassengerInfo> results = new ArrayList<PassengerInfo>();
		query.setParameter("idParam", id);
		try {

			results = query.getResultList();
			return results.get(0);
		} finally {
			em.close();

		}

	}

	public static List<PassengerInfo> findPassengerInfo(List<String> id) {
		List<PassengerInfo> passengersList = new ArrayList<PassengerInfo>();
		EntityManager em = entityManager();
		try {
			for (PassengerInfo passengerInfo : passengersList) {
				PassengerInfo passenger = em.find(PassengerInfo.class, id);
				passengersList.add(passenger);
			}
			return passengersList;
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

	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}

	private int rating;
	private int countOfJourneys;
	private String firstName;
	private String lastName;
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public PassengerInfo() {

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
