package com.covoiturage.client.view;

import com.covoiturage.client.images.CovoiturageResources;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;

public interface MapView extends IsWidget {

	public RadioButton getPassengerRadioButton();

	public RadioButton getDriverRadioButton();

	public DateField getDateOfJourney();

	public HasClickHandlers getSendAddressButton();

	public SuggestBox getOriginAddress();

	public SuggestBox getDestinationAddress();

	public MapWidget getMap();

	public ContentPanel getDirectionsPanel();

	public Button getSaveJourneyButton();

	public float getDistanceMax();

	public FlowPanel getMapDecorator();

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

	public void setOriginAddress(SuggestBox suggestBox);

	public void setDestinationAddress(String destinationAddress);

	public TextField<String> getDepartureStartTime();

	public TextField<String> getDepartureEndTime();

	public TextField<String> getArrivalTime();

	public TextArea getCommentField();

	public Label getDistance();

	public Label getDuration();

	public CovoiturageResources getCovoiturageResources();

	public FormPanel getData();

	public Label getDistanceDelta();

	public Label getDurationDelta();

}