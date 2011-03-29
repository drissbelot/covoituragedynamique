package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;




public class MenuViewImpl extends Composite implements MenuView {

	interface MyUiBinder extends UiBinder<FlowPanel, MenuViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    private MenuViewConstants constants=(MenuViewConstants)GWT.create(MenuViewConstants.class);
    
    @UiField Label mapLabel;
    @UiField Label settingsLabel;
    @UiField Label historyLabel;
    
	
	

	
	public MenuViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
		
		// internationalisation
		mapLabel.setText(constants.maplabel());
		settingsLabel.setText(constants.settings());
		historyLabel.setText(constants.history());
		
	}

	private Presenter presenter;


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
		
	}
	public HasClickHandlers getSettingsLabel() {

		return settingsLabel;
	}
	public HasClickHandlers getMapLabel() {

		return mapLabel;
	}


}
