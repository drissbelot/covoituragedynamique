package com.covoiturage.client.view;


import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;



public interface MessagesListView extends IsWidget{
    void setPresenter(Presenter presenter);
	public interface Presenter {
	    void goTo(Place place);
	}
	public Grid<BaseModelData> getListGrid();
	public Button getDeleteButton();
	public ColumnConfig getAcceptButton();
}
