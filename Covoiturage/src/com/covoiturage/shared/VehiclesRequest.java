/*
 * 
 */
package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.VehiclesDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehiclesRequest.
 */
@Service(value = VehiclesDao.class, locator = DaoServiceLocator.class)
public interface VehiclesRequest extends RequestContext {
	
	/**
	 * Count vehicles.
	 *
	 * @return the request
	 */
	Request<Long> countVehicles();

	/**
	 * Find all vehicles.
	 *
	 * @return the request
	 */
	Request<List<VehiclesProxy>> findAllVehicles();

	/**
	 * Find vehicles.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<VehiclesProxy> findVehicles(Long id);

	/**
	 * Persist.
	 *
	 * @param vehicle the vehicle
	 * @return the request
	 */
	Request<Long> persist(VehiclesProxy vehicle);

	/**
	 * Removes the.
	 *
	 * @param vehicle the vehicle
	 * @return the request
	 */
	Request<Void> remove(VehiclesProxy vehicle);

	/**
	 * Gets the models from make.
	 *
	 * @param make the make
	 * @return the models from make
	 */
	Request<List<VehiclesProxy>> getModelsFromMake(String make);

	/**
	 * Gets the seats from model.
	 *
	 * @param make the make
	 * @param model the model
	 * @return the seats from model
	 */
	Request<Integer> getSeatsFromModel(String make, String model);

}
