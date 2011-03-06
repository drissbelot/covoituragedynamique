package com.covoiturage.client;

import java.util.List;


import com.covoiturage.shared.SimpleTravel;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("map")
public interface MapService extends RemoteService{
	public SimpleTravel saveJourney(List<String> steps) ;
}
