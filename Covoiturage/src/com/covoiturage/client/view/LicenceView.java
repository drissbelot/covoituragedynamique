package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;

public interface LicenceView {

	public interface Presenter {
		void goTo(Place place);
	}

	public RadioButton getRadioAccepted();
	public RadioButton getRadioDenied();
	public HasClickHandlers getNext();
	public void setPresenter(Presenter presenter);
	public IsWidget asWidget();
	
}