/*
 * 
 */
package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class NewUserEvent.
 */
public class NewUserEvent extends GwtEvent<NewUserEventHandler> {
	
	/** The TYPE. */
	public static Type<NewUserEventHandler> TYPE = new Type<NewUserEventHandler>();

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NewUserEventHandler> getAssociatedType() {
		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(NewUserEventHandler handler) {
		handler.onNewUser(this);

	}

}
