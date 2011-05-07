/*
 * 
 */
package com.covoiturage.client.event;

import java.util.List;

import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GetValidatePassengersEvent.
 */
public class GetValidatePassengersEvent extends
		GwtEvent<GetValidatePassengersEventHandler> {
	
	/** The TYPE. */
	public static Type<GetValidatePassengersEventHandler> TYPE = new Type<GetValidatePassengersEventHandler>();
	
	/** The passengers. */
	private List<Long> passengers;
	
	/** The simple travels. */
	private List<SimpleTravelProxy> simpleTravels;

	/**
	 * Gets the simple travels.
	 *
	 * @return the simple travels
	 */
	public List<SimpleTravelProxy> getSimpleTravels() {
		return simpleTravels;
	}

	/**
	 * Sets the simple travels.
	 *
	 * @param simpleTravels the new simple travels
	 */
	public void setSimpleTravels(List<SimpleTravelProxy> simpleTravels) {
		this.simpleTravels = simpleTravels;
	}

	/**
	 * Instantiates a new gets the validate passengers event.
	 *
	 * @param result the result
	 * @param resultSimpleTravel the result simple travel
	 */
	public GetValidatePassengersEvent(List<Long> result,
			List<SimpleTravelProxy> resultSimpleTravel) {
		super();
		this.setPassengers(result);
		this.setSimpleTravels(resultSimpleTravel);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	public com.google.gwt.event.shared.GwtEvent.Type<GetValidatePassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	protected void dispatch(GetValidatePassengersEventHandler handler) {
		handler.onGetValidatePassengers(this);
	}

	/**
	 * Sets the passengers.
	 *
	 * @param passengers the new passengers
	 */
	private void setPassengers(List<Long> passengers) {
		this.passengers = passengers;
	}

	/**
	 * Gets the passengers.
	 *
	 * @return the passengers
	 */
	public List<Long> getPassengers() {
		return passengers;
	}

}
