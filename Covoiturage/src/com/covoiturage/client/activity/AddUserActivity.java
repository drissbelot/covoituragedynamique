package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.AddUserEvent;
import com.covoiturage.client.view.AddUserView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;

public class AddUserActivity extends AbstractActivity implements AddUserView.Presenter{


	private final EventBus eventBus;

	AddUserView addUserView;
	private CovoiturageRequestFactory requestFactory;

	private PlaceController placeController;

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
	}

	@SuppressWarnings("unchecked")
	protected void addUser() {
		UserInfoRequest request = requestFactory.userInfoRequest();

		UserInfoProxy newUser = request.create(UserInfoProxy.class);
		newUser.setLogin(addUserView.getLogin());
		newUser.setPassword(addUserView.getPassword());
		Request<Void> createReq = request.persist().using(newUser);

		createReq.fire(new Receiver(){
			@Override
			public void onSuccess(Object response) {
				Window.alert("User "+((UserInfoProxy)response).getLogin()+" added");
				eventBus.fireEvent(new AddUserEvent());
			}
		});




	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
        
        
        addUserView.setPresenter(this);
        panel.setWidget(addUserView.asWidget());
		
	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);

	}

}
