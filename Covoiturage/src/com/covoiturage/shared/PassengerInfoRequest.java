package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.PassengerInfo;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(PassengerInfo.class)
public interface PassengerInfoRequest extends RequestContext {
	Request<Long> countPassengers();

	Request<List<PassengerInfoProxy>> findAllPassengers();

	Request<PassengerInfoProxy> findPassengerInfo(String id);

	Request<List<String>> getPassengers(List<SimpleTravelProxy> travels);

	InstanceRequest<PassengerInfoProxy, Void> persist();

	InstanceRequest<PassengerInfoProxy, Void> remove();

	Request<PassengerInfoProxy> findPassengerFromUser(String id);
	
	Request<List<PassengerInfoProxy>> getPassengerList(List<String> idList);
}
