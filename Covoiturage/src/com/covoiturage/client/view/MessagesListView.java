/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessagesListView.
 */
public interface MessagesListView extends IsWidget {
	
	/**
	 * Sets the presenter.
	 *
	 * @param presenter the new presenter
	 */
	void setPresenter(Presenter presenter);

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
	 * Gets the list grid.
	 *
	 * @return the list grid
	 */
	public Grid<BaseModelData> getListGrid();

	/**
	 * Gets the delete button.
	 *
	 * @return the delete button
	 */
	public Button getDeleteButton();

	/**
	 * Gets the accept button.
	 *
	 * @return the accept button
	 */
	public ColumnConfig getAcceptButton();
}
