package com.covoiturage.client;

import java.util.Date;
import java.util.List;


import com.covoiturage.shared.Journey;
import com.covoiturage.shared.SimpleTravel;
import com.covoiturage.shared.UserInfo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("map")
public interface MapService extends RemoteService{
	public Journey saveJourneyDriver(List<String> steps, Date date, UserInfo driver) ;

	List<UserInfo> getPassengers(List<String> steps, float distance);

	SimpleTravel saveJourneyPassenger(List<String> listAddress, Date date,UserInfo passenger);
}
