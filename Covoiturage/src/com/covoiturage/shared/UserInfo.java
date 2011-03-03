package com.covoiturage.shared;

import java.io.Serializable;




@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	public String id;
	public String login;
	public String emailAddress;
	  private String loginUrl;
	  private String logoutUrl;

	private boolean loggedIn = false;



	public UserInfo() {}

	public UserInfo(String id, String login, String emailAddress) {
		this.id = id;
		this.login = login;
		
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
	

	public static Object getDefaultUser() {

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

	public static UserInfo toDTO(Object defaultUser) {
		// TODO Auto-generated method stub
		return null;
	}
}
