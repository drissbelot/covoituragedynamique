/*
 * 
 */
package com.covoiturage.server.service;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.server.ChannelServer;
import com.covoiturage.server.domain.UserInfoDetails;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInfoDetailsDao.
 */
public class UserInfoDetailsDao extends ObjectifyDao<UserInfoDetails> {

	/**
	 * Adds the message to user.
	 *
	 * @param id the id
	 * @param messageId the message id
	 * @return the user info details
	 */
	public static UserInfoDetails addMessageToUser(Long id, Long messageId) {
		Objectify ofy = ObjectifyService.begin();
		UserInfoDetails user = ofy.find(UserInfoDetails.class, id);
		user.addMessage(messageId);
		ofy.put(user);
		return user;

	}

	/**
	 * Channel.
	 *
	 * @param id the id
	 * @return the user info details
	 */
	public static UserInfoDetails channel(Long id) {
		Objectify ofy = ObjectifyService.begin();
		UserInfoDetails userDetails = new UserInfoDetails();

		userDetails = ofy.query(UserInfoDetails.class).filter("user", id).get();

		String channelId = ChannelServer.createChannel(userDetails.getId()
				.toString());
		userDetails.setChannelId(channelId);
		ofy.put(userDetails);
		return userDetails;

	}

	/**
	 * Delete message.
	 *
	 * @param id the id
	 * @param messageId the message id
	 * @return the user info details
	 */
	public static UserInfoDetails deleteMessage(Long id, Long messageId) {
		Objectify ofy = ObjectifyService.begin();
		UserInfoDetails user = ofy.find(UserInfoDetails.class, id);

		user.removeMessage(messageId);
		ofy.put(user);
		return user;

	}

	/**
	 * Find details from user.
	 *
	 * @param id the id
	 * @return the user info details
	 */
	public static UserInfoDetails findDetailsFromUser(Long id) {
		Objectify ofy = ObjectifyService.begin();

		UserInfoDetails userDetails = ofy.query(UserInfoDetails.class)
				.filter("user", id).get();

		return userDetails;

	}

	/**
	 * Gets the passenger list.
	 *
	 * @param passengers the passengers
	 * @return the passenger list
	 */
	public static List<UserInfoDetails> getPassengerList(List<Long> passengers) {
		Objectify ofy = ObjectifyService.begin();
		List<UserInfoDetails> result = new ArrayList<UserInfoDetails>();
		for (Long passenger : passengers) {
			result.add(ofy.find(UserInfoDetails.class, passenger));
		}
		return result;

	}

	/**
	 * Modify user info details.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param language the language
	 * @return the user info details
	 */
	public static UserInfoDetails modifyUserInfoDetails(Long id,
			String firstName, String lastName, String language) {
		UserInfoDetails user = new UserInfoDetails();
		Objectify ofy = ObjectifyService.begin();

		user = ofy.query(UserInfoDetails.class).filter("user", id).get();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLanguage(language);

		ofy.put(user);

		return user;

	}

	/**
	 * Count user info details.
	 *
	 * @return the long
	 */
	public Long countUserInfoDetails() {
		return (long) this.listAll().size();
	}

	/**
	 * Find all user info details.
	 *
	 * @return the list
	 */
	public List<UserInfoDetails> findAllUserInfoDetails() {
		return this.listAll();
	}

	/**
	 * Find user info details.
	 *
	 * @param id the id
	 * @return the user info details
	 */
	public UserInfoDetails findUserInfoDetails(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param userInfoDetails the user info details
	 * @return the long
	 */
	public Long persist(UserInfoDetails userInfoDetails) {
		this.put(userInfoDetails);
		return userInfoDetails.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param userInfoDetails the user info details
	 */
	public void remove(UserInfoDetails userInfoDetails) {
		this.delete(userInfoDetails);
	}
}
