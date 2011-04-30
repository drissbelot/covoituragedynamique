package com.covoiturage.server.service;

import java.util.List;



import com.covoiturage.server.domain.Vehicles;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;



public class VehiclesDao extends ObjectifyDao<Vehicles> {
	
	public static List<Vehicles> getModelsFromMake(String make) {
		Objectify ofy=  ObjectifyService.begin();

			List<Vehicles> vehicles = ofy.query(Vehicles.class).filter("make", make).list();
					
			return vehicles;

		

	}

	Integer getSeatsFromModel(String make, String model) {
		Objectify ofy=  ObjectifyService.begin();

			Vehicles vehicle = ofy.query(Vehicles.class).filter("make",make).filter("model",model).get();
			return vehicle.getSeats();

	

	}
	public Long countVehicles(){
		return (long) this.listAll().size();
	}

	public List<Vehicles> findAllVehicles(){
		return this.listAll();
	}

	public Vehicles findVehicles(Long id){
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public String persist(Vehicles vehicles){
		this.put(vehicles);
		return vehicles.getId().toString();
	}

	public void remove(Vehicles vehicles){
		this.delete(vehicles);
	}
}
