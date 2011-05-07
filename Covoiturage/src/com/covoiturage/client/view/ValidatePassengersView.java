/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValidatePassengersView.
 */
public interface ValidatePassengersView extends IsWidget {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public abstract Widget asWidget();

	/**
	 * The Interface Presenter.
	 */
	public interface Presenter {
		
		/**
		 * Go to.
		 *
		 * @param place the place
		 */
		void goTo(Place place);
	}

	/**
	 * Sets the presenter.
	 *
	 * @param validatePassengersActivity the new presenter
	 */
	public abstract void setPresenter(
			ValidatePassengersActivity validatePassengersActivity);

	/**
	 * Gets the list grid.
	 *
	 * @return the list grid
	 */
	public Grid<BaseModelData> getListGrid();

	/**
	 * Gets the expander.
	 *
	 * @return the expander
	 */
	public WidgetExpander<BaseModelData> getExpander();

}