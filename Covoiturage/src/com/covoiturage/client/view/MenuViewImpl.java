/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuViewImpl.
 */
public class MenuViewImpl extends Composite implements MenuView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<ContentPanel, MenuViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The constants. */
	private final MenuViewConstants constants = (MenuViewConstants) GWT
			.create(MenuViewConstants.class);

	/** The menu panel. */
	@UiField
	ContentPanel menuPanel;

	/** The map label. */
	@UiField
	Label mapLabel;

	/** The settings label. */
	@UiField
	Label settingsLabel;

	/** The history label. */
	@UiField
	Label historyLabel;

	/** The messages label. */
	@UiField
	Label messagesLabel;

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new menu view impl.
	 */
	public MenuViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.MenuView#setPresenter(com.covoiturage.client
	 * .view.MenuView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MenuView#getSettingsLabel()
	 */
	@Override
	public Label getSettingsLabel() {
		return settingsLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MenuView#getMapLabel()
	 */
	@Override
	public Label getMapLabel() {
		return mapLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MenuView#getHistoryLabel()
	 */
	@Override
	public Label getHistoryLabel() {
		return historyLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MenuView#getMessagesLabel()
	 */
	@Override
	public Label getMessagesLabel() {
		return messagesLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MenuView#getConstants()
	 */
	@Override
	public MenuViewConstants getConstants() {
		return constants;
	}

}
