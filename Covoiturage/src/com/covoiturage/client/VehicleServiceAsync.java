package com.covoiturage.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface VehicleServiceAsync {

	void getModels(String make, String model,
			AsyncCallback<List<String>> callback);

	void getMakes(String model, AsyncCallback<List<String>> callback);

	void getYears(String model, String make, String year,
			AsyncCallback<List<String>> callback);

}
