/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

// TODO: Auto-generated Javadoc
/**
 * The Interface HistoryView.
 */
public interface HistoryView {

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
	 * @param presenter the new presenter
	 */
	void setPresenter(Presenter presenter);

	/**
	 * As widget.
	 *
	 * @return the checks if is widget
	 */
	IsWidget asWidget();

	/**
	 * Gets the list grid.
	 *
	 * @return the list grid
	 */
	public Grid<BaseModelData> getListGrid();
}
