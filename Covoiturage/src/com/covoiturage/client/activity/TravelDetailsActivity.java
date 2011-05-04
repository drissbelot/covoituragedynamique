package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.images.CarResources;
import com.covoiturage.client.images.LanguageFlagsResources;
import com.covoiturage.client.images.RatingResources;
import com.covoiturage.client.place.TravelDetailsPlace;
import com.covoiturage.client.view.TravelDetailsView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Image;

public class TravelDetailsActivity extends AbstractActivity implements
		TravelDetailsView.Presenter {

	private final TravelDetailsView travelDetailsView;

	private final PlaceController placeController;
	private final CovoiturageRequestFactory requestFactory;

	private UserInfoProxy currentUser;

	private final LanguageFlagsResources languageFlags = GWT
			.create(LanguageFlagsResources.class);
	private final RatingResources ratingResources = GWT
			.create(RatingResources.class);
	private final CarResources carResources = GWT.create(CarResources.class);

	private String where;

	public TravelDetailsActivity(ClientFactory clientFactory) {

		this.travelDetailsView = clientFactory.getTravelDetailsView();
		this.placeController = clientFactory.getPlaceController();
		this.requestFactory = clientFactory.getRequestFactory();

	}

	private void bind() {

		where = ((TravelDetailsPlace) placeController.getWhere())
				.getTravelDetailsName();
		if (where.contains("Journey")) {
			JourneyRequest requestJourney = requestFactory.journeyRequest();
			Request<JourneyProxy> createReqJourney = requestJourney
					.findJourney(Long.valueOf(where.substring(7)));
			createReqJourney.fire(new Receiver<JourneyProxy>() {

				@Override
				public void onSuccess(JourneyProxy response) {
					travelDetailsView.getDepartureField().setValue(
							response.getDepartureStart().toString());
					travelDetailsView.getArrivalField().setValue(
							response.getArrival().toString());
					travelDetailsView.getDistanceField().setValue(
							Double.toString(response.getDistance()));
					travelDetailsView.getDurationField().setValue(
							Double.toString(response.getDuration()));

					travelDetailsView.setMapImage(new Image(GWT
							.getHostPageBaseURL()
							+ "imageService?class=Journey&id="
							+ response.getId().toString()));

				}
			});

		} else if (where.contains("SimpleTravel")) {
			SimpleTravelRequest requestSimpleTravel = requestFactory
					.simpleTravelRequest();
			Request<SimpleTravelProxy> createReqSimpleTravel = requestSimpleTravel
					.findSimpleTravel(Long.valueOf(where.substring(12)));
			createReqSimpleTravel.fire(new Receiver<SimpleTravelProxy>() {

				@Override
				public void onSuccess(SimpleTravelProxy response) {
					travelDetailsView.getDepartureField().setValue(
							response.getDepartureStart().toString());
					travelDetailsView.getArrivalField().setValue(
							response.getArrival().toString());
					travelDetailsView.getDistanceField().setValue(
							Double.toString(response.getDistance()));
					travelDetailsView.getDurationField().setValue(
							Double.toString(response.getDuration()));
					travelDetailsView.getPlacesField().hide();
					travelDetailsView.getVehiculeTab().hide();
					travelDetailsView.setMapImage(new Image(GWT
							.getHostPageBaseURL()
							+ "imageService?class=SimpleTravel&id="
							+ response.getId().toString()));

				}
			});
		}
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		travelDetailsView.setPresenter(this);
		panel.setWidget(travelDetailsView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
