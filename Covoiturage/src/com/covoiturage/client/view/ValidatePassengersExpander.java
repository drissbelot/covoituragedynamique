package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class ValidatePassengersExpander extends ContentPanel {

	private final Image mapImage;
	private final Window window;

	public ValidatePassengersExpander(BaseModelData model) {
		VerticalPanel vertPanel = new VerticalPanel();
		Label nameLabel = new Label();

		Label date = new Label();
		mapImage = new Image(GWT.getHostPageBaseURL() + "imageService?id="
				+ model.get("login").toString());
		mapImage.setSize("200px", "200px");

		nameLabel.setText(model.get("firstName").toString() + " "
				+ model.get("lastName").toString());

		date.setText(model.get("date").toString());
		vertPanel.add(date);
		vertPanel.add(mapImage);
		vertPanel.add(nameLabel);

		this.add(vertPanel);
		window = new Window();
		window.setSize(500, 300);
		window.setPlain(true);
		window.setModal(true);
		window.setBlinkModal(true);
		window.setHeading("Image");
		window.setLayout(new FitLayout());

		window.addButton(new Button("Close",
				new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						window.hide();
					}
				}));
		getMapImage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				getImageZoom().show();

			}
		});
	}

	public Image getMapImage() {
		return mapImage;
	}

	public Window getImageZoom() {
		return window;
	}

}
