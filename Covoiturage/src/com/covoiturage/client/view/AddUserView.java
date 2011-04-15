package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;

public interface AddUserView extends IsWidget {

	public abstract HasClickHandlers getAddUserButton();

	public abstract Widget asWidget();

	public abstract HasClickHandlers getAddButton();

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public abstract SuggestBox getMakeSuggestTextBox();

	public abstract SuggestBox getModelSuggestTextBox();

	public TextField<String> getFirstName();

	public TextField<String> getLastName();

	public TextField<String> getEmailAddress();

	public abstract ListBox getLanguage();

	public TextField<String> getPassword();

	public TextField<String> getLogin();

}