package com.covoiturage.client;

import java.util.Date;
import java.util.List;



import com.covoiturage.shared.Journey;
import com.covoiturage.shared.UserInfo;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MapServiceAsync {

	

	void saveJourney(List<String> steps, Date date, UserInfo driver, AsyncCallback<Journey> asyncCallback);

}
