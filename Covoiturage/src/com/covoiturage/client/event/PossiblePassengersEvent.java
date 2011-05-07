/*
 * 
 */
package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class PossiblePassengersEvent.
 */
public class PossiblePassengersEvent extends
		GwtEvent<PossiblePassengersEventHandler> {
	
	/** The TYPE. */
	public static Type<PossiblePassengersEventHandler> TYPE = new Type<PossiblePassengersEventHandler>();
	
	/** The distance. */
	private double distance;
	
	/** The duration. */
	private double duration;

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Instantiates a new possible passengers event.
	 *
	 * @param distance the distance
	 * @param duration the duration
	 */
	public PossiblePassengersEvent(double distance, double duration) {
		super();
		this.distance = distance;
		this.duration = duration;

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	@Override
	public Type<PossiblePassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	@Override
	protected void dispatch(PossiblePassengersEventHandler handler) {
		handler.onPossiblePassengers(this);

	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

}
