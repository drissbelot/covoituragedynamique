package com.covoiturage.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface SelectPassengersEventHandler extends EventHandler{

	void onSelectPassengers(SelectPassengersEvent selectPassengersEvent);

}
