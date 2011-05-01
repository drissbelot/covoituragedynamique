package com.covoiturage.client.view;

import com.covoiturage.client.images.LanguageFlagsResources;
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
	private final Image imagefr, imagenl, imageen, imageit, imagech;

	public FooterViewImpl() {
		initWidget(binder.createAndBindUi(this));
		LanguageFlagsResources languageFlags = GWT
				.create(LanguageFlagsResources.class);

		imagefr = new Image(languageFlags.flag_fr());
		imagenl = new Image(languageFlags.flag_nl());
		imageen = new Image(languageFlags.flag_en());
		imageit = new Image(languageFlags.flag_it());
		imagech = new Image(languageFlags.flag_ch());

		anchorfr.getElement().appendChild(imagefr.getElement());
		anchornl.getElement().appendChild(imagenl.getElement());
		anchoren.getElement().appendChild(imageen.getElement());
		anchorit.getElement().appendChild(imageit.getElement());
		anchorch.getElement().appendChild(imagech.getElement());

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Anchor getAnchorfr() {
		return anchorfr;
	}

	@Override
	public Anchor getAnchornl() {
		return anchornl;
	}

	@Override
	public Anchor getAnchoren() {
		return anchoren;
	}

	@Override
	public Anchor getAnchorit() {
		return anchorit;
	}

	@Override
	public Anchor getAnchorch() {
		return anchorch;
	}

}
