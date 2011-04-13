package com.covoiturage.shared;

import java.util.List;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

import com.covoiturage.server.domain.UserInfo;

@Service(UserInfo.class)
public interface UserInfoRequest extends RequestContext {
	Request<Long> countUsers();


	Request<List<UserInfoProxy>> findAllUsers();

	Request<UserInfoProxy> findUserInfo(String id);
	

	Request<Boolean> logout(String id);

	InstanceRequest<UserInfoProxy, String> persist();

	InstanceRequest<UserInfoProxy, Void> remove();


	Request<UserInfoProxy> modifyUserInfo(String id,String password, String emailAddress);


	



}
