package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.view.FooterView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FooterActivity extends AbstractActivity implements
		FooterView.Presenter {

	FooterView footerView;
	private final PlaceController placeController;

	public FooterActivity(ClientFactory clientFactory) {
		this.footerView = clientFactory.getFooterView();
		this.placeController = clientFactory.getPlaceController();

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		footerView.setPresenter(this);
		panel.setWidget(footerView.asWidget());

	}

	private void bind() {
		footerView.getAnchoren().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UrlBuilder url = Window.Location.createUrlBuilder()
						.setParameter("locale", "en");
				Window.Location.replace(url.buildString());
			}
		});
		footerView.getAnchorfr().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UrlBuilder url = Window.Location.createUrlBuilder()
						.setParameter("locale", "fr");
				Window.Location.replace(url.buildString());
			}
		});
		footerView.getAnchorit().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UrlBuilder url = Window.Location.createUrlBuilder()
						.setParameter("locale", "it");
				Window.Location.replace(url.buildString());
			}
		});
		footerView.getAnchorch().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UrlBuilder url = Window.Location.createUrlBuilder()
						.setParameter("locale", "ch");
				Window.Location.replace(url.buildString());
			}
		});
		footerView.getAnchornl().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				UrlBuilder url = Window.Location.createUrlBuilder()
						.setParameter("locale", "nl");
				Window.Location.replace(url.buildString());
			}
		});
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
