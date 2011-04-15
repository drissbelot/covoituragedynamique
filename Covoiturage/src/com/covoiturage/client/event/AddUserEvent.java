package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddUserEvent extends GwtEvent<AddUserEventHandler> {
	public static Type<AddUserEventHandler> TYPE = new Type<AddUserEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddUserEventHandler> getAssociatedType() {

		return TYPE;
	}

	@Override
	protected void dispatch(AddUserEventHandler handler) {
		handler.onAddUser(this);

	}

}
