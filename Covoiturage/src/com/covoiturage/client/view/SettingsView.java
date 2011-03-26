package com.covoiturage.client.view;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Widget;

public interface SettingsView {

	public abstract HasClickHandlers getSubmit();

	public abstract Widget asWidget();

	void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }



}
