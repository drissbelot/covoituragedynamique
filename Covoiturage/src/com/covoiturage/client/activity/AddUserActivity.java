/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.AddUserEvent;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.resource.CovoiturageResources;
import com.covoiturage.client.view.AddUserView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.WidgetComponent;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Image;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserActivity.
 */
public class AddUserActivity extends AbstractActivity implements
		AddUserView.Presenter {

	/** The event bus. */
	private final EventBus eventBus;

	/** The add user view. */
	private final AddUserView addUserView;

	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;

	/** The place controller. */
	private final PlaceController placeController;
	private final CovoiturageResources covoiturageResources = GWT
			.create(CovoiturageResources.class);
	/** The image el. */
	private Element imageEl = null;

	/**
	 * Instantiates a new adds the user activity.
	 * 
	 * @param clientFactory
	 *            the client factory
	 */
	public AddUserActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.addUserView = clientFactory.getAddUserView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {

		addUserView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});
		addUserView.getLogin().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								covoiturageResources.valid()));

						if (addUserView.getLogin().validate()) {

							image.render(addUserView.getLogin().el()
									.getParent().dom);
							imageEl = addUserView.getLogin().el().getParent().dom
									.appendChild(image.getElement());

							image.el().alignTo(
									addUserView.getLogin().getElement(),
									"tl-tr", new int[] { 2, 3 });
							addUserView.getLogin().el().getParent()
									.setHeight(37);

						} else {
							if (imageEl != null)
								addUserView.getLogin().el().getParent().dom
										.removeChild(imageEl);

						}

					}
				});
		addUserView.getFirstName().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								covoiturageResources.valid()));

						if (addUserView.getFirstName().validate()) {

							image.render(addUserView.getFirstName().el()
									.getParent().dom);
							imageEl = addUserView.getFirstName().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									addUserView.getFirstName().getElement(),
									"tl-tr", new int[] { 2, 3 });
							addUserView.getFirstName().el().getParent()
									.setHeight(37);

						} else {
							if (imageEl != null)
								addUserView.getFirstName().el().getParent().dom
										.removeChild(imageEl);

						}

					}
				});
		addUserView.getLastName().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								covoiturageResources.valid()));

						if (addUserView.getLastName().validate()) {

							image.render(addUserView.getLastName().el()
									.getParent().dom);
							imageEl = addUserView.getLastName().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									addUserView.getLastName().getElement(),
									"tl-tr", new int[] { 2, 3 });
							addUserView.getLastName().el().getParent()
									.setHeight(37);

						} else {
							if (imageEl != null)
								addUserView.getLastName().el().getParent().dom
										.removeChild(imageEl);

						}

					}
				});
		addUserView.getEmailAddress().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								covoiturageResources.valid()));

						if (addUserView.getEmailAddress().validate()) {

							image.render(addUserView.getEmailAddress().el()
									.getParent().dom);
							imageEl = addUserView.getEmailAddress().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									addUserView.getEmailAddress().getElement(),
									"tl-tr", new int[] { 2, 3 });
							addUserView.getEmailAddress().el().getParent()
									.setHeight(37);

						} else {
							if (imageEl != null)
								addUserView.getEmailAddress().el().getParent().dom
										.removeChild(imageEl);

						}

					}
				});
		addUserView.getPassword().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								covoiturageResources.valid()));

						if (addUserView.getPassword().validate()) {

							image.render(addUserView.getPassword().el()
									.getParent().dom);
							imageEl = addUserView.getPassword().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									addUserView.getPassword().getElement(),
									"tl-tr", new int[] { 2, 3 });
							addUserView.getPassword().el().getParent()
									.setHeight(37);

						} else {
							if (imageEl != null)
								addUserView.getPassword().el().getParent().dom
										.removeChild(imageEl);

						}

					}
				});

	}

	/**
	 * Adds the user.
	 */
	protected void addUser() {

		UserInfoRequest request = requestFactory.userInfoRequest();
		Request<Boolean> loginExist = request.loginExist(addUserView.getLogin()
				.getValue());
		loginExist.fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean response) {
				if (response == false) {
					UserInfoRequest request = requestFactory.userInfoRequest();
					UserInfoProxy newUser = request.create(UserInfoProxy.class);
					newUser.setLogin(addUserView.getLogin().getValue());
					newUser.setPassword(addUserView.getPassword().getValue());
					newUser.setEmailAddress(addUserView.getEmailAddress()
							.getValue());

					Request<Long> createReq = request.persist(newUser);
					createReq.fire(new Receiver<Long>() {
						@Override
						public void onSuccess(Long response) {
							savePassengerDriver(response);
						}
					});
				} else {
					MessageBox.alert("Login already exist.",
							"Please choose another one",
							new Listener<MessageBoxEvent>() {

								@Override
								public void handleEvent(MessageBoxEvent be) {

								}
							});
				}

			}
		});

	}

	/**
	 * Save passenger driver.
	 * 
	 * @param newUser
	 *            the new user
	 */
	protected void savePassengerDriver(Long newUser) {

		UserInfoDetailsRequest requestDriver = requestFactory
				.userInfoDetailsRequest();
		UserInfoDetailsProxy newDriver = requestDriver
				.create(UserInfoDetailsProxy.class);
		newDriver.setUser(newUser);
		newDriver.setFirstName(addUserView.getFirstName().getValue());
		newDriver.setLastName(addUserView.getLastName().getValue());
		Request<Long> createReqDriver = requestDriver.persist(newDriver);

		createReqDriver.fire(new Receiver<Long>() {
			@Override
			public void onSuccess(Long response) {
				eventBus.fireEvent(new AddUserEvent());
				goTo(new LoginPlace(null));
			}

		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client
	 * .ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		addUserView.setPresenter(this);
		panel.setWidget(addUserView.asWidget());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.AddUserView.Presenter#goTo(com.google.gwt
	 * .place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
