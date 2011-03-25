package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PossiblePassengersEvent extends GwtEvent<PossiblePassengersEventHandler> {
	public static Type<PossiblePassengersEventHandler> TYPE = new Type<PossiblePassengersEventHandler>();
	private double distance;
	private double duration;
	public double getDistance() {
		return distance;
	}

	public PossiblePassengersEvent(double distance, double duration){
		super();
		this.distance=distance;
		this.duration=duration;
		
	}
	
	@Override
	public Type<PossiblePassengersEventHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(PossiblePassengersEventHandler handler) {
		handler.onPossiblePassengers(this);
		
	}


	public double getDuration() {
		return duration;
	}

}
