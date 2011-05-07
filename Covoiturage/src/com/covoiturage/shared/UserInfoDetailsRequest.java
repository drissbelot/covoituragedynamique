/*
 * 
 */
package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.UserInfoDetailsDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInfoDetailsRequest.
 */
@Service(value = UserInfoDetailsDao.class, locator = DaoServiceLocator.class)
public interface UserInfoDetailsRequest extends RequestContext {
	
	/**
	 * Count user info details.
	 *
	 * @return the request
	 */
	Request<Long> countUserInfoDetails();

	/**
	 * Find all user info details.
	 *
	 * @return the request
	 */
	Request<List<UserInfoDetailsProxy>> findAllUserInfoDetails();

	/**
	 * Find user info details.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> findUserInfoDetails(Long id);

	/**
	 * Persist.
	 *
	 * @param userDetails the user details
	 * @return the request
	 */
	Request<Long> persist(UserInfoDetailsProxy userDetails);

	/**
	 * Removes the.
	 *
	 * @param userDetails the user details
	 * @return the request
	 */
	Request<Void> remove(UserInfoDetailsProxy userDetails);

	/**
	 * Find details from user.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> findDetailsFromUser(Long id);

	/**
	 * Gets the passenger list.
	 *
	 * @param passengers the passengers
	 * @return the passenger list
	 */
	Request<List<UserInfoDetailsProxy>> getPassengerList(List<Long> passengers);

	/**
	 * Channel.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> channel(Long id);

	/**
	 * Modify user info details.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param language the language
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> modifyUserInfoDetails(Long id,
			String firstName, String lastName, String language);

	/**
	 * Adds the message to user.
	 *
	 * @param id the id
	 * @param messageId the message id
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> addMessageToUser(Long id, Long messageId);

	/**
	 * Delete message.
	 *
	 * @param id the id
	 * @param messageId the message id
	 * @return the request
	 */
	Request<UserInfoDetailsProxy> deleteMessage(Long id, Long messageId);

}
