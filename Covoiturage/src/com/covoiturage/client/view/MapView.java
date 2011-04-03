package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.smartgwt.client.widgets.DateChooser;
import com.smartgwt.client.widgets.form.fields.TimeItem;

public interface MapView extends IsWidget{

	public abstract RadioButton getPassengerRadioButton();

	public abstract RadioButton getDriverRadioButton();

	public abstract DateChooser getDateOfJourney();

	public abstract HasClickHandlers getSendAddressButton();

	public abstract SuggestBox getOriginAddress();

	public abstract SuggestBox getDestinationAddress();

	public abstract MapWidget getMap();

	public abstract HorizontalPanel getDirectionsPanel();

	public abstract HasClickHandlers getSaveJourneyButton();

	public abstract float getDistanceMax();

	public abstract FlowPanel getMapDecorator();
	
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }

	public void setOriginAddress(SuggestBox suggestBox);

	public void setDestinationAddress(String destinationAddress) ;
	
	public TimeItem getDepartureStartTime();
	public TimeItem getDepartureEndTime();

	public TimeItem getArrivalTime();
	
	


}