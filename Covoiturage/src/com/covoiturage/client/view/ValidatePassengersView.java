package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.data.BaseModelData;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;


public interface ValidatePassengersView extends IsWidget{

	public abstract Widget asWidget();
    public interface Presenter {
        void goTo(Place place);
    }

	public abstract void setPresenter(
			ValidatePassengersActivity validatePassengersActivity);
	public Grid<BaseModelData> getListGrid();
	public Button getSaveButton();
	public Label getDistanceLabel();
	public Label getDurationLabel();
	public WidgetExpander<BaseModelData> getExpander();
}