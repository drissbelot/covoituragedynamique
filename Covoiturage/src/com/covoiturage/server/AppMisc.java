package com.covoiturage.server;

import javax.jdo.PersistenceManager;

import com.covoiturage.shared.UserInfo;
import com.google.gwt.core.client.GWT;

public class AppMisc {


	void populateDataStoreOnce() {
		UserInfo defaultUser = UserInfo.getDefaultUser();
		GWT.log("t");
		if (defaultUser != null)
			return; 
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			defaultUser = new UserInfo();
			defaultUser.setLogin("test");
			defaultUser.setPassword("test");
			pm.makePersistent(defaultUser);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			pm.close();
		}
	}
}





