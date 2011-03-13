package com.covoiturage.client;


import com.covoiturage.client.activity.AddUserActivity;
import com.covoiturage.client.activity.LoginActivity;
import com.covoiturage.client.activity.MapActivity;
import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper{
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace)
            return new LoginActivity(clientFactory);
        else if(place instanceof AddUserPlace)
                return new AddUserActivity(clientFactory);
        else if(place instanceof MapPlace)
                return new MapActivity(clientFactory);
        else if(place instanceof ValidatePassengersPlace)
            return new ValidatePassengersActivity(clientFactory);
        return null;
    }
}