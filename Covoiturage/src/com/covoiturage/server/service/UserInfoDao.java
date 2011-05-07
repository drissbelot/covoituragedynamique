/*
 * 
 */
package com.covoiturage.server.service;

import java.util.List;

import com.covoiturage.server.BCrypt;
import com.covoiturage.server.domain.UserInfo;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInfoDao.
 */
public class UserInfoDao extends ObjectifyDao<UserInfo> {

	/**
	 * Modify user info.
	 *
	 * @param id the id
	 * @param password the password
	 * @param emailAddress the email address
	 * @return the user info
	 */
	public static UserInfo modifyUserInfo(Long id, String password,
			String emailAddress) {
		UserInfo user = new UserInfo();
		Objectify ofy = ObjectifyService.begin();

		user = ofy.find(UserInfo.class, id);

		user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		user.setEmailAddress(emailAddress);

		ofy.put(user);

		return user;
	}

	/**
	 * Logout.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public static boolean logout(Long id) {
		Objectify ofy = ObjectifyService.begin();

		UserInfo user = ofy.find(UserInfo.class, id);

		user.setLoggedIn(false);
		ofy.put(user);

		return true;
	}

	/**
	 * Count user infos.
	 *
	 * @return the long
	 */
	public Long countUserInfos() {
		return (long) this.listAll().size();
	}

	/**
	 * Find all user infos.
	 *
	 * @return the list
	 */
	public List<UserInfo> findAllUserInfos() {
		return this.listAll();
	}

	/**
	 * Find user info.
	 *
	 * @param id the id
	 * @return the user info
	 */
	public UserInfo findUserInfo(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param userInfo the user info
	 * @return the long
	 */
	public Long persist(UserInfo userInfo) {
		this.put(userInfo);
		return userInfo.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param userInfo the user info
	 */
	public void remove(UserInfo userInfo) {
		this.delete(userInfo);
	}
}
