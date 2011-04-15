package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface FooterView {

	public interface Presenter {
		void goTo(Place place);
	}

	void setPresenter(Presenter presenter);

	IsWidget asWidget();

}
