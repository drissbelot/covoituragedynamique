package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NewUserEvent extends GwtEvent<NewUserEventHandler> {
	public static Type<NewUserEventHandler> TYPE = new Type<NewUserEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NewUserEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NewUserEventHandler handler) {
		handler.onNewUser(this);

	}

}
