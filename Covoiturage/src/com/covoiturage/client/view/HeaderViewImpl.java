/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.HeaderViewConstants;
import com.extjs.gxt.ui.client.widget.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class HeaderViewImpl.
 */
public class HeaderViewImpl extends Composite implements HeaderView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<HorizontalPanel, HeaderViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The constants. */
	private final HeaderViewConstants constants = (HeaderViewConstants) GWT
			.create(HeaderViewConstants.class);

	/** The logout. */
	@UiField
	Anchor logout;
	
	/** The messages. */
	@UiField
	Label currentUser, messages;
	
	/** The title. */
	@UiField
	Label title;
	
	/** The menu. */
	@UiField
	HorizontalPanel menu;
	
	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new header view impl.
	 */
	public HeaderViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HeaderView#setPresenter(com.covoiturage.client.view.HeaderView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HeaderView#getLogout()
	 */
	@Override
	public HasClickHandlers getLogout() {
		return logout;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HeaderView#getCurrentUser()
	 */
	@Override
	public Label getCurrentUser() {
		return currentUser;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HeaderView#getMessages()
	 */
	@Override
	public Label getMessages() {
		return messages;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.HeaderView#getConstants()
	 */
	@Override
	public HeaderViewConstants getConstants() {
		return constants;
	}
}
