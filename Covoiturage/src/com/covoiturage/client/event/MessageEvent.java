package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class MessageEvent extends GwtEvent<MessageEventHandler> {
	public static Type<MessageEventHandler> TYPE = new Type<MessageEventHandler>();
	private String message;

	public MessageEvent(String message) {
		this.setMessage(message);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<MessageEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MessageEventHandler handler) {
		handler.onMessage(this);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
