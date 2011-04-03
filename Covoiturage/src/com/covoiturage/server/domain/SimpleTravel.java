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
public class SimpleTravel {

	public static long countSimpleTravels() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery(
					"select count(o) from SimpleTravel o").getSingleResult())
					.longValue();
		} finally {
			em.close();
		}
	}

	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public static List<SimpleTravel> findAllSimpleTravels() {
		EntityManager em = entityManager();
		try {
			List<SimpleTravel> list = em.createQuery(
					"select o from SimpleTravel o").getResultList();

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

	public static List<SimpleTravel> getSimpleTravels(List<String> steps,Date departureStart, Date departureEnd, Date arrival,
			float distanceMax) {
		return MapUtils.bufferRoute(steps, departureStart,  departureEnd,  arrival, distanceMax);

	}

	public static SimpleTravel saveJourneyPassenger(List<String> steps, String originAddress, String destinationAddress,
			Date date,Date departureStart, Date departureEnd, Date arrival, String passenger) {
		SimpleTravel simpleTravel = new SimpleTravel();
		EntityManager em = entityManager();
		try {
			simpleTravel.setSteps(steps);
			simpleTravel.setDate(date);
			simpleTravel.setPassenger(passenger);
			simpleTravel.setOriginAddress(originAddress);
			simpleTravel.setDestinationAddress(destinationAddress);
			simpleTravel.setDepartureStart(departureStart);
			simpleTravel.setDepartureEnd(departureEnd);
			simpleTravel.setArrival(arrival);
			em.persist(simpleTravel);

		} finally {

			em.close();
		}

		return simpleTravel;
	}



	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private Date date;
	public String passenger;
	private String originAddress;
	private String destinationAddress;

	@Version
	@Column(name = "version")
	private Integer version;
	private List<String> steps;
	
	public Date getDepartureStart() {
		return departureStart;
	}

	public void setDepartureStart(Date departureStart) {
		this.departureStart = departureStart;
	}

	public Date getDepartureEnd() {
		return departureEnd;
	}

	public void setDepartureEnd(Date departureEnd) {
		this.departureEnd = departureEnd;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date departureStart;
	public Date departureEnd;
	public Date arrival;
	
	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}





	public SimpleTravel() {
	}

	public SimpleTravel(Long id, String passenger, List<String> steps) {

		this.id = id;
		this.passenger = passenger;
		this.steps = steps;
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	public String getPassenger() {
		return passenger;
	}

	public List<String> getSteps() {
		return steps;
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
			SimpleTravel attached = em.find(SimpleTravel.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;

	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
