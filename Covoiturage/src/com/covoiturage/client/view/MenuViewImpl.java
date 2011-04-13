package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuViewImpl extends Composite implements MenuView {

	interface MyUiBinder extends UiBinder<VerticalPanel, MenuViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    private MenuViewConstants constants=(MenuViewConstants)GWT.create(MenuViewConstants.class);
    
    @UiField Label menutitre;
    @UiField Label mapLabel;
    @UiField Label settingsLabel;
    @UiField Label historyLabel;
    @UiField Label messagesLabel;
    
	@SuppressWarnings("unused")
	private Presenter presenter;

	
	public MenuViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
		
		// internationalization
		mapLabel.setText(constants.maplabel());
		settingsLabel.setText(constants.settings());
		historyLabel.setText(constants.history());
		menutitre.setText(constants.menutitle());
		messagesLabel.setText("Messages");
		
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	public HasClickHandlers getSettingsLabel() {
		return settingsLabel;
	}
	public HasClickHandlers getMapLabel() {
		return mapLabel;
	}
	public HasClickHandlers getHistoryLabel(){
		return historyLabel;
	}
	public HasClickHandlers getMessagesLabel(){
		return messagesLabel;
	}


}
