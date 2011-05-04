package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface TravelDetailsView extends IsWidget {

	@Override
	public abstract Widget asWidget();

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public Image getPersonalPicture();

	public Image getMapImage();

	public TextField<String> getDepartureField();

	public TextField<String> getArrivalField();

	public TextField<String> getDistanceField();

	public TextField<String> getDurationField();

	public TextField<String> getPlacesField();

	public Label getMarkField();

	public Label getModelField();

	public Label getColorField();

	public Label getComfortField();

	public TabItem getVehiculeTab();

	public void setPersonalPicture(Image personalPicture);

	public void setMapImage(Image image);
}
