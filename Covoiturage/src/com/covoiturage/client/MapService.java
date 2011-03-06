package com.covoiturage.client;

import java.util.Date;
import java.util.List;


import com.covoiturage.shared.Journey;
import com.covoiturage.shared.UserInfo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("map")
public interface MapService extends RemoteService{
	public Journey saveJourney(List<String> steps, Date date, UserInfo driver) ;
}
