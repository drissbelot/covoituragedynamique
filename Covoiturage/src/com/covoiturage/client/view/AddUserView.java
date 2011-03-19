package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;

public interface AddUserView extends IsWidget{

	public abstract HasClickHandlers getAddUserButton();

	public abstract Widget asWidget();

	public abstract HasClickHandlers getAddButton();

	public abstract String getPassword();

	public abstract String getLogin();
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }

	public abstract SuggestBox getMakeSuggestTextBox();

	public abstract SuggestBox getModelSuggestTextBox();
	
	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getEmailAddress();

	public void setEmailAddress(String emailAdress);

}