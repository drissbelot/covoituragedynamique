/*
 * 
 */
package com.covoiturage.client.event;

import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SendLoginEvent.
 */
public class SendLoginEvent extends GwtEvent<SendLoginEventHandler> {
	
	/** The TYPE. */
	public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
	
	/** The current user. */
	private UserInfoProxy currentUser;
	
	/** The user details. */
	private UserInfoDetailsProxy userDetails;

	/**
	 * Instantiates a new send login event.
	 *
	 * @param currentUser the current user
	 * @param userDetails the user details
	 */
	public SendLoginEvent(UserInfoProxy currentUser,
			UserInfoDetailsProxy userDetails) {
		super();
		this.currentUser = currentUser;
		this.userDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public Type<SendLoginEventHandler> getAssociatedType() {
		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(SendLoginEventHandler handler) {
		handler.onSendLogin(this);
	}

	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	public UserInfoProxy getCurrentUser() {
		return currentUser;
	}

	/**
	 * Gets the user details.
	 *
	 * @return the user details
	 */
	public UserInfoDetailsProxy getUserDetails() {
		return userDetails;
	}

}
