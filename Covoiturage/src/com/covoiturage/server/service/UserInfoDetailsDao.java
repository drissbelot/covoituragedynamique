package com.covoiturage.server.service;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.server.ChannelServer;
import com.covoiturage.server.domain.UserInfoDetails;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class UserInfoDetailsDao extends ObjectifyDao<UserInfoDetails> {

	public static UserInfoDetails addMessageToUser(Long id, Long messageId) {
		Objectify ofy = ObjectifyService.begin();
		UserInfoDetails user = ofy.find(UserInfoDetails.class, id);
		user.addMessage(messageId);
		ofy.put(user);
		return user;

	}

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

	public static UserInfoDetails deleteMessage(Long id, Long messageId) {
		Objectify ofy = ObjectifyService.begin();
		UserInfoDetails user = ofy.find(UserInfoDetails.class, id);

		user.removeMessage(messageId);
		ofy.put(user);
		return user;

	}

	public static UserInfoDetails findDetailsFromUser(Long id) {
		Objectify ofy = ObjectifyService.begin();

		UserInfoDetails userDetails = ofy.query(UserInfoDetails.class)
				.filter("user", id).get();

		return userDetails;

	}

	public static List<UserInfoDetails> getPassengerList(List<Long> passengers) {
		Objectify ofy = ObjectifyService.begin();
		List<UserInfoDetails> result = new ArrayList<UserInfoDetails>();
		for (Long passenger : passengers) {
			result.add(ofy.find(UserInfoDetails.class, passenger));
		}
		return result;

	}

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

	public Long countUserInfoDetails() {
		return (long) this.listAll().size();
	}

	public List<UserInfoDetails> findAllUserInfoDetails() {
		return this.listAll();
	}

	public UserInfoDetails findUserInfoDetails(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public Long persist(UserInfoDetails userInfoDetails) {
		this.put(userInfoDetails);
		return userInfoDetails.getId();
	}

	public void remove(UserInfoDetails userInfoDetails) {
		this.delete(userInfoDetails);
	}
}
