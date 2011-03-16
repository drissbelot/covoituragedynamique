package com.covoiturage.client.event;

import java.util.List;

import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.event.shared.GwtEvent;


public class GetValidatePassengersEvent extends GwtEvent<GetValidatePassengersEventHandler> {
	public static Type<GetValidatePassengersEventHandler> TYPE = new Type<GetValidatePassengersEventHandler>();
	private List<String> passengers;
	private List<SimpleTravelProxy> simpleTravels;
	public List<SimpleTravelProxy> getSimpleTravels() {
		return simpleTravels;
	}

	public void setSimpleTravels(List<SimpleTravelProxy> simpleTravels) {
		this.simpleTravels = simpleTravels;
	}

	public GetValidatePassengersEvent(List<String> result, List<SimpleTravelProxy> resultSimpleTravel) {
		super();
		this.setPassengers(result);
		this.setSimpleTravels(resultSimpleTravel);
	}

	public com.google.gwt.event.shared.GwtEvent.Type<GetValidatePassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(GetValidatePassengersEventHandler handler) {
		handler.onGetValidatePassengers(this);
	}

	private void setPassengers(List<String> passengers) {
		this.passengers = passengers;
	}

	public List<String> getPassengers() {
		return passengers;
	}

}