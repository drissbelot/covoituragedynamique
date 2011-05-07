/*
 * 
 */
package com.covoiturage.client.event;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.event.shared.GwtEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectPassengersEvent.
 */
public class SelectPassengersEvent extends
		GwtEvent<SelectPassengersEventHandler> {
	
	/** The TYPE. */
	public static Type<SelectPassengersEventHandler> TYPE = new Type<SelectPassengersEventHandler>();
	
	/** The passengers. */
	private List<BaseModelData> passengers;

	/**
	 * Instantiates a new select passengers event.
	 *
	 * @param listGridRecords the list grid records
	 */
	public SelectPassengersEvent(List<BaseModelData> listGridRecords) {
		super();
		this.setPassengers(listGridRecords);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
	 */
	public Type<SelectPassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
	 */
	protected void dispatch(SelectPassengersEventHandler handler) {
		handler.onSelectPassengers(this);
	}

	/**
	 * Sets the passengers.
	 *
	 * @param listGridRecords the new passengers
	 */
	private void setPassengers(List<BaseModelData> listGridRecords) {
		this.passengers = listGridRecords;
	}

	/**
	 * Gets the passengers.
	 *
	 * @return the passengers
	 */
	public List<BaseModelData> getPassengers() {
		return passengers;
	}

}
