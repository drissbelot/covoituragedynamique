package com.covoiturage.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("vehicleService")
public interface VehicleService extends RemoteService {

	List<String> getModels(String make, String model);

	List<String> getMakes(String model);

	List<String> getYears(String model, String make, String year);

}
