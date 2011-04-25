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
public class Vehicles {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	public String id;

	public String getId() {
		return id;
	}

	@Version
	@Column(name = "version")
	private final Integer version = 0;
	private String make;
	private String model;
	private String date;
	private int seats;
	private float fuelMixedDrive;
	private float emissionsCO2;

	public Integer getVersion() {
		return version;
	}

	public static final EntityManager entityManager() {

		return EMF.get().createEntityManager();

	}

	public Vehicles() {

	}

	public Vehicles(String id, String make, String models, String date,
			int seats) {
		this.id = id;
		this.make = make;
		this.model = models;
		this.date = date;
		this.seats = seats;

	}

	public static Vehicles findVehicles(String id) {

		EntityManager em = entityManager();
		try {
			Vehicles vehicle = em.find(Vehicles.class, id);
			return vehicle;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Vehicles> findAllVehicles() {
		EntityManager em = entityManager();
		try {
			List<Vehicles> list = em.createQuery("select o from Vehicles o")
					.getResultList();

			list.size();
			return list;
		} finally {
			em.close();
		}
	}

	public static long countVehicles() {
		EntityManager em = entityManager();
		try {
			return ((Number) em.createQuery("select count(o) from Vehicles o")
					.getSingleResult()).longValue();
		} finally {
			em.close();
		}
	}

	public String persist() {
		EntityManager em = entityManager();
		try {
			em.persist(this);
		} finally {
			em.close();
		}
		return this.id;
	}

	public void remove() {
		EntityManager em = entityManager();
		try {
			Vehicles attached = em.find(Vehicles.class, this.id);
			em.remove(attached);
		} finally {
			em.close();
		}
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public static List<Vehicles> getModelsFromMake(String make) {
		EntityManager em = entityManager();

		try {
			@SuppressWarnings("unchecked")
			List<Vehicles> vehicles = em.createQuery(
					"select o from Vehicles o where o.make = :make")
					.getResultList();
			return vehicles;

		} finally {
			em.close();
		}

	}

	Integer getSeatsFromModel(String make, String model) {
		EntityManager em = entityManager();

		try {

			Vehicles vehicle = (Vehicles) em
					.createQuery(
							"select o from Vehicles o where o.make = :make and o.model=:model")
					.getSingleResult();
			return vehicle.getSeats();

		} finally {
			em.close();
		}

	}

	public void setFuelMixedDrive(float fuelMixedDrive) {
		this.fuelMixedDrive = fuelMixedDrive;
	}

	public float getFuelMixedDrive() {
		return fuelMixedDrive;
	}

	public void setEmissionsCO2(float emissionsCO2) {
		this.emissionsCO2 = emissionsCO2;
	}

	public float getEmissionsCO2() {
		return emissionsCO2;
	}
}
