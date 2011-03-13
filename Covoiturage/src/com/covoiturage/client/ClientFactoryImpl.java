package com.covoiturage.client;

import com.covoiturage.client.view.AddUserView;
import com.covoiturage.client.view.AddUserViewImpl;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.client.view.LoginViewImpl;
import com.covoiturage.client.view.MapView;
import com.covoiturage.client.view.MapViewImpl;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.client.view.ValidatePassengersViewImpl;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;


public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final LoginView loginView = new LoginViewImpl();
    private final MapView mapView = new MapViewImpl();
    private final AddUserView addUserView = new AddUserViewImpl();
    private final ValidatePassengersView validatePassengersView = new ValidatePassengersViewImpl();
    private final CovoiturageRequestFactory requestFactory = GWT.create(CovoiturageRequestFactory.class);
    
    
    public CovoiturageRequestFactory getRequestFactory() {
		return requestFactory;
	}


	public ClientFactoryImpl() {
        requestFactory.initialize(eventBus);

      }

    
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public LoginView getLoginView() {
		return loginView;
	}

	@Override
	public MapView getMapView() {
		return mapView;
	}

	@Override
	public AddUserView getAddUserView() {
		return addUserView;
	}

	@Override
	public ValidatePassengersView getValidatePassengersView() {
		return validatePassengersView;
	}





}
