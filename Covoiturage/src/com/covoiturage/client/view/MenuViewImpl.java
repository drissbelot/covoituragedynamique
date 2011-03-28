package com.covoiturage.client.view;

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
    
    @UiField Label mapLabel;
    @UiField Label settingsLabel;
    @UiField Label historyLabel;
	
	

	
	public MenuViewImpl() {
		initWidget(binder.createAndBindUi(this)); 

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
