/*
 * 
 */
package com.covoiturage.client.event;

import java.util.List;

import com.covoiturage.shared.JourneyProxy;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GetValidateDriversEvent.
 */
public class GetValidateDriversEvent extends
		GwtEvent<GetValidateDriversEventHandler> {
	
	/** The TYPE. */
	public static Type<GetValidateDriversEventHandler> TYPE = new Type<GetValidateDriversEventHandler>();
	
	/** The drivers. */
	private List<Long> drivers;
	
	/** The journeys. */
	private List<JourneyProxy> journeys;

	/**
	 * Gets the journeys.
	 *
	 * @return the journeys
	 */
	public List<JourneyProxy> getJourneys() {
		return journeys;
	}

	/**
	 * Sets the journeys.
	 *
	 * @param journeys the new journeys
	 */
	public void setJourneys(List<JourneyProxy> journeys) {
		this.journeys = journeys;
	}

	/**
	 * Instantiates a new gets the validate drivers event.
	 *
	 * @param resultDriver the result driver
	 * @param resultJourneys the result journeys
	 */
	public GetValidateDriversEvent(List<Long> resultDriver,
			List<JourneyProxy> resultJourneys) {
		super();
		this.setDrivers(resultDriver);
		this.setJourneys(resultJourneys);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	public com.google.gwt.event.shared.GwtEvent.Type<GetValidateDriversEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	protected void dispatch(GetValidateDriversEventHandler handler) {
		handler.onGetValidateDrivers(this);
	}

	/**
	 * Sets the drivers.
	 *
	 * @param drivers the new drivers
	 */
	private void setDrivers(List<Long> drivers) {
		this.drivers = drivers;
	}

	/**
	 * Gets the drivers.
	 *
	 * @return the drivers
	 */
	public List<Long> getDrivers() {
		return drivers;
	}

}
