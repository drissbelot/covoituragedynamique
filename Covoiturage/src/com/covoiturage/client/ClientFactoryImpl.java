/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.view.AddUserView;
import com.covoiturage.client.view.AddUserViewImpl;
import com.covoiturage.client.view.FooterView;
import com.covoiturage.client.view.FooterViewImpl;
import com.covoiturage.client.view.HeaderView;
import com.covoiturage.client.view.HeaderViewImpl;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.client.view.HistoryViewImpl;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.client.view.LoginViewImpl;
import com.covoiturage.client.view.MapView;
import com.covoiturage.client.view.MapViewImpl;
import com.covoiturage.client.view.MenuView;
import com.covoiturage.client.view.MenuViewImpl;
import com.covoiturage.client.view.MessageDetailsView;
import com.covoiturage.client.view.MessageDetailsViewImpl;
import com.covoiturage.client.view.MessagesListView;
import com.covoiturage.client.view.MessagesListViewImpl;
import com.covoiturage.client.view.ReplyMessageView;
import com.covoiturage.client.view.ReplyMessageViewImpl;
import com.covoiturage.client.view.SettingsView;
import com.covoiturage.client.view.SettingsViewImpl;
import com.covoiturage.client.view.TravelDetailsView;
import com.covoiturage.client.view.TravelDetailsViewImpl;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.client.view.ValidatePassengersViewImpl;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientFactoryImpl.
 */
public class ClientFactoryImpl implements ClientFactory {

	/** The event bus. */
	private final EventBus eventBus = new SimpleEventBus();

	/** The place controller. */
	private final PlaceController placeController = new PlaceController(
			eventBus);

	/** The login view. */
	private final LoginView loginView = new LoginViewImpl();

	/** The map view. */
	private final MapView mapView = new MapViewImpl();

	/** The add user view. */
	private final AddUserView addUserView = new AddUserViewImpl();

	/** The Edit profil view. */
	private final SettingsView settingsView = new SettingsViewImpl();

	/** The validate passengers view. */
	private final ValidatePassengersView validatePassengersView = new ValidatePassengersViewImpl();

	/** The menu view. */
	private final MenuView menuView = new MenuViewImpl();

	/** The header view. */
	private final HeaderView headerView = new HeaderViewImpl();

	/** The footer view. */
	private final FooterView footerView = new FooterViewImpl();

	/** The history view. */
	private final HistoryView historyView = new HistoryViewImpl();

	/** The messages list view. */
	private final MessagesListView messagesListView = new MessagesListViewImpl();

	/** The message details view. */
	private final MessageDetailsView messageDetailsView = new MessageDetailsViewImpl();

	/** The reply message view. */
	private final ReplyMessageView replyMessageView = new ReplyMessageViewImpl();

	/** The travel details view. */
	private final TravelDetailsView travelDetailsView = new TravelDetailsViewImpl();

	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory = GWT
			.create(CovoiturageRequestFactory.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getRequestFactory()
	 */
	@Override
	public CovoiturageRequestFactory getRequestFactory() {
		return requestFactory;
	}

	/**
	 * Instantiates a new client factory impl.
	 */
	public ClientFactoryImpl() {
		requestFactory.initialize(eventBus);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getEventBus()
	 */
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getPlaceController()
	 */
	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getLoginView()
	 */
	@Override
	public LoginView getLoginView() {
		return loginView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getMapView()
	 */
	@Override
	public MapView getMapView() {
		return mapView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getAddUserView()
	 */
	@Override
	public AddUserView getAddUserView() {
		return addUserView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getValidatePassengersView()
	 */
	@Override
	public ValidatePassengersView getValidatePassengersView() {
		return validatePassengersView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getSettingsView()
	 */
	@Override
	public SettingsView getSettingsView() {
		return settingsView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getMenuView()
	 */
	@Override
	public MenuView getMenuView() {
		return menuView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getHeaderView()
	 */
	@Override
	public HeaderView getHeaderView() {
		return headerView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getFooterView()
	 */
	@Override
	public FooterView getFooterView() {
		return footerView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getHistoryView()
	 */
	@Override
	public HistoryView getHistoryView() {
		return historyView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getMessagesListView()
	 */
	@Override
	public MessagesListView getMessagesListView() {
		return messagesListView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getMessageDetailsView()
	 */
	@Override
	public MessageDetailsView getMessageDetailsView() {
		return messageDetailsView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getReplyMessageView()
	 */
	@Override
	public ReplyMessageView getReplyMessageView() {
		return replyMessageView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.ClientFactory#getTravelDetailsView()
	 */
	@Override
	public TravelDetailsView getTravelDetailsView() {

		return travelDetailsView;
	}

}
