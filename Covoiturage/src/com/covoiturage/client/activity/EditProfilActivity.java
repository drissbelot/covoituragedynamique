package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.view.EditProfilView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class EditProfilActivity extends AbstractActivity implements EditProfilView.Presenter{
	
	private final EventBus eventBus;
	EditProfilView EditProfilView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	public EditProfilActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.EditProfilView = clientFactory.getEditProfilView();
		this.placeController = clientFactory.getPlaceController();
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		EditProfilView.setPresenter(this);
        panel.setWidget(EditProfilView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
