package com.covoiturage.shared;

import java.util.List;


import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.VehiclesDao;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(value=VehiclesDao.class,locator = DaoServiceLocator.class)
public interface VehiclesRequest extends RequestContext {
	Request<Long> countVehicles();

	Request<List<VehiclesProxy>> findAllVehicles();

	Request<VehiclesProxy> findVehicles(Long id);

	Request<String> persist(VehiclesProxy vehicle);

	Request<Void> remove(VehiclesProxy vehicle);

	Request<List<VehiclesProxy>> getModelsFromMake(String make);

	Request<Integer> getSeatsFromModel(String make, String model);

}
