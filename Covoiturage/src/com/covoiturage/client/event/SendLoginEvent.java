package com.covoiturage.client.event;


import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.event.shared.GwtEvent;

public class SendLoginEvent extends GwtEvent<SendLoginEventHandler> {
  public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
  private UserInfoProxy currentUser;
  public SendLoginEvent(UserInfoProxy currentUser) {
	  super();
	this.currentUser= currentUser;
}

@Override
  public Type<SendLoginEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SendLoginEventHandler handler) {
    handler.onSendLogin(this);
  }
  
  public UserInfoProxy getCurrentUser(){
      return currentUser;
  }

}
