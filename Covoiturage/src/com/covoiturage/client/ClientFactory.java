/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.view.AddUserView;
import com.covoiturage.client.view.FooterView;
import com.covoiturage.client.view.HeaderView;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.client.view.MapView;
import com.covoiturage.client.view.MenuView;
import com.covoiturage.client.view.MessageDetailsView;
import com.covoiturage.client.view.MessagesListView;
import com.covoiturage.client.view.ReplyMessageView;
import com.covoiturage.client.view.SettingsView;
import com.covoiturage.client.view.TravelDetailsView;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Client objects.
 */
public interface ClientFactory {

	/**
	 * Gets the event bus.
	 * 
	 * @return the event bus
	 */
	EventBus getEventBus();

	/**
	 * Gets the place controller.
	 * 
	 * @return the place controller
	 */
	PlaceController getPlaceController();

	/**
	 * Gets the login view.
	 * 
	 * @return the login view
	 */
	LoginView getLoginView();

	/**
	 * Gets the map view.
	 * 
	 * @return the map view
	 */
	MapView getMapView();

	/**
	 * Gets the adds the user view.
	 * 
	 * @return the adds the user view
	 */
	AddUserView getAddUserView();

	/**
	 * Gets the validate passengers view.
	 * 
	 * @return the validate passengers view
	 */
	ValidatePassengersView getValidatePassengersView();

	/**
	 * Gets the request factory.
	 * 
	 * @return the request factory
	 */
	CovoiturageRequestFactory getRequestFactory();

	/**
	 * Gets the settings view.
	 * 
	 * @return the settings view
	 */
	SettingsView getSettingsView();

	/**
	 * Gets the menu view.
	 * 
	 * @return the menu view
	 */
	MenuView getMenuView();

	/**
	 * Gets the header view.
	 * 
	 * @return the header view
	 */
	HeaderView getHeaderView();

	/**
	 * Gets the footer view.
	 * 
	 * @return the footer view
	 */
	FooterView getFooterView();

	/**
	 * Gets the history view.
	 * 
	 * @return the history view
	 */
	HistoryView getHistoryView();

	/**
	 * Gets the messages list view.
	 * 
	 * @return the messages list view
	 */
	MessagesListView getMessagesListView();

	/**
	 * Gets the message details view.
	 * 
	 * @return the message details view
	 */
	MessageDetailsView getMessageDetailsView();

	/**
	 * Gets the reply message view.
	 * 
	 * @return the reply message view
	 */
	ReplyMessageView getReplyMessageView();

	/**
	 * Gets the travel details view.
	 * 
	 * @return the travel details view
	 */
	TravelDetailsView getTravelDetailsView();
}