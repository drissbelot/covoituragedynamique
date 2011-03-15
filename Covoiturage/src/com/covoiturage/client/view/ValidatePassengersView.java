package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

public interface ValidatePassengersView extends IsWidget{

	public abstract Widget asWidget();
    public interface Presenter {
        void goTo(Place place);
    }
	public abstract HasData<UserInfoProxy> getTable();
	public abstract void setPresenter(
			ValidatePassengersActivity validatePassengersActivity);
}