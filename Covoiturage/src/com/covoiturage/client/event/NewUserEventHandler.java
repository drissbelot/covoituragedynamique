package com.covoiturage.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface NewUserEventHandler extends EventHandler{
	 void onNewUser(NewUserEvent event);
}
