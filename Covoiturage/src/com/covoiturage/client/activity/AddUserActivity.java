package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.VehicleService;
import com.covoiturage.client.VehicleServiceAsync;
import com.covoiturage.client.event.AddUserEvent;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.AddUserView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;

import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class AddUserActivity extends AbstractActivity implements AddUserView.Presenter{

	private final EventBus eventBus;
	AddUserView addUserView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;
	private VehicleServiceAsync vehiculeService= GWT.create(VehicleService.class);

	public AddUserActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.addUserView = clientFactory.getAddUserView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		addUserView.getAddButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				addUser();
			}
		});
		addUserView.getMakeSuggestTextBox().getTextBox().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {

				vehiculeService.getMakes(addUserView.getMakeSuggestTextBox().getTextBox().getText() , new AsyncCallback<List<String>>() {
					@Override
					public void onSuccess(List<String> result) {

						MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) addUserView.getMakeSuggestTextBox().getSuggestOracle();  
						for (String string : result) {
							oracle.add(string);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
		});
		addUserView.getModelSuggestTextBox().getTextBox().addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {

				vehiculeService.getModels(addUserView.getModelSuggestTextBox().getTextBox().getText(),addUserView.getMakeSuggestTextBox().getText() , new AsyncCallback<List<String>>() {
					@Override
					public void onSuccess(List<String> result) {

						MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) addUserView.getModelSuggestTextBox().getSuggestOracle();  
						for (String string : result) {
							oracle.add(string);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
		});
		
		//TODO nombre de places (c'est dans le fichier)
	}


	protected void addUser() {
		
		final UserInfoRequest request = requestFactory.userInfoRequest();
		final UserInfoProxy newUser = request.create(UserInfoProxy.class);
		newUser.setLogin(addUserView.getLogin().getValue());
		newUser.setPassword(addUserView.getPassword().getValue());
		newUser.setEmailAddress(addUserView.getEmailAddress().getValue());
		
		Request<String> createReq = request.persist().using(newUser);
		createReq.fire(new Receiver<String>() {
			@Override
			public void onSuccess(String response) {
				
						savePassengerDriver(response);
					}
		
					

			
		});
		
	

	}

	protected void savePassengerDriver(String newUser) {
		

			UserInfoDetailsRequest requestDriver = requestFactory.userInfoDetailsRequest();
			UserInfoDetailsProxy newDriver = requestDriver.create(UserInfoDetailsProxy.class);
			newDriver.setUser(newUser);
			newDriver.setFirstName(addUserView.getFirstName().getValue());
			newDriver.setLastName(addUserView.getLastName().getValue());
			newDriver.setMakeOfvehicle(addUserView.getMakeSuggestTextBox().getText());
			newDriver.setModelOfvehicle(addUserView.getModelSuggestTextBox().getText());
			newDriver.setLanguage(addUserView.getLanguage().getItemText(addUserView.getLanguage().getSelectedIndex()));
			newDriver.setMessages(new ArrayList<String>());
			Request<Void> createReqDriver = requestDriver.persist().using(newDriver);

			createReqDriver.fire(new Receiver<Void>() {
				@Override
				public void onSuccess(Void response) {
					eventBus.fireEvent(new AddUserEvent());
					goTo(new LoginPlace(null));
				}
			});
	
		
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		addUserView.setPresenter(this);
		panel.setWidget(addUserView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
