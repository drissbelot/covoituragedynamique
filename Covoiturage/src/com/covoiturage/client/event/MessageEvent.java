/*
 * 
 */
package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageEvent.
 */
public class MessageEvent extends GwtEvent<MessageEventHandler> {
	
	/** The TYPE. */
	public static Type<MessageEventHandler> TYPE = new Type<MessageEventHandler>();
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new message event.
	 *
	 * @param message the message
	 */
	public MessageEvent(String message) {
		this.setMessage(message);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<MessageEventHandler> getAssociatedType() {
		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(MessageEventHandler handler) {
		handler.onMessage(this);
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
