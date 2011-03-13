package com.covoiturage.shared;

import com.google.gwt.requestfactory.shared.RequestFactory;

public interface CovoiturageRequestFactory extends RequestFactory {
	UserInfoRequest userInfoRequest();
	
	JourneyRequest journeyRequest();
	
	SimpleTravelRequest simpleTravelRequest();
	


}
