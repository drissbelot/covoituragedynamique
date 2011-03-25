package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;

public interface ValidatePassengersView extends IsWidget{

	public abstract Widget asWidget();
    public interface Presenter {
        void goTo(Place place);
    }

	public abstract void setPresenter(
			ValidatePassengersActivity validatePassengersActivity);
	public ListGrid getListGrid();
	public Button getSaveButton();
	public Label getDistanceLabel();
	public Label getDurationLabel();
}