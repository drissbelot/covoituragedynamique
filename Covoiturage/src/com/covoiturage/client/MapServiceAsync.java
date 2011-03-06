package com.covoiturage.client;

import java.util.List;


import com.covoiturage.shared.SimpleTravel;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MapServiceAsync {

	

	void saveJourney(List<String> steps, AsyncCallback<SimpleTravel> callback);

}
