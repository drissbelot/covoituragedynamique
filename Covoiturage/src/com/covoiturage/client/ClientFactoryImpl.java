package com.covoiturage.client;

import com.covoiturage.client.view.AddUserView;
import com.covoiturage.client.view.AddUserViewImpl;
import com.covoiturage.client.view.EditProfilView;
import com.covoiturage.client.view.EditProfilViewImpl;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.client.view.LoginViewImpl;
import com.covoiturage.client.view.MapView;
import com.covoiturage.client.view.MapViewImpl;
import com.covoiturage.client.view.MenuView;
import com.covoiturage.client.view.MenuViewImpl;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.client.view.ValidatePassengersViewImpl;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;


public class ClientFactoryImpl implements ClientFactory {
    private EventBus eventBus;
    private PlaceController placeController;
    private LoginView loginView;
    private CovoiturageRequestFactory requestFactory;
    
    private MapView mapView;
    private AddUserView addUserView;
    private EditProfilView EditProfilView;
    private ValidatePassengersView validatePassengersView ;
    private MenuView menuView; 
    
    
    public CovoiturageRequestFactory getRequestFactory() {
		return requestFactory;
	}


	public ClientFactoryImpl() {
		GWT.runAsync(new RunAsyncCallback() {
	        public void onFailure(Throwable caught) {
	          Window.alert("Code download failed");
	        }

	        public void onSuccess() {
	        	eventBus = new SimpleEventBus();
	        	placeController = new PlaceController(eventBus);
	        	loginView = new LoginViewImpl();
	        	requestFactory = GWT.create(CovoiturageRequestFactory.class);
	        }
	      });
		
		
		
        requestFactory.initialize(eventBus);

        GWT.runAsync(new RunAsyncCallback() {
	        public void onFailure(Throwable caught) {
	          Window.alert("Code download failed");
	        }

	        public void onSuccess() {
	        	mapView = new MapViewImpl();
	    		addUserView = new AddUserViewImpl();
	    		EditProfilView = new EditProfilViewImpl();
	    		validatePassengersView = new ValidatePassengersViewImpl();
	    		menuView = new MenuViewImpl();
	        }
	      });
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


	@Override
	public EditProfilView getEditProfilView() {
		
		return EditProfilView;
	}


	@Override
	public MenuView getMenuView() {

		return menuView ;
	}





}
