package com.covoiturage.server.domain;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
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
import com.covoiturage.server.MapUtils;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;


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

	public static SimpleTravel findSimpleTravel(String id) {
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
	@SuppressWarnings("unchecked")
	public static List<SimpleTravel> getSimpleTravelsFromUser(String userId){
		EntityManager em = entityManager();
		try {
			List<SimpleTravel> list = em.createQuery(
			"select o from SimpleTravel o where o.passenger = :userId").getResultList();
			list.size();
			return list;

		} finally {
			em.close();
		}



	}
	public static SimpleTravel saveJourneyPassenger(List<String> steps, String originAddress, String destinationAddress,
			Date date,Date departureStart, Date departureEnd, Date arrival, String passenger, String mapImage) {
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
			 URLFetchService fetchService =
		            URLFetchServiceFactory.getURLFetchService();
			
			try {
				HTTPResponse fetchResponse = fetchService.fetch(new URL(mapImage));
				String fetchResponseContentType = null;
		        for (HTTPHeader header : fetchResponse.getHeaders()) {
		            
		            if (header.getName().equalsIgnoreCase("content-type")) {
		                fetchResponseContentType = header.getValue();
		                break;
		            }
		        }

		        if (fetchResponseContentType != null) {
		            
		            
		        	simpleTravel.setMapImageType(fetchResponseContentType);
	
		        	simpleTravel.setMapImage(fetchResponse.getContent());;
				
				
		        }
				
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			
			em.persist(simpleTravel);

		} finally {

			em.close();
		}

		return simpleTravel;
	}
	public static void updateSimpleTravel(String id, String statusDriver, String statusPassenger){

		SimpleTravel travel = new SimpleTravel();
		EntityManager em = entityManager();

		Query query= em.createQuery("select o from SimpleTravel o where o.id = :idParam ");
		query.setParameter("idParam",id);

		try
		{

			@SuppressWarnings("unchecked")
			List<SimpleTravel> results =query.getResultList();

			if(results.size()!=0){


				travel= results.get(0);

				em.getTransaction().begin();

				travel.setStatusDriver(statusDriver);
				travel.setStatusPassenger(statusPassenger);

				em.getTransaction().commit();
			}


		}
		finally
		{
			em.close();
		}



	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	public String id;
	private Date date;
	public String passenger;
	private String originAddress;
	private String destinationAddress;
	private Blob mapImage;
	private String mapImageType;
	

	
	public String getMapImageType() {
		return mapImageType;
	}

	public void setMapImageType(String mapImageType) {
		this.mapImageType = mapImageType;
	}

	public String getStatusPassenger() {
		return statusPassenger;
	}

	public void setStatusPassenger(String statusPassenger) {
		this.statusPassenger = statusPassenger;
	}

	public String getStatusDriver() {
		return statusDriver;
	}

	public void setStatusDriver(String statusDriver) {
		this.statusDriver = statusDriver;
	}



	private String statusPassenger;
	private String statusDriver;

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

	public SimpleTravel(String id, String passenger, List<String> steps) {

		this.id = id;
		this.passenger = passenger;
		this.steps = steps;
	}

	public Date getDate() {
		return date;
	}

	public String getId() {
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

	public void setId(String id) {
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

	public void setMapImage(byte[] mapImage) {
		this.mapImage = new Blob(mapImage);
	}

	public byte[] getMapImage() {
		return mapImage.getBytes();
	}
}
