package com.covoiturage.client.event;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.event.shared.GwtEvent;



public class SelectPassengersEvent extends GwtEvent<SelectPassengersEventHandler> {
	public static Type<SelectPassengersEventHandler> TYPE = new Type<SelectPassengersEventHandler>();
	private List<BaseModelData> passengers;
	public SelectPassengersEvent(List<BaseModelData> listGridRecords) {
		super();
		this.setPassengers(listGridRecords);
	}

	public Type<SelectPassengersEventHandler> getAssociatedType() {

		return TYPE;
	}

	protected void dispatch(SelectPassengersEventHandler handler) {
		handler.onSelectPassengers(this);
	}

	private void setPassengers(List<BaseModelData> listGridRecords) {
		this.passengers = listGridRecords;
	}

	public List<BaseModelData> getPassengers() {
		return passengers;
	}



}
