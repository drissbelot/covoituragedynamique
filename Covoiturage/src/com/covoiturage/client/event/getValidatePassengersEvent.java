package com.covoiturage.client.event;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;


public class getValidatePassengersEvent extends GwtEvent<getValidatePassengersEventHandler> {
	public static Type<getValidatePassengersEventHandler> TYPE = new Type<getValidatePassengersEventHandler>();
	private List<String> passengers;
	public getValidatePassengersEvent(List<String> result) {
		super();
		this.setPassengers(result);
	}

	public com.google.gwt.event.shared.GwtEvent.Type<getValidatePassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(getValidatePassengersEventHandler handler) {
		handler.onGetValidatePassengers(this);
	}

	private void setPassengers(List<String> passengers) {
		this.passengers = passengers;
	}

	public List<String> getPassengers() {
		return passengers;
	}

}
