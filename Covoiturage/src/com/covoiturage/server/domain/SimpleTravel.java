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
import com.covoiturage.server.MapUtils;






@Entity
public class SimpleTravel{

	
	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}


	public static long countSimpleTravels() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from SimpleTravel o").getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<SimpleTravel> findAllSimpleTravels() {
		EntityManager em = entityManager();
		try {
			List<SimpleTravel> list = em.createQuery("select o from SimpleTravel o").getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static SimpleTravel findSimpleTravel(Long id) {
		if (id == null) {
			return null;
		}
		EntityManager em = entityManager();
		try {
			SimpleTravel simpleTravel = em.find(SimpleTravel.class, id);
			return simpleTravel;
		} finally {
			em.close();
		}
	}
	
	public static SimpleTravel saveJourneyPassenger(List<String> steps, Date date, String passenger){
		SimpleTravel simpleTravel = new SimpleTravel();
		EntityManager em = entityManager();
		try
		{
			simpleTravel.setSteps(steps);
			simpleTravel.setDate(date);
			simpleTravel.setPassenger(passenger);
			em.persist(simpleTravel);


		}
		finally
		{

			em.close();
		}

		return simpleTravel;
	}
	
	public static List<SimpleTravel> getSimpleTravels(List<String> steps,float distanceMax){
		return MapUtils.bufferRoute(steps, distanceMax);
		
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
			SimpleTravel attached = em.find(SimpleTravel.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
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

	private List<String> steps;

	private Date date;

	  @Version
	  @Column(name = "version")
	  private Integer version;


	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getSteps() {
		return steps;
	}


	public String passenger;

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public SimpleTravel() {}

	public SimpleTravel(Long id, String passenger, List<String> steps) {

		this.id = id;
		this.passenger=passenger;
		this.steps = steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;

	}}
