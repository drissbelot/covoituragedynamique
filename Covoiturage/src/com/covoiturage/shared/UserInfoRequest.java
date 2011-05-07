/*
 * 
 */
package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.UserInfoDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInfoRequest.
 */
@Service(value = UserInfoDao.class, locator = DaoServiceLocator.class)
public interface UserInfoRequest extends RequestContext {
	
	/**
	 * Count user infos.
	 *
	 * @return the request
	 */
	Request<Long> countUserInfos();

	/**
	 * Find all user infos.
	 *
	 * @return the request
	 */
	Request<List<UserInfoProxy>> findAllUserInfos();

	/**
	 * Find user info.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<UserInfoProxy> findUserInfo(Long id);

	/**
	 * Logout.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<Boolean> logout(Long id);

	/**
	 * Persist.
	 *
	 * @param userInfo the user info
	 * @return the request
	 */
	Request<Long> persist(UserInfoProxy userInfo);

	/**
	 * Removes the.
	 *
	 * @param userInfo the user info
	 * @return the request
	 */
	Request<Void> remove(UserInfoProxy userInfo);

	/**
	 * Modify user info.
	 *
	 * @param id the id
	 * @param password the password
	 * @param emailAddress the email address
	 * @return the request
	 */
	Request<UserInfoProxy> modifyUserInfo(Long id, String password,
			String emailAddress);

}
