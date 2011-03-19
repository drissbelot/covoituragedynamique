package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.shared.SimpleTravelProxy;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public interface ValidatePassengersView extends IsWidget{

	public abstract Widget asWidget();
    public interface Presenter {
        void goTo(Place place);
    }
	public abstract HasData<SimpleTravelProxy> getTable();
	public abstract void setPresenter(
			ValidatePassengersActivity validatePassengersActivity);
	public CellTable<SimpleTravelProxy> getPassengersCellTable();
	public MultiSelectionModel<SimpleTravelProxy> getSelectionModel();
}