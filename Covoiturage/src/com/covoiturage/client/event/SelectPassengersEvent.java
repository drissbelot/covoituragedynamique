package com.covoiturage.client.event;

import java.util.Set;

import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.event.shared.GwtEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;


public class SelectPassengersEvent extends GwtEvent<SelectPassengersEventHandler> {
	public static Type<SelectPassengersEventHandler> TYPE = new Type<SelectPassengersEventHandler>();
	private ListGridRecord[] passengers;
	public SelectPassengersEvent(ListGridRecord[] listGridRecords) {
		super();
		this.setPassengers(listGridRecords);
	}

	public Type<SelectPassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(SelectPassengersEventHandler handler) {
		handler.onSelectPassengers(this);
	}

	private void setPassengers(ListGridRecord[] listGridRecords) {
		this.passengers = listGridRecords;
	}

	public ListGridRecord[] getPassengers() {
		return passengers;
	}



}
