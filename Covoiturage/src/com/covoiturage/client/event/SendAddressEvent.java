/*
 * 
 */
package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SendAddressEvent.
 */
public class SendAddressEvent extends GwtEvent<SendAddressEventHandler> {
	
	/** The TYPE. */
	public static Type<SendAddressEventHandler> TYPE = new Type<SendAddressEventHandler>();

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public Type<SendAddressEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(SendAddressEventHandler handler) {
		handler.onSendAddress(this);

	}

}
