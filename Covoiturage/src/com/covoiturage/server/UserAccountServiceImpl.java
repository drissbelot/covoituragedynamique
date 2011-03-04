package com.covoiturage.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpSession;

import com.covoiturage.client.UserAccountService;
import com.covoiturage.shared.UserInfo;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserAccountServiceImpl extends RemoteServiceServlet implements UserAccountService{


	private static final long serialVersionUID = 1;

	private void setUserInSession(UserInfo user) {
		HttpSession session = getThreadLocalRequest().getSession();
		session.setAttribute("user", user.getId());
	}


	@Override
	public UserInfo login(String login, String password) {


		UserInfo user = new UserInfo();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query= pm.newQuery("select from com.covoiturage.shared.UserInfo where login == loginParam");
		query.declareParameters("String loginParam");
		try
		{
			List<UserInfo> results = (List<UserInfo>) query.execute(login);
			if(results.size()==0){
				return null;
			}
			else
			{

				user= results.get(0);
			}
		}
		finally
		{
			query.closeAll();
			pm.close();
		}


		user.setLogin(login);
		user.setLoggedIn(true);
		setUserInSession(user);
		return user;





}




}



