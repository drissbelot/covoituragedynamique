package com.covoiturage.server.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.covoiturage.server.EMF;



@Entity

public class Journey {
	
	
	public static long countJourneys() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from Journey o").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Journey> findAllJourneys() {
		EntityManager em = entityManager();
		try {
			List<Journey> list = em.createQuery("select o from Journey o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static Journey findJourney(Long id) {
		if (id == null) {
			return null;
		}
		EntityManager em = entityManager();
		try {
			Journey journey = em.find(Journey.class, id);
			return journey;
		} finally {
			em.close();
		}
	}

	public Journey saveJourneyDriver(List<String> steps, Date date, UserInfo driver){
		Journey journey = new Journey();
		EntityManager em = entityManager();
		try
		{
			journey.setSteps(steps);
			journey.setDate(date);
			journey.setDriver(driver);
			persist();


		}
		finally
		{

			em.close();
		}

		return journey;
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
			Journey attached = em.find(Journey.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}


	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)

	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInfo driver;

	public List<UserInfo> passengers;

	public List<String> steps;

	public Date date;


	  @Version
	  @Column(name = "version")
	  private Integer version;

	

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Journey() {}

	public Journey(Long id, UserInfo driver, List<UserInfo> passengers, List<String> steps) {
		super();
		this.id = id;
		this.driver = driver;
		this.passengers = passengers;
		this.steps = steps;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserInfo getDriver() {
		return driver;
	}

	public void setDriver(UserInfo driver) {
		this.driver = driver;
	}

	public List<UserInfo> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<UserInfo> passengers) {
		this.passengers = passengers;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	
}

