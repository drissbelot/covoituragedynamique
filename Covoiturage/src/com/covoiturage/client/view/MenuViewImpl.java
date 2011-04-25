package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class MenuViewImpl extends Composite implements MenuView {

	interface MyUiBinder extends UiBinder<ContentPanel, MenuViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final MenuViewConstants constants = (MenuViewConstants) GWT
			.create(MenuViewConstants.class);
	@UiField
	ContentPanel menuPanel;
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

		menuPanel.setHeaderVisible(true);

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Label getSettingsLabel() {
		return settingsLabel;
	}

	@Override
	public Label getMapLabel() {
		return mapLabel;
	}

	@Override
	public Label getHistoryLabel() {
		return historyLabel;
	}

	@Override
	public Label getMessagesLabel() {
		return messagesLabel;
	}

	@Override
	public MenuViewConstants getConstants() {
		return constants;
	}

}
