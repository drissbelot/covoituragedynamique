package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface ValidatePassengersView extends IsWidget{

	public abstract Widget asWidget();
    public interface Presenter {
        void goTo(Place place);
    }
}