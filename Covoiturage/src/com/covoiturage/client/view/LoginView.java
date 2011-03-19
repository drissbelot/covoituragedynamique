package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoginView extends IsWidget{

	public abstract HasClickHandlers getSendLoginButton();

	public abstract HasClickHandlers getAddUserButton();

	public abstract String getPassword();

	public abstract String getLogin();

    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }

}