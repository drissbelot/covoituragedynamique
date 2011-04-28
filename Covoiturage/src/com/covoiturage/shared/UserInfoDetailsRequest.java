package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(UserInfoDetails.class)
public interface UserInfoDetailsRequest extends RequestContext {
	Request<Long> countUserInfoDetails();

	Request<List<UserInfoDetailsProxy>> findAllUserInfoDetails();

	Request<UserInfoDetailsProxy> findUserInfoDetails(String id);

	InstanceRequest<UserInfoDetailsProxy, Void> persist();

	InstanceRequest<UserInfoDetailsProxy, Void> remove();

	Request<UserInfoDetailsProxy> findDetailsFromUser(String id);

	Request<List<UserInfoDetailsProxy>> getPassengerList(List<String> passengers);

	Request<UserInfoDetailsProxy> channel(String id);

	Request<UserInfoDetailsProxy> modifyUserInfoDetails(String id,
			String firstName, String lastName, String language);

	Request<UserInfoDetailsProxy> addMessageToUser(String id, String messageId);

	Request<UserInfoDetailsProxy> deleteMessage(String id, String messageId);

}
