package com.covoiturage.shared;

import java.util.List;


import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;


import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.UserInfoDao;

@Service(value=UserInfoDao.class,locator = DaoServiceLocator.class)
public interface UserInfoRequest extends RequestContext {
	Request<Long> countUserInfos();

	Request<List<UserInfoProxy>> findAllUserInfos();

	Request<UserInfoProxy> findUserInfo(Long id);

	Request<Boolean> logout(Long id);

	Request<String> persist(UserInfoProxy userInfo);

	Request<Void> remove(UserInfoProxy userInfo);

	Request<UserInfoProxy> modifyUserInfo(Long id, String password,
			String emailAddress);

}
