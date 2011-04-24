package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.IsWidget;

public interface FooterView {

	public interface Presenter {
		void goTo(Place place);
	}

	void setPresenter(Presenter presenter);

	IsWidget asWidget();

	public Anchor getAnchorfr();

	public Anchor getAnchornl();

	public Anchor getAnchoren();

	public Anchor getAnchorit();

	public Anchor getAnchorch();
}
