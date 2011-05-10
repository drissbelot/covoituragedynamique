/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatePassengersExpanderViewImpl.
 */
public class ValidatePassengersExpanderViewImpl extends ContentPanel implements
		ValidatePassengersExpanderView {

	/** The map image. */
	private final Image mapImage;

	/** The window. */
	private final Window window;

	/** The details anchor. */
	private final Anchor detailsAnchor;

	/** The close button. */
	private final Button closeButton;

	/**
	 * Instantiates a new validate passengers expander view impl.
	 * 
	 * @param model
	 *            the model
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.ValidatePassengersExpanderView#getMapImage()
	 */
	@Override
	public Image getMapImage() {
		return mapImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.ValidatePassengersExpanderView#getImageZoom()
	 */
	@Override
	public Window getImageZoom() {
		return window;
	}

	/**
	 * Gets the details anchor.
	 * 
	 * @return the details anchor
	 */
	public Anchor getDetailsAnchor() {
		return detailsAnchor;
	}

	/**
	 * Gets the close button.
	 * 
	 * @return the close button
	 */
	public Button getCloseButton() {
		return closeButton;
	}

}
