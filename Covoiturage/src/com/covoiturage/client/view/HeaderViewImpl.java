package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;




public class HeaderViewImpl extends Composite implements HeaderView {

	interface MyUiBinder extends UiBinder<HorizontalPanel, HeaderViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    

	@UiField Anchor logout;
	
	public HeaderViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
	}

	private Presenter presenter;


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
		
	}

	public HasClickHandlers getLogout() {

		return logout;
	}

}
