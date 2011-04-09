package com.covoiturage.client.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;


public class HistoryViewImpl extends Composite implements HistoryView{
	
	interface MyUiBinder extends UiBinder<FlowPanel, HistoryViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	@SuppressWarnings("unused")
	private Presenter presenter;
	//TODO mettre quelque chose pour afficher les journeys et les simpletravels
	
	public HistoryViewImpl(){
		initWidget(binder.createAndBindUi(this)); 
	
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	
	
}
