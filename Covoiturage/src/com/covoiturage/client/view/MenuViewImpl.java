package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class MenuViewImpl extends Composite implements MenuView {

	interface MyUiBinder extends UiBinder<FormPanel, MenuViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final MenuViewConstants constants = (MenuViewConstants) GWT
			.create(MenuViewConstants.class);

	@UiField
	FormPanel menutitre;
	@UiField
	Label mapLabel;
	@UiField
	Label settingsLabel;
	@UiField
	Label historyLabel;
	@UiField
	Label messagesLabel;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public MenuViewImpl() {
		initWidget(binder.createAndBindUi(this));

		// internationalization
		mapLabel.setText(constants.maplabel());
		settingsLabel.setText(constants.settings());
		historyLabel.setText(constants.history());
		menutitre.setHeading(constants.menutitle());
		messagesLabel.setText("Messages");

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasClickHandlers getSettingsLabel() {
		return settingsLabel;
	}

	@Override
	public HasClickHandlers getMapLabel() {
		return mapLabel;
	}

	@Override
	public HasClickHandlers getHistoryLabel() {
		return historyLabel;
	}

	@Override
	public Label getMessagesLabel() {
		return messagesLabel;
	}

}
