package com.covoiturage.shared;

import java.util.List;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

import com.covoiturage.server.domain.DriverInfo;


@Service(DriverInfo.class)
public interface DriverInfoRequest extends RequestContext {
	Request<Long> countDrivers();


	Request<List<DriverInfoProxy>> findAllDrivers();

	Request<DriverInfoProxy> findDriverInfo(String id);
	

	InstanceRequest<DriverInfoProxy, Void> persist();

	InstanceRequest<DriverInfoProxy, Void> remove();


	



}
