package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

public class FooterViewImpl extends Composite implements FooterView {

	interface MyUiBinder extends UiBinder<FlowPanel, FooterViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	@SuppressWarnings("unused")
	private Presenter presenter;
	@UiField
	Anchor anchorfr, anchornl, anchoren, anchorit, anchorch;
	private Image imagefr, imagenl, imageen, imageit, imagech;

	public FooterViewImpl() {
		initWidget(binder.createAndBindUi(this));
		// TODO utiliser des images en local
		// TODO utiliser le MVP
		imagefr = new Image("LocalPictures/icon_fr.png");
		imagenl = new Image("LocalPictures/icon_nl.png");
		imageen = new Image("LocalPictures/icon_en.png");
		imageit = new Image("LocalPictures/icon_it.png");
		imagech = new Image("LocalPictures/icon_ch.png");
	
		imagefr.setSize("30px", "25px");
		imagenl.setSize("30px", "25px");
		imageen.setSize("30px", "25px");
		imageit.setSize("30px", "25px");
		imagech.setSize("30px", "25px");

		anchorfr.setHref(GWT.getHostPageBaseURL() + "?locale=fr");
		anchorfr.getElement().appendChild(imagefr.getElement());
		anchornl.setHref(GWT.getHostPageBaseURL() + "?locale=nl");
		anchornl.getElement().appendChild(imagenl.getElement());
		anchoren.setHref(GWT.getHostPageBaseURL() + "?locale=en");
		anchoren.getElement().appendChild(imageen.getElement());
		anchorit.setHref(GWT.getHostPageBaseURL() + "?locale=it");
		anchorit.getElement().appendChild(imageit.getElement());
		anchorch.setHref(GWT.getHostPageBaseURL() + "?locale=ch");
		anchorch.getElement().appendChild(imagech.getElement());

	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
