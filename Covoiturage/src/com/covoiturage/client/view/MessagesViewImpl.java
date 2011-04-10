package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MessagesViewConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessagesViewImpl extends Composite implements MessagesView {

	interface MyUiBinder extends UiBinder<VerticalPanel, MessagesViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    private MessagesViewConstants constants=(MessagesViewConstants)GWT.create(MessagesViewConstants.class);
    

	@SuppressWarnings("unused")
	private Presenter presenter;

	
	public MessagesViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
		

		
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}



}
