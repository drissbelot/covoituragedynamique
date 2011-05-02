package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class LicenceViewImpl extends Composite implements LicenceView{
	
	interface MyUiBinder extends UiBinder<FlowPanel, LicenceViewImpl> {}
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField
	RadioButton RadioAccpeted,RadioDenied;
	@UiField
	Button nextButton;
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	public LicenceViewImpl() {
		
		initWidget(binder.createAndBindUi(this));
	}
	
	public RadioButton getRadioAccepted(){
		return RadioAccpeted;
	}
	
	public RadioButton getRadioDenied(){
		return RadioDenied;
	}
	

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getNext() {
		return nextButton;
	}
}
