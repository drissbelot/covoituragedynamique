package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

import com.smartgwt.client.widgets.Label;

public interface MenuView extends IsWidget{
    void setPresenter(Presenter presenter);
	public interface Presenter {
	    void goTo(Place place);
	}
	public HasClickHandlers getSettingsLabel();
	public HasClickHandlers getMapLabel();

}
