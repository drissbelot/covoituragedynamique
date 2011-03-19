package com.covoiturage.client.event;

import java.util.Set;

import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.event.shared.GwtEvent;


public class SelectPassengersEvent extends GwtEvent<SelectPassengersEventHandler> {
	public static Type<SelectPassengersEventHandler> TYPE = new Type<SelectPassengersEventHandler>();
	private Set<SimpleTravelProxy> passengers;
	public SelectPassengersEvent(Set<SimpleTravelProxy> set) {
		super();
		this.setPassengers(set);
	}

	public Type<SelectPassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(SelectPassengersEventHandler handler) {
		handler.onSelectPassengers(this);
	}

	private void setPassengers(Set<SimpleTravelProxy>passengers) {
		this.passengers = passengers;
	}

	public Set<SimpleTravelProxy> getPassengers() {
		return passengers;
	}



}
