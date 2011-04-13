package com.covoiturage.client.activity;


import java.util.Date;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.event.MessageEvent;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.view.LoginView;

import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;

import com.google.gwt.activity.shared.AbstractActivity;

import com.google.gwt.appengine.channel.client.Channel;
import com.google.gwt.appengine.channel.client.ChannelFactory;
import com.google.gwt.appengine.channel.client.ChannelFactory.ChannelCreatedCallback;
import com.google.gwt.appengine.channel.client.SocketError;
import com.google.gwt.appengine.channel.client.SocketListener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {

	private final EventBus eventBus;
	private final LoginView loginView;
	private UserInfoProxy currentUser;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;
	private UserServiceAsync userService= GWT.create(UserService.class);

	public LoginActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.loginView = clientFactory.getLoginView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		loginView.getSendLoginButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				login();
				
			}
		});
		loginView.getAddUserButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				goTo(new AddUserPlace(null));
			}
		});
	} 

	private void login(){
		
		userService.login(loginView.getLogin(), loginView.getPassword(), new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				String sessionID =result;
				final long DURATION = 1000 * 60 * 2;
				Date expires = new Date(System.currentTimeMillis() + DURATION);
				Cookies.setCookie("sid", sessionID, expires, null, "/", false);
				userService.getUser(new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						UserInfoRequest request = requestFactory.userInfoRequest();
						Request<UserInfoProxy> createReq = request.findUserInfo(result);
						createReq.fire(new Receiver<UserInfoProxy>() {

							@Override
							public void onSuccess(UserInfoProxy response) {
								currentUser =response;
								if(currentUser!=null && currentUser.getLoggedIn()) {
									UserInfoDetailsRequest requestDetails = requestFactory.userInfoDetailsRequest();
									Request<UserInfoDetailsProxy> createReqDatails=requestDetails.channel(currentUser.getId());
									createReqDatails.fire(new Receiver<UserInfoDetailsProxy>() {
										@Override
										public void onSuccess(UserInfoDetailsProxy response) {
											eventBus.fireEvent(new SendLoginEvent(currentUser, response));
											
											ChannelFactory.createChannel(response.getChannelId(), new ChannelCreatedCallback() {
												  @Override
												  public void onChannelCreated(Channel channel) {
												    channel.open(new SocketListener() {
												      @Override
												      public void onOpen() {
												        
												      }
												      @Override
												      public void onMessage(String message) {
												    	  eventBus.fireEvent(new MessageEvent(message));
												      
												      }
												      @Override
												      public void onError(SocketError error) {
												        
												      }
												      @Override
												      public void onClose() {
												        
												      }
												    });
												  }
												});
									
											
										}
									});
									
									goTo(new MapPlace(null));
									
								} else {
									Window.alert("Veuillez vous identifiez");
								}
								
							}
						});
						
					}
					
				});
		
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		bind();
		loginView.setPresenter(this);
		containerWidget.setWidget(loginView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}

}