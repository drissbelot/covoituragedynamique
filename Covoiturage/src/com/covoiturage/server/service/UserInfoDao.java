package com.covoiturage.server.service;

import java.util.List;


import com.covoiturage.server.BCrypt;

import com.covoiturage.server.domain.UserInfo;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;



public class UserInfoDao extends ObjectifyDao<UserInfo> {


	public static UserInfo modifyUserInfo(Long id, String password,
			String emailAddress) {
		UserInfo user = new UserInfo();
		Objectify ofy=  ObjectifyService.begin();

		user = ofy.find(UserInfo.class,id);






		user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		user.setEmailAddress(emailAddress);

		ofy.put(user);


		return user;
	}

	public static boolean logout(Long id) {
		Objectify ofy=  ObjectifyService.begin();

		UserInfo user = ofy.find(UserInfo.class, id);

		user.setLoggedIn(false);
		ofy.put(user);


		return true;
	}


	public Long countUserInfos(){
		return (long) this.listAll().size();
	}

	public List<UserInfo> findAllUserInfos(){
		return this.listAll();
	}

	public UserInfo findUserInfo(Long id){
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public String persist(UserInfo userInfo){
		this.put(userInfo);
		return userInfo.getId().toString();
	}

	public void remove(UserInfo userInfo){
		this.delete(userInfo);
	}
}
