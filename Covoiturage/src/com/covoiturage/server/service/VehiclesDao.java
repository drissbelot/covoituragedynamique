/*
 * 
 */
package com.covoiturage.server.service;

import java.util.List;

import com.covoiturage.server.domain.Vehicles;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class VehiclesDao.
 */
public class VehiclesDao extends ObjectifyDao<Vehicles> {

	/**
	 * Gets the models from make.
	 *
	 * @param make the make
	 * @return the models from make
	 */
	public static List<Vehicles> getModelsFromMake(String make) {
		Objectify ofy = ObjectifyService.begin();

		List<Vehicles> vehicles = ofy.query(Vehicles.class)
				.filter("make", make).list();

		return vehicles;

	}

	/**
	 * Gets the seats from model.
	 *
	 * @param make the make
	 * @param model the model
	 * @return the seats from model
	 */
	Integer getSeatsFromModel(String make, String model) {
		Objectify ofy = ObjectifyService.begin();

		Vehicles vehicle = ofy.query(Vehicles.class).filter("make", make)
				.filter("model", model).get();
		return vehicle.getSeats();

	}

	/**
	 * Count vehicles.
	 *
	 * @return the long
	 */
	public Long countVehicles() {
		return (long) this.listAll().size();
	}

	/**
	 * Find all vehicles.
	 *
	 * @return the list
	 */
	public List<Vehicles> findAllVehicles() {
		return this.listAll();
	}

	/**
	 * Find vehicles.
	 *
	 * @param id the id
	 * @return the vehicles
	 */
	public Vehicles findVehicles(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param vehicles the vehicles
	 * @return the long
	 */
	public Long persist(Vehicles vehicles) {
		this.put(vehicles);
		return vehicles.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param vehicles the vehicles
	 */
	public void remove(Vehicles vehicles) {
		this.delete(vehicles);
	}
}
