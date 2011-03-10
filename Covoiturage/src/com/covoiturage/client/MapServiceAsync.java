package com.covoiturage.client;

import java.util.Date;
import java.util.List;



import com.covoiturage.shared.SimpleTravel;
import com.covoiturage.shared.Journey;
import com.covoiturage.shared.UserInfo;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MapServiceAsync {

	

	void saveJourneyDriver(List<String> steps, Date date, UserInfo driver, AsyncCallback<Journey> asyncCallback);

	void getPassengers(List<String> steps, float distance,AsyncCallback<List<UserInfo>> asyncCallback);

	void saveJourneyPassenger(List<String> listAddress, Date date, UserInfo passenger,AsyncCallback<SimpleTravel> asyncCallback);

}
