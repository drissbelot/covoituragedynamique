package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geocode.DirectionsPanel;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.datepicker.client.DatePicker;

public interface MapView extends IsWidget{

	public abstract RadioButton getPassengerRadioButton();

	public abstract RadioButton getDriverRadioButton();

	public abstract DatePicker getDateOfJourney();

	public abstract HasClickHandlers getSendAddressButton();

	public abstract String getOriginAddress();

	public abstract String getDestinationAddress();

	public abstract MapWidget getMap();

	public abstract DirectionsPanel getDirectionsPanel();

	public abstract HasClickHandlers getSaveJourneyButton();

	public abstract float getDistanceMax();

	public abstract DockLayoutPanel getMapDecorator();
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }

}