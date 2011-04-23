package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.Vehicles;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(Vehicles.class)
public interface VehiclesRequest extends RequestContext {
	Request<Long> countVehicles();

	Request<List<VehiclesProxy>> findAllVehicles();

	Request<VehiclesProxy> findVehicles(String id);

	InstanceRequest<VehiclesProxy, String> persist();

	InstanceRequest<VehiclesProxy, Void> remove();

	Request<List<String>> getModelsFromMake();

	Request<Integer> getSeatsFromModel(String make, String model);

}
