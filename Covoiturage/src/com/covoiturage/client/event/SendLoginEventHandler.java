package com.covoiturage.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface SendLoginEventHandler extends EventHandler {
  void onSendLogin(SendLoginEvent event);
}
