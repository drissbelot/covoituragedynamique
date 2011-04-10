package com.covoiturage.client.view;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public interface SettingsView {

	public abstract HasClickHandlers getSubmitButton();

	public abstract Widget asWidget();

	void setPresenter(Presenter presenter);

    public interface Presenter {
        void goTo(Place place);
    }
    public TextBox getFirstName();

	public TextBox getLastName();

	public PasswordTextBox getNewPassword();

	public ListBox getLanguage();
	public TextBox getEmailAddress();

}
