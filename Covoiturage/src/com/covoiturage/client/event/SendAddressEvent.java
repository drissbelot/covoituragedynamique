package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SendAddressEvent extends GwtEvent<SendAddressEventHandler> {
	public static Type<SendAddressEventHandler> TYPE = new Type<SendAddressEventHandler>();

	@Override
	public Type<SendAddressEventHandler> getAssociatedType() {

		return TYPE;
	}

	@Override
	protected void dispatch(SendAddressEventHandler handler) {
		handler.onSendAddress(this);

	}

}
