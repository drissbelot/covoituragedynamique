package com.covoiturage.server.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.datanucleus.jpa.annotations.Extension;

import com.covoiturage.server.EMF;




@Entity
public class DriverInfo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    public String id;
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
	private String user;



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
	
	
	

}
