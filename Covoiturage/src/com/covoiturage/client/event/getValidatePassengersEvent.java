package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;


public class getValidatePassengersEvent extends GwtEvent<getValidatePassengersEventHandler> {
	public static Type<getValidatePassengersEventHandler> TYPE = new Type<getValidatePassengersEventHandler>();

	public com.google.gwt.event.shared.GwtEvent.Type<getValidatePassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(getValidatePassengersEventHandler handler) {
		handler.onGetValidatePassengers(this);
	}

}
