package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface MenuView extends IsWidget {
	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public Label getSettingsLabel();

	public Label getMapLabel();

	public Label getHistoryLabel();

	public Label getMessagesLabel();

	public MenuViewConstants getConstants();
}
