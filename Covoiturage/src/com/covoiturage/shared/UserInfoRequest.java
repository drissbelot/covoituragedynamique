package com.covoiturage.shared;

import java.util.List;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.covoiturage.server.domain.SimpleTravel;
import com.covoiturage.server.domain.UserInfo;

@Service(UserInfo.class)
public interface UserInfoRequest extends RequestContext {
	Request<Long> countUsers();


	Request<List<UserInfoProxy>> findAllUsers();

	Request<UserInfoProxy> findUserInfo(String id);
	
	Request<UserInfoProxy> login(String login, String password);
	
	Request<List<String>> getPassengers(List<SimpleTravelProxy> travels);

	InstanceRequest<UserInfoProxy, Void> persist();

	InstanceRequest<UserInfoProxy, Void> remove();


	



}
