package com.covoiturage.server.domain;




import javax.persistence.Entity;





import com.covoiturage.server.BCrypt;


@Entity
public class UserInfo extends DatastoreObject{

	
	public String login;

	public String emailAddress;

	private String password;

	private boolean loggedIn = false;

	

	public UserInfo() {
	}

	public UserInfo(String login, String emailAddress,
			String password) {

		this.login = login;
		this.setPassword(password);

		this.emailAddress = emailAddress;
	}

	public boolean getLoggedIn() {
		return loggedIn;
	}




	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public static UserInfo getDefaultUser() {

		return null;
	}

	public void setLoggedIn(boolean b) {
		loggedIn = b;

	}

	public void setPassword(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());

		this.password = hash;
	}

	public String getPassword() {
		return password;
	}


}
