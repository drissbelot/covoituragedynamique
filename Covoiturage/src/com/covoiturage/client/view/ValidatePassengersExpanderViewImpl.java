package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

public class ValidatePassengersExpanderViewImpl extends ContentPanel implements
		ValidatePassengersExpanderView {

	private final Image mapImage;
	private final Window window;

	private final Anchor detailsAnchor;
	private final Button closeButton;

	public ValidatePassengersExpanderViewImpl(BaseModelData model) {
		VerticalPanel vertPanel = new VerticalPanel();
		Label nameLabel = new Label();

		Label date = new Label();
		mapImage = new Image(GWT.getHostPageBaseURL() + "imageService?class="
				+ model.get("type").toString() + "&id="
				+ model.get("id").toString());
		mapImage.setTitle("Click to zoom");

		mapImage.setSize("200px", "200px");

		nameLabel.setText(model.get("firstName").toString() + " "
				+ model.get("lastName").toString());

		date.setText(model.get("date").toString());
		vertPanel.add(date);
		vertPanel.add(mapImage);
		vertPanel.add(nameLabel);
		detailsAnchor = new Anchor("More details");
		vertPanel.add(detailsAnchor);
		this.add(vertPanel);
		window = new Window();
		window.setSize(500, 500);
		window.setPlain(true);
		window.setModal(true);
		window.setBlinkModal(true);
		window.setHeading("Image");
		window.setLayout(new FitLayout());
		window.add(new Image(GWT.getHostPageBaseURL() + "imageService?class="
				+ model.get("type").toString() + "&id="
				+ model.get("id").toString()));
		closeButton = new Button("Close");
		window.addButton(closeButton);

	}

	@Override
	public Image getMapImage() {
		return mapImage;
	}

	@Override
	public Window getImageZoom() {
		return window;
	}

	public Anchor getDetailsAnchor() {
		return detailsAnchor;
	}

	public Button getCloseButton() {
		return closeButton;
	}

}
