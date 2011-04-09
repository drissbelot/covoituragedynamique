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

	public static List<Journey> getJourneys(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival, 
			float distanceMax) {
		
		return MapUtils.bufferRouteJourney(steps, distanceMax, departureStart,  departureEnd, arrival);
		

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

	public static Journey saveJourneyDriver(List<String> steps, Date date, Date departureStart, Date departureEnd, Date arrival,String driver,String originAddress, String destinationAddress, List<String> waypoints, List<String> stepsDetails, List<String> passengers){
		Journey journey = new Journey();
		EntityManager em = entityManager();
		try
		{
			journey.setSteps(steps);
			journey.setDate(date);
			journey.setDriver(driver);
			journey.setOriginAddress(originAddress);
			journey.setDestinationAddress(destinationAddress);
			journey.setWaypoints(waypoints);
			journey.setStepsDetails(stepsDetails);
			journey.setDepartureStart(departureStart);
			journey.setDepartureEnd(departureEnd);
			journey.setArrival(arrival);
			journey.setPassengers(passengers);
			em.persist(journey);


		}
		finally
		{

			em.close();
		}

		return journey;
	}

	public  void persist() {
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

	public String driver;

	public List<String> passengers;

	public List<String> steps;

	public Date date;
	public List<String> stepsDetails;
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
	
	
	public List<String> getStepsDetails() {
		return stepsDetails;
	}

	public void setStepsDetails(List<String> stepsDetails) {
		this.stepsDetails = stepsDetails;
	}

	public List<String> waypoints;
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

	private String originAddress;
	private String destinationAddress;

	public List<String> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<String> waypoints) {
		this.waypoints = waypoints;
	}

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

	public Journey(Long id, String driver, List<String> passengers, List<String> steps, String originAddress, String destinationAddress, List<String> stepsDetails) {
		super();
		this.id = id;
		this.driver = driver;
		this.passengers = passengers;
		this.steps = steps;
		this.originAddress=originAddress;
		this.destinationAddress=destinationAddress;
		this.stepsDetails=stepsDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public List<String> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<String> passengers) {
		this.passengers = passengers;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}


}

