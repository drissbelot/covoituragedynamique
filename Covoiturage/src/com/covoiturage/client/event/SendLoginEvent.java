package com.covoiturage.client.event;


import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.event.shared.GwtEvent;

public class SendLoginEvent extends GwtEvent<SendLoginEventHandler> {
  public static Type<SendLoginEventHandler> TYPE = new Type<SendLoginEventHandler>();
  private UserInfoProxy currentUser;
  private UserInfoDetailsProxy userDetails;
  public SendLoginEvent(UserInfoProxy currentUser, UserInfoDetailsProxy userDetails) {
	  super();
	this.currentUser= currentUser;
	this.userDetails=userDetails;
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
  public UserInfoDetailsProxy getUserDetails(){
	  return userDetails;
  }

}
