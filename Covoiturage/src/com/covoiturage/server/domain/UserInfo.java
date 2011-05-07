/*
 * 
 */
package com.covoiturage.server.domain;




import javax.persistence.Entity;





import com.covoiturage.server.BCrypt;


// TODO: Auto-generated Javadoc
/**
 * The Class UserInfo.
 */
@Entity
public class UserInfo extends DatastoreObject{

	
	/** The login. */
	public String login;

	/** The email address. */
	public String emailAddress;

	/** The password. */
	private String password;

	/** The logged in. */
	private boolean loggedIn = false;

	

	/**
	 * Instantiates a new user info.
	 */
	public UserInfo() {
	}

	/**
	 * Instantiates a new user info.
	 *
	 * @param login the login
	 * @param emailAddress the email address
	 * @param password the password
	 */
	public UserInfo(String login, String emailAddress,
			String password) {

		this.login = login;
		this.setPassword(password);

		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the logged in.
	 *
	 * @return the logged in
	 */
	public boolean getLoggedIn() {
		return loggedIn;
	}




	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the default user.
	 *
	 * @return the default user
	 */
	public static UserInfo getDefaultUser() {

		return null;
	}

	/**
	 * Sets the logged in.
	 *
	 * @param b the new logged in
	 */
	public void setLoggedIn(boolean b) {
		loggedIn = b;

	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());

		this.password = hash;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


}
