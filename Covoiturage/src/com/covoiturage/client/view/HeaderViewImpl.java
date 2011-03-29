package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.smartgwt.client.widgets.Label;





public class HeaderViewImpl extends Composite implements HeaderView {

	interface MyUiBinder extends UiBinder<HorizontalPanel, HeaderViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    

	@UiField Anchor logout;
	@UiField Label currentUser;
	@UiField Label messages;
	@UiField HorizontalPanel menu;
	
	public HeaderViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
		messages.setTitle("Messages :");
	}

	private Presenter presenter;


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
		
	}

	public HasClickHandlers getLogout() {

		return logout;
	}
	public Label getCurrentUser() {

		return currentUser;
	}

	@Override
	public Label getMessages() {
		return messages;
	}
}
