package com.covoiturage.shared;

import java.util.List;


import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.UserInfoDetailsDao;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(value=UserInfoDetailsDao.class,locator = DaoServiceLocator.class)
public interface UserInfoDetailsRequest extends RequestContext {
	Request<Long> countUserInfoDetails();

	Request<List<UserInfoDetailsProxy>> findAllUserInfoDetails();

	Request<UserInfoDetailsProxy> findUserInfoDetails(Long id);

	Request<String> persist(UserInfoDetailsProxy userDetails);

	Request<Void> remove(UserInfoDetailsProxy userDetails);

	Request<UserInfoDetailsProxy> findDetailsFromUser(Long id);

	Request<List<UserInfoDetailsProxy>> getPassengerList(List<Long> passengers);

	Request<UserInfoDetailsProxy> channel(Long id);

	Request<UserInfoDetailsProxy> modifyUserInfoDetails(Long id,
			String firstName, String lastName, String language);

	Request<UserInfoDetailsProxy> addMessageToUser(Long id, Long messageId);

	Request<UserInfoDetailsProxy> deleteMessage(Long id, Long messageId);

}
