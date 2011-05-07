/*
 * 
 */
package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserEvent.
 */
public class AddUserEvent extends GwtEvent<AddUserEventHandler> {
	
	/** The TYPE. */
	public static Type<AddUserEventHandler> TYPE = new Type<AddUserEventHandler>();

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddUserEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(AddUserEventHandler handler) {
		handler.onAddUser(this);

	}

}
