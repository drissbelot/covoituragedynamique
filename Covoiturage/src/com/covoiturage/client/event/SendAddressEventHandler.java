package com.covoiturage.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface SendAddressEventHandler extends EventHandler {
	void onSendAddress(SendAddressEvent event);
}
