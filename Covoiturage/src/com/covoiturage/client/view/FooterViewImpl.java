/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.images.LanguageFlagsResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class FooterViewImpl.
 */
public class FooterViewImpl extends Composite implements FooterView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, FooterViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	/** The anchorch. */
	@UiField
	Anchor anchorfr, anchornl, anchoren, anchorit, anchorch;
	
	/** The imagech. */
	private final Image imagefr, imagenl, imageen, imageit, imagech;

	/**
	 * Instantiates a new footer view impl.
	 */
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

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#setPresenter(com.covoiturage.client.view.FooterView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#getAnchorfr()
	 */
	@Override
	public Anchor getAnchorfr() {
		return anchorfr;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#getAnchornl()
	 */
	@Override
	public Anchor getAnchornl() {
		return anchornl;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#getAnchoren()
	 */
	@Override
	public Anchor getAnchoren() {
		return anchoren;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#getAnchorit()
	 */
	@Override
	public Anchor getAnchorit() {
		return anchorit;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.FooterView#getAnchorch()
	 */
	@Override
	public Anchor getAnchorch() {
		return anchorch;
	}

}
