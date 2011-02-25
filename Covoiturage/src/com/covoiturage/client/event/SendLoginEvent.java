package com.covoiturage.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SendLoginEvent extends GwtEvent<SendLoginEventHandler> {
  public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
  
  @Override
  public Type<SendLoginEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SendLoginEventHandler handler) {
    handler.onSendLogin(this);
  }
}
