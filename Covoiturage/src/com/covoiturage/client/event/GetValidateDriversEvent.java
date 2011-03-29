package com.covoiturage.client.event;

import java.util.List;

import com.covoiturage.shared.JourneyProxy;

import com.google.gwt.event.shared.GwtEvent;


public class GetValidateDriversEvent extends GwtEvent<GetValidateDriversEventHandler> {
	public static Type<GetValidateDriversEventHandler> TYPE = new Type<GetValidateDriversEventHandler>();
	private List<String> drivers;
	private List<JourneyProxy> journeys;
	public List<JourneyProxy> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<JourneyProxy> journeys) {
		this.journeys = journeys;
	}

	public GetValidateDriversEvent(List<String> result, List<JourneyProxy> resultJourneys) {
		super();
		this.setDrivers(result);
		this.setJourneys(resultJourneys);
	}

	public com.google.gwt.event.shared.GwtEvent.Type<GetValidateDriversEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(GetValidateDriversEventHandler handler) {
		handler.onGetValidateDrivers(this);
	}

	private void setDrivers(List<String> drivers) {
		this.drivers = drivers;
	}

	public List<String> getDrivers() {
		return drivers;
	}

}