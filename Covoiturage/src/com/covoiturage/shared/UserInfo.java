package com.covoiturage.shared;

import java.io.Serializable;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Extension;







@PersistenceCapable
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	public String id;
	@Persistent
	public String login;
	@Persistent
	public String emailAddress;
	private String loginUrl;
	private String logoutUrl;
	@Persistent
	private String password;

	private boolean loggedIn = false;



	public UserInfo() {}

	public UserInfo(String id, String login, String emailAddress, String password) {
		this.id = id;
		this.login = login;
		this.setPassword(password);

		this.emailAddress = emailAddress;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getLogin() { return login; }

	public void setLogin(String login) { this.login= login; }
	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }


	public static UserInfo getDefaultUser() {

		return null;
	}


	public void setLoggedIn(boolean b) {
		loggedIn=b;

	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
